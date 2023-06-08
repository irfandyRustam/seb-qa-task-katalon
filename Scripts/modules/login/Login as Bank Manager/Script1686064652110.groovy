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

// List of elements in Bank Manager page
List<TestObject> elementsToVerify = [
	findTestObject('Web-XYZBank/bank-manager-login/add-customer/button_Add Customer Tab'),
	findTestObject('Web-XYZBank/bank-manager-login/customers/button_Customers Tab'),
	findTestObject('Web-XYZBank/bank-manager-login/open-account/button_Open Account Tab')
]

// Open browser and navigate to homepage URL 
WebUI.openBrowser(GlobalVariable.indexURL)
WebUI.maximizeWindow()

// Verify Header are present and page title are correct
WebUI.verifyElementPresent(findTestObject('Web-XYZBank/home-page/header_XYZ Bank'), 20)
pageTitle = WebUI.getWindowTitle()
WebUI.verifyEqual(pageTitle, 'XYZ Bank')

// Click on "Bank Manager Login" button
WebUI.click(findTestObject('Web-XYZBank/home-page/button_Bank Manager Login'))

// Verify user redirect to Bank Manager page
CustomKeywords.'common.webGeneral.verifyElementsPresent'(elementsToVerify, 10)