import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testdata.TestData

// Load the data source
TestData testData = findTestData(dataPath)

// Get current balance before performing transactions
int actBalance = WebUI.getText(findTestObject('Web-XYZBank/customer-login/common/text_Current Balance')).toInteger()
int expBalance = actBalance

WebUI.comment("Initial balance: " + actBalance)

for (int index = 1; index <= testData.getRowNumbers(); index++) {	
    // Get the data from the current row
    String amount = testData.getValue("Amount", index)
    String transactionType = testData.getValue("Transaction Type", index)
	
	// Perform transaction based on transaction type
	switch (transactionType.toLowerCase()) {
    case 'credit':
        WebUI.callTestCase(findTestCase('Test Cases/modules/customer-login/deposit/Deposit Amount'), [('depositAmount') : amount])
		expBalance = expBalance + amount.toInteger()
		WebUI.comment("Credit: " + amount + ", Current Balance: " + expBalance)
        break
    case 'debit':
        WebUI.callTestCase(findTestCase('Test Cases/modules/customer-login/withdrawal/Withdraw Amount'), [('withdrawAmount') : amount])
		expBalance = expBalance - amount.toInteger()
		WebUI.comment("Debit: " + amount + ", Current Balance: " + expBalance)
        break
    default:
        WebUI.comment('Invalid transaction type!')
	}
}

// Verify the current balance is tally with Balance section in the Customer Homepage
actBalance = WebUI.getText(findTestObject('Web-XYZBank/customer-login/common/text_Current Balance')).toInteger()
WebUI.verifyEqual(actBalance, expBalance)
WebUI.comment("Verified that the current balance is tally with Balance section which is " + expBalance)