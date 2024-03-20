package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class ProductsPage extends ProjectSpecificationMethod {
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	//Method to click the entered product from products page
	public ProductPage productClick() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//a[text()='Dell - 31.5\" IPS LCD 4K UHD 60Hz Monitor (USB, HDMI) - Black, Silver']")));
			click(product);
			extentTest.info("The searched product is clicked successfully");
		} catch (Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during the searched Product click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return new ProductPage(driver);
	}

}
