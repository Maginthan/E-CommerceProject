package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class CountrySelectionPage extends ProjectSpecificationMethod {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "(//a[@class='canada-link'])[1]")
	WebElement Canada;

	@FindBy(xpath = "(//a[@class='us-link'])[1]")
	WebElement UnitedStates;

	// Parameterized constructor to pass driver as argument
	public CountrySelectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method that returns by creating an object for LoginPage class
	public void canadaSelect() {
		WebElement ele = visibiltiyofElement(Canada, 3);
		click(ele);
	}

	// Method that returns by creating an object for HomePage class
	public HomePage UnitedStatesSelect() {
		WebElement ele = visibiltiyofElement(UnitedStates, 3);
		click(ele);
		return new HomePage(driver);
	}

}
