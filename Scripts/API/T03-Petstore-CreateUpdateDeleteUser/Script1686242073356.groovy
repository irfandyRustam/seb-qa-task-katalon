import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper


// Create a new user

// Read the created user
def response = WS.sendRequestAndVerify(findTestObject('API-Petstore/GET User by username', ['username': 'user1']))

// Update the user’s username

// Read the updated user

// Delete the user

// Verify the user is deleted