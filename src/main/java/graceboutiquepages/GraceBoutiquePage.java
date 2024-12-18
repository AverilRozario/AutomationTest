package graceboutiquepages;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GraceBoutiquePage {

	WebDriver driver;
	
	//Registration Page
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[2]/div/div[4]/ul/li[2]/a")
	WebElement LoginIcon;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[5]/div[2]/a")
	WebElement CreateAccount;
	
	@FindBy(name = "fname")
	WebElement FirstName;
	
	@FindBy(xpath = "//*[@id=\"userSignupForm\"]/div/div[2]/div/input")
	WebElement LastName;
	
	@FindBy(xpath = "//*[@id=\"userSignupForm\"]/div/div[3]/div/input")
	WebElement Email;
	
	@FindBy(xpath = "//*[@id=\"userSignupForm\"]/div/div[4]/div/input")
	WebElement PhoneNumber;
	
	@FindBy(xpath = "//*[@id=\"pwd1\"]")
	WebElement Password;
	
	@FindBy(xpath = "//*[@id=\"userSignupForm\"]/div/div[6]/div/input")
	WebElement ConfirmPassword;
	
	@FindBy(xpath = "//*[@id=\"userSignupForm\"]/div/div[7]/div/input")
	WebElement CreateAccButton;
	
	// Login Page
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[1]/div/input")
	WebElement LoginEmail;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[2]/div/input")
	WebElement LoginPassword;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[3]/div/input")
	WebElement LoginButton;
	
	//Home Page
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[1]/div/div[1]/a[1]")      //alert
	WebElement WhatsappNum;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[5]/div/div/a")
	WebElement ScrollItem;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[3]/div/div/ul/li[1]/a")     //move to element
	WebElement ProductsForSale;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[3]/div/div/ul/li[1]/ul/li[5]/a")
	WebElement Fabrics;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[4]/div/div/div/div[2]/ul/li[5]/a")
	WebElement Duppattas;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[2]/div/div[2]/form/input")
	WebElement SearchBar;
	
	@FindBy(xpath ="//*[@id=\"container-box\"]/div[2]/div/div[3]/a/img")
	WebElement GraceLogo;
	
	@FindBy(xpath ="//*[@id=\"container-box\"]/div[4]/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/ul/li/a")   //select list
	WebElement SortBy;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[4]/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/ul/li/ul/li[4]/a")
	WebElement Price;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[4]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/a")
	WebElement Item;
	
	@FindBy(xpath = "//*[@id=\"purchaseOpsSec\"]/div[1]/div[1]/div[2]/div/div[2]")
	WebElement Quantity;
	
	@FindBy(xpath = "//*[@id=\"favHeartIco\"]")
	WebElement Wishlist;
	
	@FindBy(xpath = "//*[@id=\"addToCartBtn\"]")
	WebElement AddToCart;
	
	@FindBy(xpath = "//*[@id=\"buyItNowBtn\"]")
	WebElement BuyitNow;
	
	@FindBy(xpath = "//*[@id=\"state\"]")
	WebElement State;
	
	@FindBy(xpath = "//*[@id=\"pincode\"]")
	WebElement Pincode;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[4]/div/div/div/div[1]/div[2]/div[5]/a")
	WebElement ReturnPolicy;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[4]/div/div/div/div[5]/ul/li[13]/a")
	WebElement Next;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[4]/div/div/div/div[5]/ul/li[1]/a")
	WebElement Previous;
	
	@FindBy(xpath = "//*[@id=\"container-box\"]/div[4]/div/div/div/div[5]/ul/li[16]/a")
	WebElement Last;
	
	
	public GraceBoutiquePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void linkCount()
	{
		List<WebElement> linkdetails = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of links: "+linkdetails.size());
		
		for(WebElement element: linkdetails) {
			@SuppressWarnings("deprecation")
			String link = element.getAttribute("href");
			verify(link);
		}
	}
	
	private void verify(String link)
	{
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(link);
			HttpURLConnection connect = (HttpURLConnection)url.openConnection();
			int code = connect.getResponseCode();
			
			if(code == 404) {
				System.out.println("Response code is Not Found: "+link);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}	
		
	}

	public void loginIcon()
	{
		LoginIcon.click();
	}
	
	public void createAccount()
	{
		String registerWindow = "https://www.graceboutiqueangamaly.com/signup/?rdt=account%2Ffavorites%2F";
		
		Set <String> createaccount = driver.getWindowHandles();
		for(String handles: createaccount)
		{
			if(!handles.equalsIgnoreCase(registerWindow))
			{
				driver.switchTo().window(handles);
				CreateAccount.click();
			}
		}
	}
	
	public void registerSetValues(String fname, String lname, String email, String phone, String password, String confirm)
	{
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		Email.sendKeys(email);
		PhoneNumber.sendKeys(phone);
		Password.sendKeys(password);
		ConfirmPassword.sendKeys(confirm);
	}
	
	public void registerClick()
	{
		CreateAccButton.click();
	}

	public void login()
	{
		driver.navigate().back();
		LoginIcon.click();
	}
	
	public void loginSetValues(String email, String password)
	{
		LoginEmail.sendKeys(email);
		LoginPassword.sendKeys(password);
	}
	
	public void loginClick()
	{
		LoginButton.click();
	}
	
	//public void alertHandle() throws InterruptedException
	//{
		//WhatsappNum.click();
		//Thread.sleep(6000);
		//Alert a = driver.switchTo().alert();
		//a.dismiss();
	//}

	public void verifyLogo() 
	{
		GraceLogo.isDisplayed();
	}
	
	public void titleVerification()
	{
		String actual = driver.getTitle();
		String expect = "Grace Boutique - Fashion Exclusively only for you";
		
		Assert.assertEquals(actual, expect);
	}
	
	public void pageSource()
	{
		String pgsrc = driver.getPageSource();
		
		if(pgsrc.contains("outfits"))
		{
			System.out.println("It contains");
		}
		else
		{
			System.out.println("It not contains");
		}
	}
	
	public void moveToElement()
	{
		Actions action = new Actions(driver);
		action.moveToElement(ProductsForSale).perform();
		Fabrics.click();
	}
	
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ScrollItem);
	}
	
	public void searchBar()
	{
		SearchBar.sendKeys("Salwar" ,Keys.ENTER);
	}
	
	public void salwarClick()
	{
		String salwarURL = "https://www.graceboutiqueangamaly.com/all-collections/?q=Salwar";
		String currentWindow = driver.getWindowHandle();
		
		Set <String> salwar = driver.getWindowHandles();
		for(String handles: salwar)
		{
			driver.switchTo().window(handles);
			if(driver.getCurrentUrl().equals(salwarURL))
			{
				Duppattas.click();
				break;
			}
		}
		driver.switchTo().window(currentWindow);
	}
	
	public void sortBy()
	{
		String duppattaURL = "https://www.graceboutiqueangamaly.com/collections/Duppattas/";
		String currentWindow = driver.getWindowHandle();
		
		Set <String> duppatta = driver.getWindowHandles();
		for(String handles: duppatta)
		{
			driver.switchTo().window(handles);
			if(driver.getCurrentUrl().equals(duppattaURL))
			{
				SortBy.click();
				break;
			}
		}
		driver.switchTo().window(currentWindow);
		Price.click();
	}
	
	public void itemClick()
	{
		String itemURL = "https://www.graceboutiqueangamaly.com/collections/Duppattas/?q=&sort=ltoh";
		String currentWindow = driver.getWindowHandle();
		
		Set <String> item = driver.getWindowHandles();
		for(String handles: item)
		{
			driver.switchTo().window(handles);
			if(driver.getCurrentUrl().equals(itemURL))
			{
				Item.click();
				break;
			}
		}
		driver.switchTo().window(currentWindow);
	}
	
	public void addToCart()
	{
		AddToCart.click();
	}
	
	public void screenShot() throws IOException
	{
		File scrnsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrnsht, new File("./screenshot/viewScreen.png"));
	}
}
