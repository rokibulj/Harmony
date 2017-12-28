package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class ExpiredJobsPage extends PageBase{
	
	@FindBy(xpath = ".//*[@id='application_status_head_container']")
	public  WebElement expiredJobsPageElement;

}
