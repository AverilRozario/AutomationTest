package graceboutiquetests;

import org.testng.annotations.Test;

import graceboutiquepages.GBCrossBrowsePage;
import graceboutiquepages.GBCrossBrowser;

public class GBCrossBrowseTest extends GBCrossBrowser{
	
	@Test
	public void crossBrowseTest()
	{
		GBCrossBrowsePage CB = new GBCrossBrowsePage(driverr);
		
		CB.crossBrowse();
	}
}
