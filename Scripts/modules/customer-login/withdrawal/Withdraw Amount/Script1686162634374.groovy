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

// Click on "Withdrawl" tab button
WebUI.verifyElementPresent(findTestObject('Web-XYZBank/customer-login/common/button_Withdrawl Tab'), 10)
WebUI.click(findTestObject('Web-XYZBank/customer-login/common/button_Withdrawl Tab'))

// Enter Amount to be Withdrawn
WebUI.waitForElementVisible(findTestObject('Web-XYZBank/customer-login/withdrawal/input_Amount Withdrawn'), 10)
WebUI.setText(findTestObject('Web-XYZBank/customer-login/withdrawal/input_Amount Withdrawn'), withdrawAmount)

// Click on "Withdraw" button to submit
WebUI.click(findTestObject('Web-XYZBank/customer-login/withdrawal/button_Withdraw'))

// Verify success message
WebUI.verifyElementPresent(findTestObject('Web-XYZBank/customer-login/withdrawal/label_Transaction Successful'), 10)