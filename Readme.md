# E-Commerce Site Automation project:

<p align="Left"><img src="Images/best-buy-logo.png" alt="screenshot" width="400", height="200"></p>

This project is meant for testing the major functionalities of Best Buy web site. I have used Data-Driven testing for testing Sign In functionality with Data provider. Also, this project covers the main features like Adding item to cart and searching and adding item to cart.

## Motivation:
The reason behind creating this project is that automating this site is because of the Sign In and Sign Up functionality is quite challenging. Another challenge is that the Survey add popping in the middle of the test case execution.

## Coding Style:
- I have used Java language with POM(Page Object Model) design pattern with Selenium framework in this project.

## IDE/Language:
- IDE : Eclipse
- Language : Java

## Technology/Frameworks used:
- TestNG framework - Used for various purposes like Data provider and the prioritization of tests and suites.
- Extent reports library - Used for the detailed reporting the test cases status with various information like screenshots.
- Maven project - For the ease of handling the dependencies in one place
- Apache POI - For the reading and writing the data in  Excel sheet.
- Maven Surefire plugin- For the building a Maven build in order to use it for Jenkins CI/CD implementation for invoking the build by local host or remotely.
- Jenkins tool - For triggering the build eventually executing the tasks locally or remotely.
- WebDriver manager library - Used for handling web driver for various browsers like (Chrome, Firefox, Safari, Edge).

## Steps to create project and adding dependencies:
- Step 1 : Create a new project of type Maven in Eclipse IDE.
- Step 2 : Then add a testNG library by navigating to Java build path and adding testNG library. Then Apply and close.
- Step 3 : Next step is to add the important dependencies in the Pom.xml file(refer to the below dependencies screenshot).
- Step 4 : Since we are following POM design pattern we need to create four packages(refer to the below POM screenshot).
- Step 5 : Finally, add the Maven sure surefire plugin in the Pom.xml file under tag <build></build>(refer to the below Maven surefire screenshot).
- Step 6 : Create a new testng.xml file adding the test java classes to be executed under suite.
- Step 7 : Run the project a testNG suite.

## Dependencies screenshot:
<p align="Left"><img src="Images/E-commerce dependencies.png" alt="screenshot" width="600"></p>

## POM file screenshot:
<p align="Left"><img src="Images/E-commerce POM.png" alt="screenshot" width="400"></p>

## Maven surefire screenshot:
<p align="Left"><img src="Images/E-commerce Surefire.png" alt="screenshot" width="600" height="300"></p>

## Test case Code Example:
- I have used constructor chaining here in order to access the methods of pages with single object creation.
- We are using try/catch to handle the exception that occurs in between the process of executing a test case.
- Finally, based on the validation if the test case is passed we report that test case as Pass/Fail in extent report.

## Test Scenarios covered:
- URL is broken or not
- Top links are redirecting properly
- Bottom links are redirecting properly 
- Login scenarios(Positive and Negative)
- SignUp scenarios(Positive and Negative)
- Canada Country is selected and redirected properly
- U.S. Country is selected and redirected properly
- Shopping an item by Brand is done properly
- Shopping an item by Department is done properly
- Searching and add an item to cart is done properly
- Order is added to cart and moved till the payment screen properly.

## Scenarios having issues while testing:
- The Sign Up process sometimes ends up with this error ```Sorry, Something went wrong. Please try again later``` even if the details are correct during the Sign Up process.	
- The Sign In process face the same issue ```An account with this Email ID already exist``` while creating a new user.
- The order placement scenario also faced issue before moving to payment screen as ```Network error. Please retry with stable Internet connection```.

## Item added to cart success test case screenshot:
<p align="Left"><img src="PassedTestCaseScreenshots/TC_010_SearchAndAddItemToCartTest-Thu Mar 28 10:36:57 IST 2024.png" alt="screenshot" width="600"></p>

## Jenkins success build run screenshot:
<p align="Left"><img src="Test result screenshots/Genkins_Build_Report.png" alt="screenshot" width="600"></p>

## People worked on this project
```Maginthan```
