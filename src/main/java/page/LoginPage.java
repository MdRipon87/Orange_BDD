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

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(xpath = "//input[@name='txtUsername']")
	WebElement USER_NAME_FIELD;
	@FindBy(xpath = "//input[@name='txtPassword']")
	WebElement PASSWORD_FIELD;
	@FindBy(xpath = "//input[@name='Submit']")
	WebElement SIGNIN_BUTTON;

	// Interactive Method

	public void entercredentials(String username, String Password) {
		USER_NAME_FIELD.sendKeys(username);
		PASSWORD_FIELD.sendKeys(Password);
	}

	public void clickOnSubmitButton() {
		SIGNIN_BUTTON.click();
	}

	public void validateDashboardHeader() {
		Assert.assertEquals("OrangeHRM", driver.getTitle());
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
