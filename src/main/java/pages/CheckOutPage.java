package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class CheckOutPage extends ProjectSpecificationMethod{
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to fill the Billing address(First name, Last name, Address)
	//113 E 100 N
	//Alphine
	//UT
	//84004
	public CheckOutPage billingAddress(String firstName, String lastName, String address, String city, String zipCode) throws IOException {
		
		try {
			WebDriverWait firstNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement firstNameElement = firstNameWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']"))); 
			firstNameElement.sendKeys(firstName);
			
			WebDriverWait lastNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement lastNameElement = lastNameWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lastName']")));
			lastNameElement.sendKeys(lastName);
			
			WebDriverWait streetNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement addressElement = streetNameWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='street']")));
			addressElement.sendKeys(address);
			
			WebDriverWait cityNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement cityElement = cityNameWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='city']")));
			cityElement.sendKeys(city);
			
			WebElement stateDropdown = driver.findElement(By.xpath("//select[@name='state']"));
			Select state = new Select(stateDropdown);
			state.selectByValue("UT");
			
			WebDriverWait zipCodeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement zipCodeElement = zipCodeWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='zipcode']")));
			zipCodeElement.sendKeys(zipCode);
			
			extentTest.info("The billing address details were entered successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering the billing address details: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	
	//Method to click apply button after filling billing address
	public CheckOutPage apply() throws IOException {
		try {
			Thread.sleep(5000);
			WebDriverWait applyWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement applyElement = applyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Apply']")));
			applyElement.click();
			extentTest.info("The apply button was clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during apply button click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		
		return this;
	}

	//Method to fill email and phone number in Checkout page
	public CheckOutPage contactInfo(String email, String phoneNumber) throws IOException {
		try {
			WebDriverWait emailIDWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement emailIDElement = emailIDWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("user.emailAddress")));
			emailIDElement.sendKeys(email);
			
			WebDriverWait phoneNumberWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement phoneNumberElement = phoneNumberWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("user.phone")));
			phoneNumberElement.sendKeys(phoneNumber);
	
			extentTest.info("The contact information were entered successfully");			
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering the contact information: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click continue payment button in Checkout page
	public PaymentPage continueToPayment() throws IOException {
		try {
			Thread.sleep(5000);
			WebDriverWait continueToPaymentWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement continueToPaymentElement = continueToPaymentWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Continue to Payment Information']")));
			click(continueToPaymentElement);
			extentTest.info("The continue to payment button was clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Continue to payment button click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return new PaymentPage(driver);
	}

}
