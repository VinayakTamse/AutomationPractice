package basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	

	public static WebDriver chooseBrowser(String browsername) {
		
		WebDriver driver = null;

		switch (browsername) {

		case "chrome":

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().window().maximize();
			
			break;

		case "firefox":

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");

			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			
			break;
			
			default:
				System.out.println("No Such Browser");

		}
		
		return driver;
		
		
	}

}
