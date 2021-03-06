package pagespackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base;
import methodpackages.Utility;

public class LoginPage extends Base {

	By user = By.cssSelector("input#txtUsername");
	By password = By.cssSelector("input#txtPassword");
	By submit = By.cssSelector("input#btnLogin");

	@SuppressWarnings("static-access")
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String username, String pass) {

		Utility.inputOperations(driver, user, username);

		Utility.inputOperations(driver, password, pass);

		Utility.clickOperation(driver, submit);

	}
	
	public String titleOfPage()
	{
		return driver.getTitle();
	}

}
