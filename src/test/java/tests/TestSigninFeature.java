package tests;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.SigninPage;

public class TestSigninFeature extends TestBase {

	@BeforeClass
	public void classSetUp() {
		menuBar.signInLink.click();
	}
	
	
	@AfterClass
	public void tearDown(){
		menuBar.jobSearch.click();
	}

	@Test
	public void testSignInWithValidCredentials() {
		signinPage.signIn("shakil_ipe@yahoo.com", "365827");
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/profile"));

		menuBar.logOutLink.click();
		menuBar.signInLink.click();

	}

	@Test
	public void testSignInWithInvalidEmailValidPassword() {
		signinPage.signIn("invalid@yahoo.com", "365827");
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/signin"));
		String actualError = signinPage.getTargetElementText(signinPage.errorElementList, 0);
		Assert.assertEquals(actualError, "* Email or Password is incorrect.");

	}

	@Test
	public void testSignInWithValidEmailInvalidPassword() {
		signinPage.signIn("shakil_ipe@yahoo.com", "invalid");
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/signin"));
		String actualError = signinPage.getTargetElementText(signinPage.errorElementList, 0);
		Assert.assertEquals(actualError, "* Email or Password is incorrect.");
	}

	@Test
	public void testSignInWithInvalidEmailPassword() {
		signinPage.signIn("invalid@yahoo.com", "invalid");
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/signin"));
		String actualError = signinPage.getTargetElementText(signinPage.errorElementList, 0);
		Assert.assertEquals(actualError, "* Email or Password is incorrect.");
	}

	@Test
	public void testSignInWithEmptyEmailValidPassword() {
		signinPage.signIn("", "365827");
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/signin"));
		String actualError = signinPage.getTargetElementText(signinPage.errorElementList, 0);
		Assert.assertEquals(actualError, "* Email can not be empty.");
	}

	@Test
	public void testSignInWithValidEmailEmptyPassword() {
		signinPage.signIn("shakil_ipe@yahoo.com", "");
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/signin"));

		String actualError = signinPage.getTargetElementText(signinPage.errorElementList, 0);
		Assert.assertEquals(actualError, "* Email or Password is incorrect.");

		actualError = signinPage.getTargetElementText(signinPage.errorElementList, 1);
		Assert.assertEquals(actualError, "* Password can not be empty.");
	}

	@Test
	public void testSignInWithoutCredentials() {
		signinPage.signIn("", "");
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/signin"));

		String actualError = signinPage.getTargetElementText(signinPage.errorElementList, 0);
		Assert.assertEquals(actualError, "* Email can not be empty.");

		actualError = signinPage.getTargetElementText(signinPage.errorElementList, 1);
		Assert.assertEquals(actualError, "* Password can not be empty.");
	}
}
