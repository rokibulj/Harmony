package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

public class TestAdminPanelFeature extends TestBase {

	@BeforeClass
	public void classSetup() {
		menuBar.signInLink.click();
		signinPage.signIn("shakil_ipe@yahoo.com", "365827");
	}
	
	@BeforeMethod
	public void clickOnAdminPanel(){
		profilePage.adminPanelElement.click();
	}
	

	@AfterClass
	public void tearDown() {
		menuBar.jobSearch.click();
	}

//	@Test
//	public void testAdminPanel() {
//		
//		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/representative."));
//	}

	@Test
	public void testRandomlySelectAdmin() {
		profilePage.randomlyClickFromListOfElement(representativePage.jobRowElement, true);
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/edit_representative"));
	}

}
