# CodeChallenge_SeeraGroup
RestAssured API Automation : Required to automate one POST & one GET API from **Hotels** module of the website "https://ae.almosafer.com/en"


# RestAssured API Framework: (using TestNG & Maven)

**#Steps to Clone and Run the Project:**
1. In the command prompt or GitBash type :

     git clone https://github.com/VarunSharma-89/SeeraAPIChallenge.git

2. Or simply download the ZIP.
![image](https://user-images.githubusercontent.com/86568081/163879450-5848d4eb-f110-45f0-951f-acdb2b6fffdf.png)



3. After cloning or downloading, import as an Existing Maven Projects in Eclipse
![image](https://user-images.githubusercontent.com/86568081/163868445-03738d08-b4e8-4b6d-b906-459ab4bee7f8.png)
![image](https://user-images.githubusercontent.com/86568081/163868537-05295410-39c7-4141-b275-4562947073e1.png)
![image](https://user-images.githubusercontent.com/86568081/163868643-b94b5005-6392-4d29-bcda-2d098c5e13ba.png)


4. Now run the tests using "testng.xml" file.
![image](https://user-images.githubusercontent.com/86568081/163869041-09526e58-e775-45d4-a8ec-1815a2b647bf.png)


5. You can check the reports and test execution on below highlighted files and section : (Junit reports, TestNG reports (using 'ExtentReports.html' and 'index.html') 
![image](https://user-images.githubusercontent.com/86568081/163870002-a58ee02a-8855-4e68-84bc-f79d3cf7390c.png)


6. You can also run the tests by using the command "mvn test" in the Command Prompt.
![image](https://user-images.githubusercontent.com/86568081/163886501-8788222a-15f5-435c-998b-b747fddfb292.png)
![image](https://user-images.githubusercontent.com/86568081/163886590-6b204e91-7c52-417a-aaba-bf8214a326ad.png)



# About The Framework :
1. Used Rest Assured java library for testing Restful Webservices.
2. Maven is used for build management.
3. TestNG is used for test management.
4. Framework supports GET and POST API requests.
5. Used Log4j library for logging purpose. Logs are stored under "logs" folder.

![image](https://user-images.githubusercontent.com/86568081/163871666-1881320e-ba46-4db8-99d3-4e421414a261.png)

6. For test data, used "CommonTestData" & "Payloads" classes to fetch different payloads while hitting Post calls (src\main\java\testData).
7. The "Endpoint_Resources" class is used to return different endpoints(resource paths) for GET & POST APIs.
8. The "ReusableMethods" class is used as a utitlity to convert the Raw Response (from GET & POST Requests) to either Json or XML. Hence, framework supports for both XML & Json response message.
9. The "BaseTest" class is used to define "RestAssured.baseURI", "RequestSpecification" & "ResponseSpecification" interfaces, so that the common request & response headers can be defined at one place. Defined objects for "Properties" & "JsonPath" classes as well here, instead of defining these again & again in different Test classes.
10. The path "src\test\java\hotels_API_Tests" contains the Test classes. "log.info()" is provided for each method in order to understand the method using the provided description.
11. Positive and Negative scenarios (test methods) are kept under same class for their respective API request calls. A total of 22 tests will run.
12. The "environment.properties" file is used to fetch the Host(Base) URL.


**#Hotel Module APIs Used :**
1. POST API : https://www.almosafer.com/api/enigma/search/async
2. GET API : https://www.almosafer.com/api/enigma/content/hotels/summaries?placeId=ChIJufI-cg9EXj4RCBGXQZMuzMc&pageSize=2

***********************************************************************************************************************************************************************
