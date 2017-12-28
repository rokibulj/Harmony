package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class RepresentativePage extends PageBase {

	@FindBy(id = "job_display_style")
	public List<WebElement> jobRowElement;

}
