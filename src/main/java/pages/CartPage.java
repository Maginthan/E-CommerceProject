package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class CartPage extends ProjectSpecificationMethod{
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to click the check out button in cart page
	public ContinueAsGuestPage checkOut() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement checkOutElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Checkout']")));
			click(checkOutElement);
			extentTest.info("Check out button clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Check out button click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return new ContinueAsGuestPage(driver);
	}
}
