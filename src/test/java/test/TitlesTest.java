package test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.CountrySelectionPage;

public class TitlesTest extends ProjectSpecificationMethod{
	
	@BeforeTest
	public void extentTestSetup() {
		testName = "TC_006_TitlesTest";
		testAuthor = "Maginthan";
		testCategory = "Funcitonal";
	}
	

	@Test
	public void TC_006_TitlesTest() throws IOException {
		// TODO Auto-generated method stub
		
		CountrySelectionPage obj = new CountrySelectionPage(driver);
		obj.UnitedStatesSelect();
		
		//Expected titles to validated stored in an array of Strings.
		String[] expectedTitles = {"Top Deals and Featured Offers on Electronics - Best Buy", "Deal of the Day: Electronics Deals - Best Buy", "Yes, Best Buy Sells That – Best Buy", "My Best Buy Memberships", "Best Buy Credit Card: Rewards & Financing", "Gifts Cards and E-Gift Cards - Best Buy", "Gift Ideas 2024: Best Gifts to Give This Year - Best Buy"};
		
		try {
			// Passing info the extent report for test case
			extentTest.info("Verifying the Title validation in Home screen");
			
			//Declaring list of Web elements to iterate and validate the titles
			List<WebElement> allTitles = new ArrayList<>();
			for (int i = 0; i < expectedTitles.length; i++) {
				
				// Checking whether Survey alert is present is home page
				dismissAlert();

				allTitles = driver.findElements(By.cssSelector(".bottom-left-links"));
				Thread.sleep(1000);
				allTitles.get(i).click();
				
				// Checking whether Survey alert is present is home page
				dismissAlert();

				// Validating title is correct
				String title = driver.getTitle();
				if (title.equals(expectedTitles[i])) {
					extentTest.pass("The Title validation for title " + " - " + expectedTitles[i] + " - " + " passed");
				} else {
					// Calling public method to take screenshot
					filePath = takeScreenshot(testName);
					// Calling method the to capture screenshot from path
					extentTest.addScreenCaptureFromPath(filePath, testName);
					extentTest.fail("The Title validation for title " + " - " + expectedTitles[i] + " - " + " failed");
				}
				// Navigate back to home screen
				driver.navigate().back();
			}
						
//			Validating every title element matches the expected title
//			for(int i=0; i< expectedTitles.length; i++) {
//				WebElement titleElement = allTitles.get(i);
//				Thread.sleep(3000);
//				titleElement.click();
//				String title = driver.getTitle();
//				
//				if(title.equals(expectedTitles[i])){
//					extentTest.pass("The Title validation for title "+ " - " + expectedTitles[i] + " - " +" passed");
//				}else {
//					extentTest.fail("The Title validation for title "+ " - " + expectedTitles[i] + " - " +" failed");
//				}
//			}
		}
		catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during the list of Titles validation " + " - " + e.getMessage());
			e.printStackTrace();
		}
		

	}

}
 