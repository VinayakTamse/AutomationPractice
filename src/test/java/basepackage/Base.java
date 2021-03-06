package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

public class Base {

	public static FileInputStream file;
	public static WebDriver driver;
	public static Properties props;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	File infoFile;
	String infoFileName = System.getProperty("user.dir") + "\\src\\test\\resources\\info.properties";

	public Base() {

		infoFile = new File(infoFileName);
		try {
			file = new FileInputStream(infoFile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		props = new Properties();

		try {
			props.load(file);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public static void Initialize(String browser)
	{
		driver = BrowserFactory.chooseBrowser(browser);
		driver.get(props.getProperty("appurl"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}
	
	@BeforeSuite
	public void reports()
	{
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\sparkreports.html");
		extent.attachReporter(spark);
		
	}
	
	@BeforeMethod
	@Parameters("Browser_Name")
	public void setUp(String Browser)
	{
		
		Initialize(Browser);
		
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}
	
	@AfterSuite
	public void reportsTear()
	{
		extent.flush();
	}

}
