package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import base.PageBase;

public class MenuBar extends PageBase{
	
	@FindBy(linkText = "Job Search")
	public WebElement jobSearch;
	
	@FindBy(linkText = "Signin")
	public WebElement signInLink;
	
	@FindBy(linkText = "Logout")
	public WebElement logOutLink;
	
	@FindBy(linkText = "Register")
	public WebElement registerLink;
	

}
