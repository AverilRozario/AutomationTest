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

		GB.titleVerification();
		
		GB.verifyLogo();
		
		//GB.linkCount();

		//GB.pageSource();
		
		GB.loginIcon();
		
		GB.createAccount();
		GB.registerSetValues("Averil", "Rozario", "averilrozario187@gmail.com", "9746598710", "aq@E1wr2", "aq@E1wr2");
		GB.registerClick();
		
		GB.login();
		
		GB.loginSetValues("averilrozario187@gmail.com", "aq@E1wr2");
		GB.loginClick();
		
		//GB.alertHandle();
		
		GB.scrollDown();
		
		GB.moveToElement();
		
		GB.searchBar();
		
		GB.salwarClick();
		
		GB.sortBy();
		
		GB.itemClick();
		GB.addToCart();
		GB.screenShot();
	}
	
}
