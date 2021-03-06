package methodpackages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static WebDriverWait wait;
	

	public static void clickOperation(WebDriver driver, By locator) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		boolean loctorStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		if (loctorStatus) {
			driver.findElement(locator).click();
		}

	}

	public static void inputOperations(WebDriver driver, By locator, String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		boolean loctorStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		if (loctorStatus) {
			driver.findElement(locator).sendKeys(value);
		}

	}
	
	public static void actionsMethods(WebDriver driver, By locator, String Operation, String value)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(locator);
		boolean locatorStatus = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		if (locatorStatus)
		{
			if (Operation.equalsIgnoreCase("mouseover"))
			{
				act.moveToElement(element).perform();
			}
			else if (Operation.equalsIgnoreCase("mouseclick"))
			{
				act.click(element).perform();
			}
			
			
			else if (Operation.equalsIgnoreCase("type") && value != null)
			{
				act.sendKeys(value).perform();
			}
			
			else if (Operation.equalsIgnoreCase("moveclick"))
			{
				act.moveToElement(element).click(element).build().perform();
			}
			else
			{
				System.out.println("No Such Operation");
			}
		}
	}

}
