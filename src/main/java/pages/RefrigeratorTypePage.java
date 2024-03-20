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

public class RefrigeratorTypePage extends ProjectSpecificationMethod{

	public RefrigeratorTypePage(WebDriver driver) {
		this.driver = driver;
	} 
	
	//Method to click the type French door refrigerator
	public FrenchDoorRefrigeratorsPage frenchDoorTypeRefrigerators() throws IOException {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> allItemTypes = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("flex-link")));

			for (WebElement webElement : allItemTypes) {
				if (webElement.getText().equals("French door refrigerators")) {
					click(webElement);
					extentTest.info("French Door Refrigerators was clicked successfully");
					break;
				}
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during French Door Refrigerators click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return new FrenchDoorRefrigeratorsPage(driver);
	}
	
}
