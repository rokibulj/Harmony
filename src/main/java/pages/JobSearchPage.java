package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.PageBase;

public class JobSearchPage extends PageBase {
	
	@FindBy(name = "JobCategory")
	public WebElement jobCategoryDropdownElement;
	
	@FindBy(name = "submit")
	public WebElement searhButtonElement;
	
	@FindBy(id = "application_status_head_container")
	public WebElement searchResultElement;
	
	@FindBy(xpath = ".//*[@id='application_status_container']/p/b")
	private WebElement searchResultCount;
	
	@FindBy(id = "job_display_style")
	public List<WebElement> jobRowElement;

	
//	@FindBys(@FindBy(id = "job_title_style"))
//	public List<WebElement> jobTitleElement;
	
	@FindBy(id = "job_title_style")
	public List<WebElement> jobDivTitleElement;
	
	public int getSearchResultCount(){
		int count = 0;
		count = Integer.valueOf(searchResultCount.getText());
		
		return count;
	}

	
}
