package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "//span[text()='Account']")
	WebElement account;
	
//	@FindBy(xpath = "//a[text()='Sign In']")
//	WebElement SignIn;
//	
//	@FindBy(xpath = "//a[text()='Create Account']")
//	WebElement createAccount;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Method to click the account button in the Home screen
	public HomePage accountButton() {
		//WebElement ele = visibiltiyofElement(account, 5);
		
		//Checking whether alert is present is home page
//		boolean alert = isAlertPresent();
//		if(alert) {
//			Alert alertPresent = driver.switchTo().alert();
//			alertPresent.dismiss();
//			System.out.println("Alert is dismissed");
//		}else {
//			System.out.println("Alert not present");
//		}
		dismissAlert();
		click(account);
		return this;
	}
	
	//Method to click the SignIn button in the Home screen to navigate to SingIn screen
	public LoginPage signInButton() {
		//WebElement ele = visibiltiyofElement(SignIn, 5);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement SingInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[text()='Sign In']")));
		click(SingInElement);
		return new LoginPage(driver);
	}
	
	//Method to click the Create Account button in the Home screen to navigate to SingIn screen
	public SignUpPage createAccountButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement createAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(text(),'Create Account')]")));
		click(createAccountElement);
		return new SignUpPage(driver);
	}
	
	//Method to click the menu button in home screen
	public HomePage menuButton() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement menuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//button[text()='Menu']")));
			click(menuElement);
			extentTest.info("Menu button clicked successfully");
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Menu button click: " + " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click the appliances department in home screen
	public HomePage applicances() throws IOException {	
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> appliances = driver
					.findElements(By.cssSelector(".c-button-unstyled.hamburger-menu-flyout-list-item"));

			for (WebElement webElement : appliances) {
				if (webElement.getText().equals("Appliances")) {
					click(webElement);
					extentTest.info("Appliances clicked successfully");
					break;
				}
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Appliances click: " + " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click the appliances department in home screen
	public HomePage majorKitchenAppliances() throws IOException {
		try {
			List<WebElement> kitchenAppliances = driver
					.findElements(By.cssSelector(".c-button-unstyled.hamburger-menu-flyout-list-item"));

			for (WebElement webElement : kitchenAppliances) {
				if (webElement.getText().equals("Major Kitchen Appliances")) {
					click(webElement);
					extentTest.info("Major kitchen appliances clicked successfully");
					break;
				}
			}
		}catch(Exception e){
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Major kitchen appliances click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click refrigerators in the home screen
	public RefrigeratorTypePage refrigerators() throws IOException {
		try {
			List<WebElement> refrigerators = driver.findElements(By.cssSelector(".hamburger-menu-flyout-list-item "));

			for (WebElement webElement : refrigerators) {
				if (webElement.getText().equals("Refrigerators")) {
					click(webElement);
					extentTest.info("Refrigerators was clicked successfully");
					break;
				}
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Refrigerators click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return new RefrigeratorTypePage(driver);
	}
	
	//Method to click Brands in the home screen
	public HomePage brands() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> brands = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".c-button-unstyled.top-four.v-fw-medium")));
			
			for (WebElement webElement : brands) {
				if (webElement.getText().equals("Brands")) {
					click(webElement);
					extentTest.info("Brands is clicked successfully");
					break;
				}
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Brands click: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click Nintendo brand in the home screen
	public NintendoHomePage Nintendo() throws IOException {
		try {
		List<WebElement> Nintendos = driver.findElements(By.cssSelector(".hamburger-menu-flyout-list-item "));
			for (WebElement webElement : Nintendos) {
				if (webElement.getText().equals("Nintendo")) {
					click(webElement);
					extentTest.info("Nintendo is clicked successfully");
					break;
				}
			}
		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Nintendo click: "+ " - " +e.getMessage());
			e.printStackTrace();	
		}
		return new NintendoHomePage(driver);
	}
	
	//Method to search item in the search field in the home page
	public HomePage itemSearch(String product) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-search-input")));
			searchField.sendKeys(product);
			extentTest.info("Item " +product+ " entered into search field successfully");

		}catch(Exception e) {
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured while entering " +product+" into search field: "+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return this;
	}
	
	//Method to click the search button in the home page
	public ProductsPage searchButton() throws IOException {
		
		try {
			WebElement searchButton = driver.findElement(By.className("header-search-button"));
			click(searchButton);
			extentTest.info("Search button clicked successfully");
		}catch(Exception e){
			// Calling public method to take screenshot
			filePath = takeScreenshot(testName);
			// Calling method the to capture screenshot from path
			extentTest.addScreenCaptureFromPath(filePath, testName);
			extentTest.fail("Exception occured during Search button click :"+ " - " +e.getMessage());
			e.printStackTrace();
		}
		return new ProductsPage(driver);
	}
	
}
