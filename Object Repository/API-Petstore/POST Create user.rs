<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Get user by user name</description>
   <name>POST Create user</name>
   <tag></tag>
   <elementGuidId>d63616ce-df72-42d8-8894-66218c76370b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;id\&quot;: ${id},\n  \&quot;username\&quot;: \&quot;${username}\&quot;,\n  \&quot;firstName\&quot;: \&quot;${firstName}\&quot;,\n  \&quot;lastName\&quot;: \&quot;${lastName}\&quot;,\n  \&quot;email\&quot;: \&quot;${email}\&quot;,\n  \&quot;password\&quot;: \&quot;${password}\&quot;,\n  \&quot;phone\&quot;: \&quot;${phone}\&quot;,\n  \&quot;userStatus\&quot;: ${userStatus}\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>dcbd4ee6-08db-406f-9e5a-c998981c5b52</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.baseURL}/user</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>10</defaultValue>
      <description></description>
      <id>5c30ecca-0d1d-4e33-8b8f-d0c3e31a5b00</id>
      <masked>false</masked>
      <name>id</name>
   </variables>
   <variables>
      <defaultValue>'theUser'</defaultValue>
      <description></description>
      <id>c67a7ce7-6240-42c5-ba9a-9036ee2c9c23</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>'John'</defaultValue>
      <description></description>
      <id>7984dab6-b212-4aba-ac11-cbaf80a38712</id>
      <masked>false</masked>
      <name>firstName</name>
   </variables>
   <variables>
      <defaultValue>'Cena'</defaultValue>
      <description></description>
      <id>ab9bd79c-3f17-44a5-9a0c-395cfb116452</id>
      <masked>false</masked>
      <name>lastName</name>
   </variables>
   <variables>
      <defaultValue>'johnCena@gmail.com'</defaultValue>
      <description></description>
      <id>1a23311d-ea04-4df8-90f6-6d66792aa492</id>
      <masked>false</masked>
      <name>email</name>
   </variables>
   <variables>
      <defaultValue>'12345'</defaultValue>
      <description></description>
      <id>ee4bd9f4-cacd-4bd3-a444-91f1c6aacf0d</id>
      <masked>false</masked>
      <name>password</name>
   </variables>
   <variables>
      <defaultValue>'12345'</defaultValue>
      <description></description>
      <id>59f267a4-3aa9-408e-8e1c-7b5a5a414ff5</id>
      <masked>false</masked>
      <name>phone</name>
   </variables>
   <variables>
      <defaultValue>1</defaultValue>
      <description></description>
      <id>a6ed3b3c-41a3-4bff-9c86-8415a5234915</id>
      <masked>false</masked>
      <name>userStatus</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()
ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyResponseStatusCode(response, 200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
