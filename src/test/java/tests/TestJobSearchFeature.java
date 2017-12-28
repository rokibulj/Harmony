package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import base.TestBase;
import pages.JobDetailPage;

public class TestJobSearchFeature extends TestBase {

	@BeforeClass
	public void classSetup(){
		menuBar.jobSearch.click();
	}
	
	@AfterClass
	public void classTearDown(){
		menuBar.jobSearch.click();
	}
	
	@BeforeMethod
	public void testDirectoryReset(){
		menuBar.jobSearch.click();
	}
	
	@Test
	public void testJobCategoryFromdropdownList(){
		jobSearchPage.randomlySelectFromDropdownList(jobSearchPage.jobCategoryDropdownElement);
//		System.out.println(selectedCategory);
		jobSearchPage.searhButtonElement.click();
		String searchResult = jobSearchPage.searchResultElement.getText();
		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/jobsearch"));
		Assert.assertEquals(searchResult, "Search Result");	
	}
	
	@Test
	public void testSearchResultCategorySimilarity(){
		String jobCategorySelect = jobSearchPage.randomlySelectFromDropdownList(jobSearchPage.jobCategoryDropdownElement);
		jobSearchPage.searhButtonElement.click();
		if(jobSearchPage.getSearchResultCount() > 0){
			String clickedJobTitle = jobSearchPage
					.randomlyClickFromListOfElement(jobSearchPage.jobDivTitleElement, true);
			System.out.println(clickedJobTitle);
		}
	
		String jobOverviewText = jobDetailPage.jobOverviewElement.getText();
		Assert.assertTrue(jobOverviewText.contains(jobCategorySelect));
	}
	
	@Test
	public void testJobCategorySearchResultCount(){
		String jobCategorySelect = jobSearchPage
				.randomlySelectFromDropdownList(jobSearchPage.jobCategoryDropdownElement);
		jobSearchPage.searhButtonElement.click();
		
		int rowNumber = jobSearchPage.jobRowElement.size();
		System.out.println(rowNumber);
	}
}
