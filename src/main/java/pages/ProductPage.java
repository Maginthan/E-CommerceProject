package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class ProductPage extends ProjectSpecificationMethod {

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method to click add to cart in selected product page
	public ProductPage addToCart() throws IOException {
		try {
			// Action class to perform scroll down action
//			Actions action = new Actions(driver);
//			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement addToCartElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to Cart']")));
			click(addToCartElement);
			extentTest.info("Add to cart button clicked successfully");
		} catch (Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Add to cart button click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
}
