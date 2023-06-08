import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testdata.TestDataFactory
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

// Click on "Add Customer" tab button
WebUI.click(findTestObject('Web-XYZBank/bank-manager-login/add-customer/button_Add Customer Tab'))

// Find the test objects outside the loop
TestObject firstNameInput = findTestObject('Web-XYZBank/bank-manager-login/add-customer/input_First Name')
TestObject lastNameInput = findTestObject('Web-XYZBank/bank-manager-login/add-customer/input_Last Name')
TestObject postCodeInput = findTestObject('Web-XYZBank/bank-manager-login/add-customer/input_Post Code')
TestObject addCustomerButton = findTestObject('Web-XYZBank/bank-manager-login/add-customer/button_Add Customer')

// Iterate over the data rows
int totalCustomerAdded = 0
for (int index = 1; index <= testData.getRowNumbers(); index++) {
	WebUI.comment("***** Customer No " + index + " *****")
	
    // Get the data from the current row
    String firstName = testData.getValue("First Name", index)
    String lastName = testData.getValue("Last Name", index)
    String postCode = testData.getValue("Post Code", index)
	
    // Enter First Name
    WebUI.waitForElementVisible(firstNameInput, 10)
    WebUI.setText(firstNameInput, firstName)

    // Enter Last Name
    WebUI.waitForElementVisible(lastNameInput, 10)
    WebUI.setText(lastNameInput, lastName)

    // Enter Post Code
    WebUI.waitForElementVisible(postCodeInput, 10)
    WebUI.setText(postCodeInput, postCode)

    // Click on "Add Customer" button
    WebUI.waitForElementClickable(addCustomerButton, 10)
    WebUI.click(addCustomerButton)

    // Verify alert that customer has been added successfully
	if(WebUI.verifyAlertPresent(2, FailureHandling.OPTIONAL)) {
		String alertText = WebUI.getAlertText()
		WebUI.comment("Alert Text: " + alertText)
		WebUI.verifyMatch(alertText, 'Customer added successfully with customer id :(\\d+)', true)
	} else {
		WebUI.comment("Alert message not displayed!")
	}
	totalCustomerAdded++
}

WebUI.comment("Total New Customers Added: " + totalCustomerAdded)