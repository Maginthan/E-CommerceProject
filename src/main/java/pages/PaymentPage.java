package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class PaymentPage extends ProjectSpecificationMethod{
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to fill Credit card information (Card number, Expiration date, security code)
	public PaymentPage cardInfo(String cardNumber, String secuirtyCode) throws IOException {
		try {
			WebDriverWait cardEleWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement cardNoElement = cardEleWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@pattern='[0-9]*'])[1]")));
			cardNoElement.sendKeys(cardNumber);
			
			WebElement expiryMonthDropdown = driver.findElement(By.id("expMonth"));
			Select expiryMonth = new Select(expiryMonthDropdown);
			expiryMonth.selectByValue("01");
			
			WebElement expiryYearDropdown = driver.findElement(By.id("expYear"));
			Select expiryYear = new Select(expiryYearDropdown);
			expiryYear.selectByValue("2026");
			
			WebDriverWait securityEleWait  = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement secuirtyCodeElement = cardEleWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@pattern='[0-9]*'])[2]")));
			secuirtyCodeElement.sendKeys(secuirtyCode);
						
			extentTest.info("The credit card details were entered successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering the credit card details: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click place your order button
	public PaymentPage placeYourOrder() throws IOException {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement placeYourOrderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Place Your Order']")));
			click(placeYourOrderElement);		
			extentTest.info("Place your order button was clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Place your order button click : "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
}
