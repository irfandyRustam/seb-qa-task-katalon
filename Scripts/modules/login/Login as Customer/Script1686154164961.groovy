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

// Open browser and navigate to homepage URL 
WebUI.openBrowser(GlobalVariable.indexURL)
WebUI.maximizeWindow()

// Verify Header are present and page title are correct
WebUI.verifyElementPresent(findTestObject('Web-XYZBank/home-page/header_XYZ Bank'), 20)
pageTitle = WebUI.getWindowTitle()
WebUI.verifyEqual(pageTitle, 'XYZ Bank')

// Click on "Customer Login" button
WebUI.click(findTestObject('Web-XYZBank/home-page/button_Customer Login'))

// Verify user redirect to Customer Login page
WebUI.verifyElementPresent(findTestObject('Web-XYZBank/customer-login/common/dropdown_Your Name'), 10)

// Select Customer Name to Login As
WebUI.selectOptionByLabel(findTestObject('Web-XYZBank/customer-login/common/dropdown_Your Name'), customerName, false)

// Click "Login" button
WebUI.click(findTestObject('Web-XYZBank/customer-login/common/button_Login'))

// Verify Login Successful
WebUI.verifyElementPresent(findTestObject('Web-XYZBank/customer-login/common/header_Customer Name'), 10)
String headerName = WebUI.getText(findTestObject('Web-XYZBank/customer-login/common/header_Customer Name'))
WebUI.verifyMatch(headerName, customerName, false)
WebUI.comment("Customer login successfuly as " + customerName)