package utils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.http.HttpConnection;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class Utility {
	// Public driver instance
	public WebDriver driver;

	// Public instance of Excel file
	public String excelFile;

	// Public instance of Excel sheet name
	public String sheetName;
	
	// Public instances of extent test required for a test case
	public String testName;
	public String testAuthor;
	public String testCategory;

	//Public instances for the product name for search functionality
	public String productName;
	
	//Public instance used for capturing the failed test case screenshot file path
	public String filePath;
	
	//Public instances for the payment scenario functionality
	public String email, phoneNumber;
	public String cardNumber, secuirtyCode;
	public String firstName, lastName, address, city, zipCode;
	
	// Public method to launch browser and load url
	public void launchBrowser(String browser, String url) {
		
		//Setting headless browser on Chrome driver 
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("headless");
		
		//Setting headless browser on Firefox driver 
		FirefoxOptions firefoxOptions = new FirefoxOptions ();
		firefoxOptions.addArguments("--headless");
		
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver(firefoxOptions);
		} else if (browser.equals("Safari")) {
			driver = new SafariDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	// Public method to close browser
	public void closeBrowser() {
		driver.close();
	}

	// Public method to perform click operation
	public void click(WebElement ele) {
		ele.click();
	}

	// Public method to find an element by ID and enter text
	public void findElementAndSendKeysByID(String attributevalue, String value) {
		driver.findElement(By.id(attributevalue)).sendKeys(value);
	}
	
	// Public method to find an element by xpath and enter text
	public void findElementAndSendKeysByXpath(WebElement attributevalue, String value) {
		attributevalue.sendKeys(value);
	}
	
	// Public method to check whether the element is visible
	public void isElementDisplayed(WebElement ele) {
		boolean eleDisplayed= ele.isDisplayed();
	}
	
	// Public method to check whether the element is enabled
	public void isElementEnabled(WebElement ele) {
		boolean eleEnabled = ele.isEnabled();
	}
	
	// Public method to check whether the element is enabled
	public void cleartextField(WebElement ele) {
		ele.clear(); 
	}
	
	// public method to explicit wait for visibility of element
	public WebElement visibiltiyofElement(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	// Public method to read data from Excel file
	public String[][] readExcel(String excelfile, String sheetname) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook("/Users/maginthangr/eclipse-workspace/E-CommerceProject/Data/" + excelfile + ".xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);

		// Getting the row count and column count
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		// Two dimensional array to store row and column values of cells
		String[][] data = new String[rowCount][columnCount];

		// Get into row
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);

			// Get into cell
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		// Closing the book
		book.close();
		return data;
	}

	// Public method to generate random user name for Sign up functionality
//	public String randomNameGenerator() {
//
//		// Creating string of all characters
//		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//
//		// Creating random string builder
//		StringBuilder sb = new StringBuilder();
//
//		// creating an object of random class
//		Random random = new Random();
//
//		// Specifying the length of random string
//		int length = 7;
//
//		for (int i = 0; i < length; i++) {
//			// Generating random index number
//			int index = random.nextInt(alphabet.length());
//
//			// Getting the character based on the specified index
//			char randomChar = alphabet.charAt(index);
//
//			// Appending the character to string builder
//			sb.append(randomChar);
//
//		}
//		String name = sb.toString();
//		System.out.println("The random string is " + name);
//		return name;
//	}
	
	//Public method to return if an alert is present on the web page
	public boolean isAlertPresent() {
	    try{
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	       wait.until(ExpectedConditions.alertIsPresent());
	       return true;
	    }
	    catch (NoAlertPresentException noAlert) {
	      return false;
	    }
	    catch (TimeoutException timeOutEx){
	      return false;
	    }
	}
	
	//Public method to dismiss alert
	public void dismissAlert(){
		
		//Explicit wait for alert
		
//		try {
//			WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(3));
//			
//	        if(alertWait.until(ExpectedConditions.alertIsPresent()) != null){
//	        	System.out.println("Random alert is present");
//	            driver.switchTo().alert().dismiss();
//	            System.out.println("Random alert is dismissed");
//	        }else {
//	        	System.out.println("Random alert is not present");
//	        }
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try{
//			Alert alert = driver.switchTo().alert();
//			alert.accept();
//			System.out.println("Alert is present");
//		}catch(NoAlertPresentException e){
//			System.out.println("No survey alert present");
//			//e.printStackTrace();
//		}
		
		try {
			WebElement alertElement = driver.findElement(By.xpath("//button[text()='No, Thanks']"));
			alertElement.click();
			System.out.println("Survey Alert is present and dismissed");
		}catch(Exception e) {
			System.out.println("No survey alert present");
		}

    }
	

	// Public method to take screenshot with time stamp
		public String takeScreenshot(String screenshotName) throws IOException {
			Date d = new Date();
			String date = d.toString();

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = "/Users/maginthangr/eclipse-workspace/E-CommerceProject/FailedTestCaseScreenshots/" + screenshotName + "-" + date
					+ ".png";
			File dest = new File(path);
			FileUtils.copyFile(src, dest);
			return path;
		}
		
		//	Public method to take screenshot of passed test cases with time stamp
		public String passedTestsScreenshot(String screenshotName) throws IOException {
			Date d = new Date();
			String date = d.toString();

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = "/Users/maginthangr/eclipse-workspace/E-CommerceProject/PassedTestCaseScreenshots/" + screenshotName + "-" + date
					+ ".png";
			File dest = new File(path);
			FileUtils.copyFile(src, dest);
			return path;
		}	

}
