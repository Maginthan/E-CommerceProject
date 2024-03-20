package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class NintendoSwitchConsolesPage extends ProjectSpecificationMethod {

	public NintendoSwitchConsolesPage(WebDriver driver) {
		this.driver = driver;
	}

	//Method to click add to cart button of first Nintendo switch product
	public NintendoSwitchConsolesPage firstNintendo() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> nintendoSwitches = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(
					".c-button.c-button-primary.c-button-sm.c-button-block.c-button-icon.c-button-icon-leading.add-to-cart-button")));

//			for (WebElement webElement : nintendoSwitches) {
//				if (webElement.getText().equals("Add to Cart")) {
//
//					// Action class to perform scroll down action
//					Actions action = new Actions(driver);
//					action.sendKeys(Keys.PAGE_DOWN).build().perform();
//					click(webElement);
//					extentTest.info("Add to cart was clicked successfully");
//					break;
//				}
//			}
		
			WebElement product = nintendoSwitches.get(0);
			click(product);
			extentTest.info("Add to cart was clicked successfully");		
		} catch (Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Add to cart click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	
	//Method to click go to cart button
	public CartPage goToCart() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement goToCartElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Go to Cart']")));
			
			click(goToCartElement);
			extentTest.info("Go To cart button clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Go To cart button click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return new CartPage(driver);
	}
}
