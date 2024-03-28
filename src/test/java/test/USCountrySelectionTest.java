package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.CountrySelectionPage;

public class USCountrySelectionTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_003_UnitedStatesSelectTest";
		testAuthor = "Maginthan";
		testCategory = "Functional";
	}
	
	@Test
	public void TC_003_UnitedStatesSelectTest() throws IOException {
		// TODO Auto-generated method stub
		//Passing info the extent report for test case
		extentTest.info("Verifying the country United States is selectable");
		
		// TODO Auto-generated method stub
		CountrySelectionPage obj = new CountrySelectionPage(driver);
		obj.UnitedStatesSelect();
		
		try {
			String actualResult = driver.getTitle();
			String expectedResult = "Best Buy | Official Online Store | Shop Now & Save";
			
			if(actualResult.equals(expectedResult)) {
				// Calling public method to take passed test case screenshot
				filePath = passedTestsScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.pass("The United States country selection was successful and test case passed");
			}else {
				// Calling public method to take screenshot
				filePath = takeScreenshot(testName);
				// Calling method the to capture screenshot from path
				extentTest.addScreenCaptureFromPath(filePath, testName);
				extentTest.fail("The United States country selection failed");
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during the United Sates country selection " + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

}
