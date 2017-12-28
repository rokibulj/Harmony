package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.PageBase;

public class JobDetailPage extends PageBase{
	
	@FindBy(xpath = ".//*[@id='job_summary_content_style']/p")
	public WebElement jobOverviewElement;
	

}
