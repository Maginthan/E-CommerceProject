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

public class NintendoHomePage extends ProjectSpecificationMethod {
	public NintendoHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public NintendoSwitchConsolesPage nintendoSwitchConsoles() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> nintendoProducts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("flex-link")));
			
			for (WebElement webElement : nintendoProducts) {
				if (webElement.getText().equals("Nintendo Switch consoles")) {
					click(webElement);
					extentTest.info("Nintento Switch consoles is clicked successfully");
					break;
				}
			}
		} catch (Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Nintento Switch consoles click: "+ " - " +e.getMessage());
			e.printStackTrace();	
		}
		return new NintendoSwitchConsolesPage(driver);
	}

}
