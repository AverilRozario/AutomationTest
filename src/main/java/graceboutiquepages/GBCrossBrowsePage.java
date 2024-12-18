package graceboutiquepages;

import org.openqa.selenium.WebDriver;

public class GBCrossBrowsePage {

	WebDriver driverr;
	
	public GBCrossBrowsePage(WebDriver driverr)
	{
		this.driverr=driverr;
	}
	
	public void crossBrowse()
	{
		driverr.get("https://www.graceboutiqueangamaly.com/");
	}
}
