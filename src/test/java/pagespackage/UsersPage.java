package pagespackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import basepackage.Base;

public class UsersPage extends Base{
	
	By tableUser = By.cssSelector("table[id='resultTable'] > tbody > tr > td:nth-of-type(2) > a");
	
	public UsersPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void usersInTable()
	{
		List <WebElement> usersLists = driver.findElements(tableUser);
		for (WebElement users : usersLists)
		{
			Reporter.log(users.getText(), true);
		}
	}

}
