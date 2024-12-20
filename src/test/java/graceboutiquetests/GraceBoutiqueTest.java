package graceboutiquetests;

import java.io.IOException;

import org.testng.annotations.Test;

import graceboutiquepages.GraceBoutiqueBaseClass;
import graceboutiquepages.GraceBoutiquePage;

public class GraceBoutiqueTest extends GraceBoutiqueBaseClass{

	@Test
	public void GBTest () throws InterruptedException, IOException
	{
		GraceBoutiquePage GB=new GraceBoutiquePage(driver);
		
        	// Verify title
		GB.titleVerification();
		
        	// Verify logo visibility
		GB.verifyLogo();

		// Verify link count and broken links
		GB.linkCount();

		// Verify page source contains specific text
		GB.pageSource();

		// Test user registration and login flow
		GB.loginIcon();
		GB.createAccount();
		GB.registerSetValues("Averil", "Rozario", "averilrozario187@gmail.com", "9746598710", "aq@E1wr2", "aq@E1wr2");
		GB.registerClick();

		// Login after registration
		GB.login();
		GB.loginSetValues("averilrozario187@gmail.com", "aq@E1wr2");
		GB.loginClick();
		
		//GB.alertHandle();

		// Scroll and interact with page elements
		GB.scrollDown();
		GB.moveToElement();

		// Perform search and item interaction
		GB.searchBar();
		GB.salwarClick();
		GB.sortBy();
		GB.itemClick();
		GB.addToCart();

		// Capture screenshot
		GB.screenShot();
	}
	
}
