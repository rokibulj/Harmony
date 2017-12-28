package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class ProfilePage extends PageBase {

	@FindBy(linkText = "EXPIRED JOBS")
	public WebElement expiredJobsElement;
	
	@FindBy(linkText = "ADMIN PANEL")
	public WebElement adminPanelElement;
	
	@FindBy(linkText = "CURRENT JOBS")
	public WebElement currentJobsElement;
	
}
