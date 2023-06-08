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

// Click on "Customers" tab button
WebUI.click(findTestObject('Web-XYZBank/bank-manager-login/customers/button_Customers Tab'))

// Verify Customers record table is present
WebUI.verifyElementPresent(findTestObject('Web-XYZBank/bank-manager-login/customers/table_Customers'), 10)

// Verify if the data is present in the customers table
boolean allDataPresent = true
for (int index = 1; index <= testData.getRowNumbers(); index++) {
	// Retrieve the data from the TestData file
	String firstName = testData.getValue("First Name", index)
	String lastName = testData.getValue("Last Name", index)
	String postCode = testData.getValue("Post Code", index)

	// Check the table row and handle missing data
	if (!WebUI.verifyElementVisible(findTestObject('Web-XYZBank/bank-manager-login/customers/tr_CustomerData',
			['firstName': firstName, 'lastName': lastName, 'postCode': postCode]))) {
		allDataPresent = false
		WebUI.comment("First Name: $firstName, Last Name: $lastName, Post Code: $postCode --> This data is missing inside the table!")
		break
	} else {
		WebUI.comment("First Name: $firstName, Last Name: $lastName, Post Code: $postCode --> This data is present inside the table")
	}
}

// Assert if all data is present in the customers table
assert allDataPresent == true : "There are missing customer data inside the customers table!"
WebUI.comment("Verified that all customers data added is present in the customers table")