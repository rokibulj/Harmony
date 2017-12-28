package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class CurrentJobsPage extends PageBase{

	@FindBy(xpath = ".//*[@id='job_field_display_style5']/h3")
	public WebElement daysLeftElement;
	
	@FindBy(linkText = "Manage Application")
	public WebElement manageApplicationElement;
	
}
