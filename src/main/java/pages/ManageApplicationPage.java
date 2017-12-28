package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class ManageApplicationPage extends PageBase{
 
	@FindBy(xpath = ".//*[@id='application_status_head_container']")
	public WebElement jobApplicationsElement;
	
	@FindBy(xpath = ".//*[@id='job_field_display_style5']/a")
	public List<WebElement> viewManageApplicationElenent;
	
}
