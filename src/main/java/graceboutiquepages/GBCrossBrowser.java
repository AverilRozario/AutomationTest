package graceboutiquepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class GBCrossBrowser {

	public static WebDriver driverr;
	RemoteWebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void crossBrowser(@Optional("chrome") String browser)
	{

		if(browser.equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else 
		{
			driver=new FirefoxDriver();
		}
		

	}
}
