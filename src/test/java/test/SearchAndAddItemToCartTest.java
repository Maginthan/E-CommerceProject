package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.CountrySelectionPage;

public class SearchAndAddItemToCartTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_010_SearchAndAddItemToCartTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
		productName = "Dell - 31.5\" IPS LCD 4K UHD 60Hz Monitor (USB, HDMI) - Black, Silver";
	}

	@Test
	public void TC_010_SearchAndAddItemToCartTest() throws IOException {
		// TODO Auto-generated method stub
		CountrySelectionPage obj = new CountrySelectionPage(driver);
		obj.UnitedStatesSelect().itemSearch(productName).searchButton().productClick().addToCart();
		
		try {
			// Validating the item is added to cart by checking the success message
			// Explicit wait for add to cart button to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement successMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Added to cart']")));

			if (successMessage.getText().equals("Added to cart")) {
				// Calling public method to take passed test case screenshot
				filePath = passedTestsScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.pass("The test case " + testName + " passed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("The test case " + testName + " failed");
			}

		} catch (Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during the test case validation "+ " - " +e.getMessage());
			e.printStackTrace();
		}
	}

}
