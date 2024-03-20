package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod {

// Page factory to inspect element inside constructor
//	@FindBy(xpath = "//button[text()='Sign In']")
//	WebElement login;
	
//	@FindBy(xpath = "//input[@type='email']")
//	WebElement email;
	
//	@FindBy(xpath = "//input[@type='text']")
//	WebElement password;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

//Method to fill user name from Data provider
	public LoginPage emailID(String emailID) throws InterruptedException {
		
		WebElement emailEle = driver.findElement(By.xpath("//input[@type='email']"));
		isElementEnabled(emailEle);
		cleartextField(emailEle);
		findElementAndSendKeysByXpath(emailEle,emailID);
		return this;
	}

//Method to fill password from Data provider
	public LoginPage password(String password) throws InterruptedException {
		//input[@type='text']
		//findElementAndSendKeysByXpath("password","Password@123");
		WebElement passEle = driver.findElement(By.xpath("//input[@type='password']"));
		isElementEnabled(passEle);
		cleartextField(passEle);
		findElementAndSendKeysByXpath(passEle,password);
		return this;
	}

//Method to click Login button
	public LoginPage logInButton() throws InterruptedException {
		WebElement logEle = driver.findElement(By.xpath("//button[text()='Sign In']"));
		isElementEnabled(logEle);
		click(logEle);
		return this;
	}

}
