package tests;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestManageApplicationFeature extends TestBase{
	@BeforeClass
	public void classSetup() {
		menuBar.signInLink.click();
		signinPage.signIn("shakil_ipe@yahoo.com", "365827");
	}

	@AfterClass
	public void tearDown() {
		menuBar.jobSearch.click();
	}
	
	@Test
	public void testRandomlySelectApplicationFromList(){
		profilePage.currentJobsElement.click();
		currentJobsPage.manageApplicationElement.click();
		
	}
}
