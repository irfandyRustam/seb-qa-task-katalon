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

// Load the data source
TestData testData = findTestData(dataPath)

// Verify Customers table is present
WebUI.verifyElementPresent(findTestObject('Web-XYZBank/bank-manager-login/customers/table_Customers'), 10)

// Delete the specific customer
for (int index = 1; index <= testData.getRowNumbers(); index++) {
	WebUI.comment("***** Customer No " + index + " *****")
	
	// Get the data from the current row
	String firstName = testData.getValue("First Name", index)
	String lastName = testData.getValue("Last Name", index)
	String postCode = testData.getValue("Post Code", index)
	
	// Click "Delete" button from table row for specific customer
    WebUI.click(findTestObject('Web-XYZBank/bank-manager-login/customers/button_Delete Specific',
            ['firstName': firstName, 'lastName': lastName, 'postCode': postCode]))

    // Verify customer deleted successfully
    boolean isDeleted = WebUI.verifyElementNotPresent(findTestObject('Web-XYZBank/bank-manager-login/customers/tr_CustomerData',
            ['firstName': firstName, 'lastName': lastName, 'postCode': postCode]), 1)

    // Assert customer deletion
    assert isDeleted == true : "The customer data is not deleted from the Customers table!"
    WebUI.comment("Verified that the customer data for --> First Name: $firstName, Last Name: $lastName, Post Code: $postCode have been deleted successfully")
}
