package test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.CountrySelectionPage;

public class ShopByDepartmentTest extends ProjectSpecificationMethod {

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_008_shopByDepartmentTest";
		testAuthor = "Maginthan";
		testCategory = "Functional testing";
	}

	@Test
	public void TC_008_shopByDepartmentTest() throws IOException {
		// TODO Auto-generated method stub
		CountrySelectionPage obj = new CountrySelectionPage(driver);
		obj.UnitedStatesSelect().menuButton().applicances().majorKitchenAppliances().refrigerators()
				.frenchDoorTypeRefrigerators().firstRefrigerator();

		try {
			// Validating the item is added to cart by checking the success message
			// Explicit wait for the items to load and the add to cart button to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement successMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Added to cart']")));

			if (successMessage.getText().equals("Added to cart")) {
				extentTest.pass("The test case " + testName + " passed");
			} else {
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
			extentTest.fail("Exception occured during the test case validation: " + " - " +e.getMessage());
			e.printStackTrace();
		}

	}

}
