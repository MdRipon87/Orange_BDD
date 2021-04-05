package page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyInfoPage extends BasePage {

	WebDriver driver;

	public MyInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(xpath = "//b[text()='My Info']")
	WebElement MYINFO_BUTTON;
	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement EDIT_BUTTON;
	@FindBy(xpath = "//input[@name='personal[txtEmpFirstName]']")
	WebElement FIRST_NAME_FIELD;
	@FindBy(xpath = "//input[@name='personal[txtEmpMiddleName]']")
	WebElement MIDDLE_NAME_FIELD;
	@FindBy(xpath = "//input[@name='personal[txtEmpLastName]']")
	WebElement LAST_NAME_FIELD;
	@FindBy(xpath = "//input[@name='personal[txtEmployeeId]']")
	WebElement EMPLOYEE_ID_FIELD;
	@FindBy(xpath = "//input[@name='personal[txtOtherID]']")
	WebElement OTHER_ID_FIELD;
	@FindBy(xpath = "//input[@name='personal[txtLicenNo]']")
	WebElement DRIVER_LICENSE_NUMBER_FIELD;

	@FindBy(xpath = "//*[@id=\"personal_txtLicExpDate\"]")
	WebElement LICENSE_DOB_FIELD;
	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	WebElement LICENSE_EXPIRE_MONTH_FIELD;
	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	WebElement LICENSE_EXPIRE_YEAR_FIELD;

	@FindBy(xpath = "//input[@name='personal[txtNICNo]']")
	WebElement SSN_FIELD;
	@FindBy(xpath = "//input[@name='personal[txtSINNo]']")
	WebElement SIN_FIELD;

	@FindBy(xpath = "//input[@id='personal_optGender_1']")
	WebElement GENDER_FIELD;
	@FindBy(xpath = "//select[@name='personal[cmbMarital]']")
	WebElement MARITAL_STATUS_FIELD;
	@FindBy(xpath = "//select[@name='personal[cmbNation]']")
	WebElement NATIONALITY_FIELD;

	@FindBy(xpath = "//input[@name='personal[DOB]']")
	WebElement DOB_CLICK_FIELD;
	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	WebElement DOB_MONTH_FIELD;
	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	WebElement DOB_YEAR_FIELD;

	@FindBy(xpath = "//input[@ID='btnSave']")
	WebElement SAVE_BUTTON;

	// Interactive Methods
	public void clickOnMyInoButton() {
		MYINFO_BUTTON.click();
	}

	public void validateDashboardHeader() {
		Assert.assertEquals("OrangeHRM", driver.getTitle());
	}

	public void clickOnEditButton() {
		EDIT_BUTTON.click();
	}

	public void enterPersonalInfo(String FirstName, String MiddleName, String LastName, String EmployeeID,
			String OtherID, String DriverLicenseNumber, String LicenseExpireMonth, String LicenseExpireYear,
			String ssnNumber, String sinNumber, String MaritalStatus, String Nationality, String dobMonth,
			String dobYear) {
		int genaratorNumber = randomGenerator(999);
		FIRST_NAME_FIELD.sendKeys(FirstName);
		MIDDLE_NAME_FIELD.sendKeys(MiddleName);
		LAST_NAME_FIELD.sendKeys(LastName);
		EMPLOYEE_ID_FIELD.sendKeys(EmployeeID);
		OTHER_ID_FIELD.sendKeys(OtherID + genaratorNumber);
		DRIVER_LICENSE_NUMBER_FIELD.sendKeys(DriverLicenseNumber);
		LICENSE_DOB_FIELD.click();
		waitForElement(driver, 10, LICENSE_EXPIRE_MONTH_FIELD);
		selectDropDown(LICENSE_EXPIRE_MONTH_FIELD, LicenseExpireMonth);
		selectDropDown(LICENSE_EXPIRE_YEAR_FIELD, LicenseExpireYear);
		SSN_FIELD.sendKeys(ssnNumber);
		SIN_FIELD.sendKeys(sinNumber + genaratorNumber);
		GENDER_FIELD.click();
		selectDropDown(MARITAL_STATUS_FIELD, MaritalStatus);
		selectDropDown(NATIONALITY_FIELD, Nationality);
		DOB_CLICK_FIELD.click();
		selectDropDown(DOB_MONTH_FIELD, dobMonth);
		selectDropDown(DOB_YEAR_FIELD, dobYear);
	}

	public void clickOnSaveButton() {
		SAVE_BUTTON.click();
	}

	public void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {

		TakesScreenshot ts = ((TakesScreenshot) driver);
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(sourceFile, new File(currentDir + "/screenshot/" + label + ".png"));
	}

}
