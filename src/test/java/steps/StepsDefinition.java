package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.LoginPage;
import page.MyInfoPage;
import utill.BrowserFactory;

public class StepsDefinition {

	WebDriver driver;
	LoginPage login;
	MyInfoPage myInfo;
	String Website = "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";

	@Before
	public void beforeRun() {
		driver = BrowserFactory.initialization();
		login = PageFactory.initElements(driver, LoginPage.class);
		myInfo = PageFactory.initElements(driver, MyInfoPage.class);

	}

	@Given("^User is on OrangHRM login page$")
	public void user_is_on_OrangHRM_login_page() {
		driver.get(Website);
	}

	@When("^User enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String username, String Password) {
		login.entercredentials(username, Password);
	}

	@When("^User clicks on login button$")
	public void user_clicks_on_login_button() {
		login.clickOnSubmitButton();
	}

	@Then("^User should be able to see the dashboard$")
	public void user_should_be_able_to_see_the_dashboard() throws IOException {
		login.validateDashboardHeader();

	}

	@When("^User clicks on Myinfo$")
	public void user_clicks_on_Myinfo() {
		myInfo.clickOnMyInoButton();
	}

	@Then("^User clicks on edit$")
	public void user_clicks_on_edit() {
		myInfo.clickOnEditButton();
	}

	@Then("^User enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and_and_and_and_and_and_and_and_and_and_and_and_and(String FirstName, String MiddleName,
			String LastName, String EmployeeID, String OtherID, String DriverLicenseNumber, String LicenseExpireMonth,
			String LicenseExpireYear, String ssnNumber, String sinNumber, String MaritalStatus, String Nationality,
			String dobMonth, String dobYear) {
		myInfo.enterPersonalInfo(FirstName, MiddleName, LastName, EmployeeID, OtherID, DriverLicenseNumber,
				LicenseExpireMonth, LicenseExpireYear, ssnNumber, sinNumber, MaritalStatus, Nationality, dobMonth,
				dobYear);
	}

	@Then("^User clicks on save$")
	public void user_clicks_on_save() throws IOException  {
		myInfo.clickOnSaveButton();
		myInfo.takeScreenshotAtEndOfTest(driver);
	}

	 @After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
