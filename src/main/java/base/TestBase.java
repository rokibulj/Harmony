package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import pages.ApplicationPage;
import pages.CurrentJobsPage;
import pages.ExpiredJobsPage;
import pages.JobDetailPage;
import pages.JobSearchPage;
import pages.ManageApplicationPage;
import pages.MenuBar;
import pages.ProfilePage;
import pages.RegistrationPage;
import pages.RepresentativePage;
import pages.SigninPage;

@Listeners(listener.EliteListener.class)
public class TestBase extends SauceLabs {

	public static MenuBar menuBar;
	public static SigninPage signinPage;
	public static RegistrationPage registerPage;
	public static JobSearchPage jobSearchPage;
	public static JobDetailPage jobDetailPage;
	public static ExpiredJobsPage expiredJobsPage;
	public static ProfilePage profilePage;
	public static RepresentativePage representativePage;
	public static CurrentJobsPage currentJobsPage;
	public static ManageApplicationPage manageApplicationPage;
	public static ApplicationPage applicationPage;

	@BeforeSuite
	public void setup() {
		if (Boolean.valueOf(getProperty("saucelabs"))) {
			// to run test in SauceLabs
			setSauceLabs();
		} else {
			// to run test in Local machine
			setDriver();
		}

		setDriverProperties();

		menuBar = PageFactory.initElements(driver, MenuBar.class);
		signinPage = PageFactory.initElements(driver, SigninPage.class);
		registerPage = PageFactory.initElements(driver, RegistrationPage.class);
		jobSearchPage = PageFactory.initElements(driver, JobSearchPage.class);
		jobDetailPage = PageFactory.initElements(driver, JobDetailPage.class);
		expiredJobsPage = PageFactory.initElements(driver, ExpiredJobsPage.class);
		profilePage = PageFactory.initElements(driver, ProfilePage.class);
		representativePage = PageFactory.initElements(driver, RepresentativePage.class);
		currentJobsPage = PageFactory.initElements(driver, CurrentJobsPage.class);
		manageApplicationPage = PageFactory.initElements(driver, ManageApplicationPage.class);
		applicationPage = PageFactory.initElements(driver, ApplicationPage.class);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
