package pagespackage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base;
import methodpackages.Utility;

public class HomePage extends Base {

	By adminLink = By.xpath("//*[text()='Admin']");
	By userManagement = By.xpath("//*[text()='User Management']");
	By useres = By.cssSelector("a#menu_admin_viewSystemUsers");
	By welcomelink = By.cssSelector("a#welcome");
	By logout = By.xpath("//a[text()='Logout']");

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void goToUsers() {
		Utility.actionsMethods(driver, adminLink, "mouseover", null);

		Utility.actionsMethods(driver, userManagement, "mouseover", null);

		Utility.actionsMethods(driver, useres, "mouseclick", null);
	}

	public String verifyUsersPage() {
		return driver.getCurrentUrl();
	}

	public void logoutFromApp() {
		Utility.actionsMethods(driver, welcomelink, "mouseclick", null);

		Utility.actionsMethods(driver, logout, "mouseclick", null);
	}

}
