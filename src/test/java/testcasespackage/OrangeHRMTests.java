package testcasespackage;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basepackage.Base;
import pagespackage.HomePage;
import pagespackage.LoginPage;

public class OrangeHRMTests extends Base{
	
	LoginPage login;
	HomePage home;
	
	
	@Test(priority=1)
	public void loginTest()
	{
		test = extent.createTest("Login Test", "Simple Login Test").log(Status.INFO, "Login Test Started");
		login = new LoginPage();
		login.loginToApplication(props.getProperty("username"), props.getProperty("password"));
		test.log(Status.PASS, "Login Success");
		
		
	}
	
	@Test(priority=2)
	public void verifyLoginTitle()
	{
		
		test = extent.createTest("Verify Login Title", "Title for Login Test").log(Status.INFO, "Login Title test");
		login = new LoginPage();
		login.loginToApplication(props.getProperty("username"), props.getProperty("password"));
		Assert.assertEquals("OrangeHRM", login.titleOfPage());
		test.log(Status.PASS, "Title Verification is Success");
		
	}
	
	@Test(priority=3)
	public void usersTest()
	{
		
		test = extent.createTest("Verify The Users").log(Status.INFO, "Verify Users");
		login = new LoginPage();
		home = new HomePage();
		login.loginToApplication(props.getProperty("username"), props.getProperty("password"));
		home.goToUsers();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers", home.verifyUsersPage());
		test.pass("Users Verified");
		
		
		
	}
	
	@Test(priority=4)
	public void LogoutTest()
	{
		
		test = extent.createTest("Logout Test", "Simple Logout Test").log(Status.INFO, "Logout Test Started");
		login = new LoginPage();
		home = new HomePage();
		login.loginToApplication(props.getProperty("username"), props.getProperty("password"));
		home.logoutFromApp();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/auth/login", home.verifyUsersPage());
		test.pass("Logout Test is Success");
		
	}
	

}
