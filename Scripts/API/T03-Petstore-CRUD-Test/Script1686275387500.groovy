import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.apache.commons.lang3.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.util.KeywordUtil

JsonSlurper jsonSlurper = new JsonSlurper()
RequestObject request = new RequestObject()
ResponseObject response = new ResponseObject()

int randomNo = Integer.parseInt(RandomStringUtils.randomNumeric(2))
String randomUsername = RandomStringUtils.randomAlphanumeric(10)
String randomFName = RandomStringUtils.randomAlphanumeric(5)
String randomLName = RandomStringUtils.randomAlphanumeric(5)
String randomEmail = randomFName + randomLName + "@email.com"
String randomPassword = RandomStringUtils.randomAlphanumeric(10)

// Request Body to pass for create new user
def requestBody = [('id') : randomNo, ('username') : randomUsername, ('firstName') : randomFName, ('lastName') : randomLName, ('email') : randomEmail
    , ('password') : randomPassword, ('phone') : '666666', ('userStatus') : randomNo]
String username = requestBody.("username")
KeywordUtil.logInfo("Request Body: " + requestBody)

// Function to send request and verify response status code
def verifyResponse(response, expectedStatusCode) {
	WS.verifyResponseStatusCode(response, expectedStatusCode, FailureHandling.OPTIONAL)
	def responseBody = response.getResponseText()
	KeywordUtil.logInfo("Response: " + responseBody)
	return responseBody
}

// Create a new user
response = WS.sendRequest(findTestObject('API-Petstore/POST Create user', requestBody))
verifyResponse(response, 200)

// Read the created user
response = WS.sendRequest(findTestObject('API-Petstore/GET User by username', ['username': username]))
verifyResponse(response, 200)

// Update the user’s username
response = WS.sendRequest(findTestObject('API-Petstore/PUT Update username', ['username': username]))
verifyResponse(response, 200)

// Read the updated user
response = WS.sendRequest(findTestObject('API-Petstore/GET User by username', ['username': username]))
verifyResponse(response, 200)

// Delete the user
response = WS.sendRequest(findTestObject('API-Petstore/DELETE User', ['username': username]))
verifyResponse(response, 200)

// Verify the user is deleted
response = WS.sendRequest(findTestObject('API-Petstore/GET User by username', ['username': username]))
verifyResponse(response, 404)
