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

// Test Data path
String customerDataPath = "Data Files/CustomersData"
String customerToDeletePath = "Data Files/CustomersDataToDelete"

// Login as "Bank Manager"
WebUI.callTestCase(findTestCase('Test Cases/modules/login/Login as Bank Manager'), null)

// Create new customers under "Add Customer" module
WebUI.callTestCase(findTestCase('Test Cases/modules/bank-manager-login/add-customer/Add Customers'), ['dataPath': customerDataPath])

// Verify customers created previously inserted in the table under "Customers" module
WebUI.callTestCase(findTestCase('Test Cases/modules/bank-manager-login/customers/Verify Customers Added in Customers Record'), ['dataPath': customerDataPath])

// Delete specific customers data 
WebUI.callTestCase(findTestCase('Test Cases/modules/bank-manager-login/customers/Delete Customers'), ['dataPath': customerToDeletePath])