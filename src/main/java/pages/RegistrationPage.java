package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.PageBase;

public class RegistrationPage extends PageBase {

	@FindBy(name = "FirstName")
	public WebElement firstNameField;
	
	@FindBy(name = "LastName")
	public WebElement lastNameField;
	
	@FindBy(name = "Gender")
	public WebElement genderDropDownListElement;
	
	@FindBy(name = "DateOfBirth")
	public WebElement dateOfBirthElement;
	
	@FindBy(name = "PhoneNo")
	public WebElement phoneNumberField;
	
	@FindBy(name = "UserType")
	public WebElement userTypeDropdownElement;
	
	@FindBy(name = "Email")
	public WebElement emailFieldElement;
	

	@FindBy(name = "submit")
	public WebElement submitButton;

	@FindBys(@FindBy(id = "error"))
	public List<WebElement> errorElementList;

	public void textFieldHelper(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
		// Alternative for submit button we have to use submitButton.submit;
		submitButton.click();
	}
}
