package tests;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestCurrentJobFeature extends TestBase{
	
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
	public void testClickOnCurrentJobLink(){
		profilePage.currentJobsElement.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/currentjobs"));
		String daysLeft = currentJobsPage.daysLeftElement.getText();
		System.out.println(daysLeft);
		Assert.assertEquals(daysLeft, "Days Left");
	}
	
	@Test
	public void testClickOnManageApplicationPage(){
		profilePage.currentJobsElement.click();
		currentJobsPage.manageApplicationElement.click();
		String jobApplications = manageApplicationPage.jobApplicationsElement.getText();
		System.out.println(jobApplications);
		Assert.assertEquals(jobApplications, "Job Applications");
		
	}

}
