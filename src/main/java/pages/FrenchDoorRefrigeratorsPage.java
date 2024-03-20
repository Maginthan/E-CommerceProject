package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class FrenchDoorRefrigeratorsPage extends ProjectSpecificationMethod{

	public FrenchDoorRefrigeratorsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	//Method to click the first French refrigerator's Add to cart button
	public FrenchDoorRefrigeratorsPage firstRefrigerator() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> allItems = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".c-button.c-button-primary.c-button-sm.c-button-block.c-button-icon.c-button-icon-leading.add-to-cart-button")));

			for (WebElement webElement : allItems) {
				if (webElement.getText().equals("Add to Cart")) {
					click(webElement);
					extentTest.info("Add to cart was clicked successfully");
					break;
				}
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Add to cart click :"+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
}
