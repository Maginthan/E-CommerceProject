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

public class SignUpTest extends ProjectSpecificationMethod {

	// Public method to set the name of the Excel file
	@BeforeTest
	public void fileSetup() {
		excelFile = "DataSheet";
		sheetName = "SignUpTest";
		testName = "TC_005_SignUpTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}

	@Test(dataProvider = "ReadfromExcel")
	public void TC_005_SignUpTest(String firstname, String lastname, String email, String password,
			String confirmpassword, String mobilenumber, String scenario, String datamatch, String passscenario,
			Method m) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		CountrySelectionPage obj = new CountrySelectionPage(driver);
		obj.UnitedStatesSelect().accountButton().createAccountButton().firstName(firstname).lastName(lastname)
				.email(email).password(password).confirmPassword(confirmpassword).phoneNumber(mobilenumber)
				.createAccount();

		// Validating test cases for Sign Up functionality
		if (datamatch.equals("allCorrect") && scenario.equals("Positive_Con_1")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the name of user to appear in the home screen.
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement userNameElement = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hi')]")));
				
				if(userNameElement.isDisplayed()) {
					extentTest.pass("The user SignUp for " + scenario + " passed");
				}else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " failed");
				}
			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		}

		else if (datamatch.equals("existingEmail") && scenario.equals("Positive_Con_2")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error message for existing email ID
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement emailErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//strong[text()='An account with this email already exists.']")));

				String actualAlert = emailErrorElement.getText();
				String ExpectedAlert = "An account with this email already exists.";

				if (ExpectedAlert.equals(actualAlert)) {
					extentTest.pass("The user SignUp for " + scenario + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

		else if (datamatch.equals("existingPhoneNumber") && scenario.equals("Positive_Con_3")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error message for existing phone number
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement phoneErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//strong[text()='An account with this phone number already exists.']")));

				String actualAlert = phoneErrorElement.getText();
				String ExpectedAlert = "Sorry, there was a problem creating your account.";

				if (ExpectedAlert.equals(actualAlert)) {
					extentTest.pass("The user SignUp for " + scenario + " is passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " is failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}
		}

		else if (datamatch.equals("passwordCheck") && scenario.equals("Positive_Con_4")
				&& passscenario.equals("Upper&Lower")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error message to enter strong password
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a strong password.')]")));

				String actualAlert = passwordError.getText();
				String ExpectedAlert = "Please enter a strong password.";

				if (ExpectedAlert.equals(actualAlert)) {
					extentTest.pass("The user SignUp for " + scenario + " is passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " is failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		}

		else if (datamatch.equals("passwordCheck") && scenario.equals("Positive_Con_5")
				&& passscenario.equals("spaces")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error message to enter strong password
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a strong password.')]")));

				String actualAlert = passwordError.getText();
				String ExpectedAlert = "Please enter a strong password.";

				if (ExpectedAlert.equals(actualAlert)) {
					extentTest.pass("The user SignUp for " + scenario + " is passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " is failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		}

		else if (datamatch.equals("passwordCheck") && scenario.equals("Positive_Con_6")
				&& passscenario.equals("numbers")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error message to enter strong password
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a strong password.')]")));

				String actualAlert = passwordError.getText();
				String ExpectedAlert = "Please enter a strong password.";

				if (ExpectedAlert.equals(actualAlert)) {
					extentTest.pass("The user SignUp for " + scenario + " is passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " is failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		}

		else if (datamatch.equals("passwordCheck") && scenario.equals("Positive_Con_7")
				&& passscenario.equals("characters")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error message to enter strong password
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a strong password.')]")));

				String actualAlert = passwordError.getText();
				String ExpectedAlert = "Please enter a strong password.";

				if (ExpectedAlert.equals(actualAlert)) {
					extentTest.pass("The user SignUp for " + scenario + " is passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " is failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		}

		else if (datamatch.equals("passwordCheck") && scenario.equals("Positive_Con_8")
				&& passscenario.equals("Mix")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error message to enter strong password
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a strong password.')]")));

				String actualAlert = passwordError.getText();
				String ExpectedAlert = "Please enter a strong password.";

				if (ExpectedAlert.equals(actualAlert)) {
					extentTest.pass("The user SignUp for " + scenario + " is passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " is failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		} 

		else if (datamatch.equals("allEmpty") && scenario.equals("Negative_Con_1")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error messages of all text fields
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				// First name warning
				WebElement firstNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter your first name.')]")));

				String actualFirstNameAlert = firstNameEle.getText();
				String ExpectedFirstNameAlert = "Please enter your first name.";

				// Last name warning
				WebElement lastNameEle = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Please enter your last name.')]")));

				String actualLastNameAlert = lastNameEle.getText();
				String ExpectedLastNamedAlert = "Please enter your last name.";

				// Email warning
				WebElement emailEle = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a valid email address.')]")));

				String actualEmailAlert = emailEle.getText();
				String ExpectedEmailAlert = "Please enter a valid email address.";

				// Password warning
				WebElement passwordEle = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a strong password.')]")));

				String actualPasswordlAlert = passwordEle.getText();
				String ExpectedPasswordAlert = "Please enter a strong password.";

				// Confirm password warning
				WebElement ConfirmPasswordEle = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please reenter your password.')]")));

				String actualConfirmPasswordlAlert = ConfirmPasswordEle.getText();
				String ExpectedConfirmPasswordAlert = "Please reenter your password.";

				// Phone number warning
				// p[contains(text(), 'Please enter a valid mobile phone number.')]
				WebElement phoneNumberEle = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(text(), 'Please enter a valid mobile phone number.')]")));

				String actualPhoneNumberAlert = phoneNumberEle.getText();
				String ExpectedPhoneNumberAlert = "Please enter a valid mobile phone number.";

				if (ExpectedFirstNameAlert.equals(actualFirstNameAlert)
						&& (ExpectedLastNamedAlert.equals(actualLastNameAlert))
						&& (ExpectedEmailAlert.equals(actualEmailAlert))
						&& (ExpectedPasswordAlert.equals(actualPasswordlAlert))
						&& (ExpectedConfirmPasswordAlert.equals(actualConfirmPasswordlAlert))
						&& (ExpectedPhoneNumberAlert.equals(actualPhoneNumberAlert))) {
					extentTest.pass("The user SignUp for " + scenario + " is passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " is failed");
				}

			} catch (Exception e) {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("Exception occured during scenario "+ scenario + " - " + e.getMessage());
				e.printStackTrace();
			}

		}

		else if (datamatch.equals("wrongConfirmPassword") && scenario.equals("Negative_Con_2")) {
			// Passing info the extent report for test case
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error message to enter strong password
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement mixMatchEle = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Passwords do not match.')]")));

				String actualMismatchAlert = mixMatchEle.getText();
				String expectedMismatchAlert = "Passwords do not match.";

				if (expectedMismatchAlert.equals(actualMismatchAlert)) {
					extentTest.pass("The user SignUp for " + scenario + " is passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " is failed");
				}

			} catch (Exception e) {
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
			extentTest.info("Verifying the SignUp condition with " + "_" + scenario);

			// Explicit wait for the error message to enter strong password
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement mismatchEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//div[contains(text(), 'The phone number you entered is not valid. Please enter a valid phone number and try again.')]")));

				String actualInvalidNumberAlert = mismatchEle.getText();
				String expectedInvalidNumberAlert = "The phone number you entered is not valid. Please enter a valid phone number and try again.";

				if (expectedInvalidNumberAlert.equals(actualInvalidNumberAlert)) {
					extentTest.pass("The user SignUp for " + scenario + " is passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The user SignUp for " + scenario + " is failed");
				}

			} catch (Exception e) {
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
