package test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.CountrySelectionPage;

public class CanadaCountrySelectionTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_002_CanadaSelectTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	@Test
	public void TC_002_CanadaSelectTest() throws IOException {
		// TODO Auto-generated method stub
		//Passing info the extent report for test case
		extentTest.info("Verifying the country Canada is selectable");
		
		// TODO Auto-generated method stub
		CountrySelectionPage obj = new CountrySelectionPage(driver);
		obj.canadaSelect();	
		
		try {
			String expectedResult = "Best Buy: Shop Online For Deals & Save | Best Buy Canada";
			//Explicit wait for the title to change
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.titleContains(expectedResult));
			String actualResult = driver.getTitle();
			
			if(actualResult.equals(expectedResult)) {
				extentTest.pass("The Canada country selection was successful and test case passed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("The Canada country selection failed");
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during the Canada country selection " + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

}
