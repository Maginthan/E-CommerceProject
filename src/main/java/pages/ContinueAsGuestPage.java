package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class ContinueAsGuestPage extends ProjectSpecificationMethod{
	public ContinueAsGuestPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to click Continue as Guest button in Continue As Guest Page
	public CheckOutPage continueAsGuest() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement continueAsGuestElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue as Guest']")));
			click(continueAsGuestElement);
			extentTest.info("Continue as Guest button clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Continue as Guest button click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return new CheckOutPage(driver);
	}
}
