package test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.CountrySelectionPage;

public class BottomLinksTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_007_BottomLinksTest";
		testAuthor = "Maginthan";
		testCategory = "Funcitonal";
	}

	@Test
	public void TC_007_BottomLinksTest() throws IOException {
		// TODO Auto-generated method stub
		
		CountrySelectionPage obj = new CountrySelectionPage(driver);
		obj.UnitedStatesSelect();
		
		//Expected bottom link titles to validated stored in an array of Strings.
		String[] expectedTitles = {"Accessibility - Best Buy", "BestBuy.com Terms and Conditions", "Privacy Policy Hub - Best Buy", "Interest-Based Ads - Best Buy", "State Privacy Rights - Best Buy", "Privacy Policy Hub - Best Buy", "Start Request - Best Buy", "Best Buy", "Start Request - Best Buy", "California Supply Chain Transparency Act - Best Buy"};
		
		try {
			// Passing info the extent report for test case
			extentTest.info("Verifying the Bottom links validation in the Home screen");                 
			
			//Declaring list of Web elements to iterate and validate the bottom link titles
			List<WebElement> allTitles = new ArrayList<>();
			
			for (int i = 0; i < expectedTitles.length; i++) {
				// Checking whether Survey alert is present is home page
				dismissAlert();

				allTitles = driver.findElements(By.cssSelector(".body-copy-sm.mr-200"));
				Thread.sleep(1000);
				allTitles.get(i).click();
				
				// Checking whether Survey alert is present is home page
				dismissAlert();

				// Validating title is correct
				String title = driver.getTitle();
				if (title.equals(expectedTitles[i])) {
					extentTest.pass("The Bottom link validation for title " + " - " + expectedTitles[i] + " - " + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The Bottom link validation for title " + " - " + expectedTitles[i] + " - " + " failed");
				}
				// Navigate back to home screen
				driver.navigate().back();
			}
			//List<WebElement> allTitles = driver.findElements(By.cssSelector(".body-copy-sm.mr-200"));
			
			//Validating every title element matches the expected title
//			for(int i=0; i< expected.length; i++) {
//				String ele = allTitles.get(i).getText();
//				
//				if(ele.equals(expected[i])){
//					extentTest.pass("The Title validation for title "+ " - " + expected[i] + " - " +" passed");
//				}else {
//					extentTest.fail("The Title validation for title "+ " - " +expected[i] + " - " +" failed");
//				}
//			}
		}
		catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Bottom links validation " + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

}
