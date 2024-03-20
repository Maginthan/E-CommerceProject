package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SignUpPage extends ProjectSpecificationMethod {

	// Page factory to inspect element inside constructor
	// @FindBy(xpath = //input[@id='firstName'])

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to fill first name from Data provider
	public SignUpPage firstName(String Firstname) throws InterruptedException {

		WebElement firstEle = driver.findElement(By.xpath("//input[@id='firstName']"));
		isElementEnabled(firstEle);
		cleartextField(firstEle);
		findElementAndSendKeysByXpath(firstEle, Firstname);
		return this;
	}

	// Method to fill last name from Data provider
	public SignUpPage lastName(String Lastname) {
		WebElement lastEle = driver.findElement(By.xpath("//input[@id='lastName']"));
		isElementEnabled(lastEle);
		cleartextField(lastEle);
		findElementAndSendKeysByXpath(lastEle, Lastname);
		return this;
	}

	// Method to fill email ID from Data provider
	public SignUpPage email(String Email) {
		WebElement emailEle = driver.findElement(By.xpath("//input[@id='email']"));
		isElementEnabled(emailEle);
		cleartextField(emailEle);
		findElementAndSendKeysByXpath(emailEle, Email);
		return this;
	}

	// Method to fill password from Data provider
	public SignUpPage password(String Password) {
		WebElement passEle = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		isElementEnabled(passEle);
		cleartextField(passEle);
		findElementAndSendKeysByXpath(passEle, Password);
		return this;
	}

	// Method to fill confirm password from Data provider
	public SignUpPage confirmPassword(String ConfirmPassword) {
		WebElement confirmPassEle = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		isElementEnabled(confirmPassEle);
		cleartextField(confirmPassEle);
		findElementAndSendKeysByXpath(confirmPassEle, ConfirmPassword);
		return this;
	}

	// Method to fill phone number from Data provider
	public SignUpPage phoneNumber(String PhoneNumber) {
		WebElement phoneEle = driver.findElement(By.xpath("//input[@type='tel']"));
		isElementEnabled(phoneEle);
		cleartextField(phoneEle);
		findElementAndSendKeysByXpath(phoneEle, PhoneNumber);
		return this;
	}
	
	//Method to click the create account button
	public SignUpPage createAccount() {
		WebElement createEle = driver.findElement(By.xpath("//button[text()='Create an Account']"));
		isElementEnabled(createEle);
		click(createEle);
		return this;
	}

}
