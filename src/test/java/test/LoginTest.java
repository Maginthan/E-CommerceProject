package test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.CountrySelectionPage;
import pages.HomePage;

public class LoginTest extends ProjectSpecificationMethod {

	// Public method to set the name of the Excel file
	@BeforeTest
	public void fileSetup() {
		excelFile = "DataSheet";
		sheetName = "LoginTest";
		testName = "TC_004_LoginTest";
		testAuthor = "Maginthan";
		testCategory = "Funcitonal";
	}

	@Test(dataProvider = "ReadfromExcel")
	public void TC_004_LoginTest(String email, String password, String dataMatch, String scenario)
			throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		CountrySelectionPage obj = new CountrySelectionPage(driver);
		obj.UnitedStatesSelect().accountButton().signInButton().emailID(email).password(password).logInButton();

		// Validating test cases for login functionality
		if (dataMatch.equals("bothCorrect") && scenario.equals("Positive_Con_1")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the LogIn condition with " + "_" + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[contains(text(), 'Sorry, something went wrong. Please try again.')]")));
				String msg = ele.getText();
				System.out.println("The error message is: " + msg);

				// Verifying the correct error message is displayed
				String expectedMessage = "Sorry, something went wrong. Please try again.";
				if (expectedMessage.equals(ele.getText())) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			}catch(Exception e){
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
			
		} else if (dataMatch.equals("wrongPassword") && scenario.equals("Positive_Con_2")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the LogIn condition with " + "-" + scenario);
		
			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[text()='Oops! The email or password did not match our records. Please try again.']")));
				System.out.println("The error message is: " + ele.getText());

				/// Verifying the correct error message is displayed
				String expectedMessage = "Oops! The email or password did not match our records. Please try again.";
				if (expectedMessage.equals(ele.getText())) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			}catch(Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

		else if (dataMatch.equals("wrongUsername") && scenario.equals("Positive_Con_3")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the LogIn condition with " + "-" + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[text()='Oops! The email or password did not match our records. Please try again.']")));
				System.out.println("The error message is: " + ele.getText());

				/// Verifying the correct error message is displayed
				String expectedMessage = "Oops! The email or password did not match our records. Please try again.";
				if (expectedMessage.equals(ele.getText())) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			}catch(Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

		else if (dataMatch.equals("bothWrong") && scenario.equals("Positive_Con_4")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the LogIn condition with " + "-" + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[text()='Oops! The email or password did not match our records. Please try again.']")));
				System.out.println("The error message is: " + ele.getText());

				/// Verifying the correct error message is displayed
				String expectedMessage = "Oops! The email or password did not match our records. Please try again.";
				if (expectedMessage.equals(ele.getText())) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}	
			}catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

		else if (dataMatch.equals("emptyMailID") && scenario.equals("Negative_Con_1")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the LogIn condition with " + "-" + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a valid email address.')]")));
				System.out.println("The error message is: " + ele.getText());

				/// Verifying the correct error message is displayed
				String expectedMessage = "Please enter a valid email address.";
				if (expectedMessage.equals(ele.getText())) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			}catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		}

		else if (dataMatch.equals("emptyPassword") && scenario.equals("Negative_Con_2")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the LogIn condition with " + "-" + scenario);
			
			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Please enter your password.')]")));
				System.out.println("The error message is: " + ele.getText());

				/// Verifying the correct error message is displayed
				String expectedMessage = "Please enter your password.";
				if (expectedMessage.equals(ele.getText())) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			}catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

		else {
			// Passing info the extent report for test case
			extentTest.info("Verifying the LogIn condition with " + "-" + scenario);

			try {
				// Explicit wait for the error message to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a valid email address.')]")));
				WebElement ele2 = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Please enter your password.')]")));

				System.out.println("The error message one is: " + ele1.getText());
				System.out.println("The error message two is: " + ele2.getText());

				/// Verifying the correct error messages of email and password is displayed
				String expectedMessage1 = "Please enter a valid email address.";
				String expectedMessage2 = "Please enter your password.";
				if (expectedMessage1.equals(ele1.getText()) && expectedMessage2.equals(ele2.getText())) {
					extentTest.pass("The user login for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user login for " + scenario + " failed");
				}
			}catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

	}

}

