package tests;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.SigninPage;

public class TestExpiredJobsFeature extends TestBase {

	@BeforeClass
	public void classSetup() {
		menuBar.signInLink.click();
		signinPage.signIn("shakil_ipe@yahoo.com", "365827");
	}

//	@BeforeMethod
//	public void testSigninDirectory() {
//		
//	}

	@Test
	public void testExpiredJobsSearch() {
		profilePage.expiredJobsElement.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/expiredjobs"));
		String expiredJobs = expiredJobsPage.expiredJobsPageElement.getText();
		System.out.println(expiredJobs);
		Assert.assertEquals(expiredJobs, "Expired Jobs");
	}
	
	
}
