package tests;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.RegistrationPage;

public class TestRegisterFeature extends TestBase {

	@BeforeClass
	public void classSetUp() {
		menuBar.registerLink.click();
	}

	@AfterClass
	public void tearDown() {
		menuBar.jobSearch.click();
	}

	@Test
	public void testFirstNameFieldWithTwoCharacter() {
		registerPage.textFieldHelper(registerPage.firstNameField, "Md");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 0);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testFirstNameFieldWithOneCharacter() {
		registerPage.textFieldHelper(registerPage.firstNameField, "F");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 0);
		Assert.assertEquals(actualError, "* FirstName can not be less than 2 character.");
	}

	@Test
	public void testFirstNameFieldWithThirtyCharacter() {
		registerPage.textFieldHelper(registerPage.firstNameField, "qwertyuiopasdfghjklzxcvbnmqwer");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 0);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testFirstNameFieldWithThirtyOneCharacter() {
		registerPage.textFieldHelper(registerPage.firstNameField, "qwertyuioplkjhgfdsazxcvbnmqwert");
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 0);
		Assert.assertEquals(actualError, "* FirstName can not be greater than 30 character.");
	}

	@Test
	public void testFirstNameFieldWithoutCharacter() {
		registerPage.textFieldHelper(registerPage.firstNameField, "");
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 0);
		Assert.assertEquals(actualError, "* FirstName can not be empty.");
	}

	@Test
	public void testFirstNameFieldWithNumericCharacter() {
		registerPage.textFieldHelper(registerPage.firstNameField, "12334444");
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 0);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testLastNameFieldWithTwoCharacter() {
		registerPage.textFieldHelper(registerPage.lastNameField, "La");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 1);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testLastNameFieldWithOneCharacter() {
		registerPage.textFieldHelper(registerPage.lastNameField, "L");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 1);
		Assert.assertEquals(actualError, "* LastName can not be less than 2 character.");
	}

	@Test
	public void testLastNameFieldWithThirtyCharacter() {
		registerPage.textFieldHelper(registerPage.lastNameField, "qwertyuioplkjhgfdsazxcvbnmiuyt");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 1);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testLastNameFieldWithThirtyOneCharacter() {
		registerPage.textFieldHelper(registerPage.lastNameField, "qwertyuioplkjhgfdsazxcvbnmiuytd");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 1);
		Assert.assertEquals(actualError, "* LastName can not be greater than 30 character.");
	}

	@Test
	public void testLastNameFieldWithoutCharacter() {
		registerPage.textFieldHelper(registerPage.lastNameField, "");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 1);
		Assert.assertEquals(actualError, "* LastName can not be empty.");
	}

	@Test
	public void testLastNameFieldWithNumericCharacter() {
		registerPage.textFieldHelper(registerPage.lastNameField, "1212");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 1);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testGenderWithoutSelectedOption() {
		registerPage.submitButton.click();
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 2);
		Assert.assertEquals(actualError, "* Gender can not be empty.");
	}

	// @Test(dependsOnMethods = {"testGenderWithoutSelectedOption"})
	@Test(priority = 1)
	public void testGenderWithRandomOption() {
		registerPage.randomlySelectFromDropdownList(registerPage.genderDropDownListElement);
		registerPage.submitButton.click();
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 2);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testDateOfBirthFieldWithValidFormat() {
		registerPage.textFieldHelper(registerPage.dateOfBirthElement, "1997-10-22");
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 3);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testDateOfBirthFieldWithInvalidFormat() {
		registerPage.textFieldHelper(registerPage.dateOfBirthElement, "10-15-1997");
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 3);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testDateOfBirthWithoutAnyDate() {
		registerPage.textFieldHelper(registerPage.dateOfBirthElement, "");
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 3);
		Assert.assertEquals(actualError, "* DateOfBirth can not be empty.");
	}

	@Test
	public void testPhoneNumberFieldWithEmptyField() {
		registerPage.textFieldHelper(registerPage.phoneNumberField, "");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 4);
		Assert.assertEquals(actualError, "* PhoneNo can not be empty.");
	}

	@Test
	public void testPhoneNumberFieldWithTwoNumber() {
		registerPage.textFieldHelper(registerPage.phoneNumberField, "12");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 4);
		Assert.assertEquals(actualError, "* PhoneNo can not be less than 3 character.");
	}

	@Test
	public void testPhoneNumberFieldWithThreeNumber() {
		registerPage.textFieldHelper(registerPage.phoneNumberField, "123");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 4);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testPhoneNumberFieldWithThirtyNumber() {
		registerPage.textFieldHelper(registerPage.phoneNumberField, "123456789012345678901234567890");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 4);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testPhoneNumberFieldWithThirtyOneNumber() {
		registerPage.textFieldHelper(registerPage.phoneNumberField, "1123456789012345678901234567890");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 4);
		Assert.assertEquals(actualError, "* PhoneNo can not be greater than 30 character.");
	}

	@Test
	public void testPhoneNumberFieldWithString() {
		registerPage.textFieldHelper(registerPage.phoneNumberField, "Integer");

		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 4);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testUserTypeFieldWithRandomOption() {
		registerPage.randomlySelectFromDropdownList(registerPage.userTypeDropdownElement);
		registerPage.submitButton.click();
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 5);
		Assert.assertEquals(actualError, "*");
	}

	@Test
	public void testEmailFieldWithValidEmail() {
		registerPage.textFieldHelper(registerPage.emailFieldElement, "joni_0023@yahoo.com");
		String actualError = registerPage.getTargetElementText(registerPage.errorElementList, 6);
		Assert.assertEquals(actualError, "*");

	}

}
