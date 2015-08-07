package com.shineSauceLabs.Main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import com.shineSauceLabs.config.BaseClass;
import com.shineSauceLabs.config.CommonMethods;
import com.shineSauceLabs.config.Elements;
@Listeners({SauceOnDemandTestListener.class})
public class MenuItems extends BaseClass implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider{
	
	@Test(priority=0)
	public void testCheckMenuItemJobs() throws InterruptedException{
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElementById(Elements.HELP_GOT_IT_ID).click();
	// driver.findElement(By.id("com.net.shine:id/dont_ask")).click();
	CommonMethods.startShineLogin("Login");
	existingUserLogin(userFull);
	//driver.findElementById("com.net.shine:id/search_button").click();
	driver.findElement(By.className(Elements.SIDE_MENU_CLASS)).click();
	Thread.sleep(2000);
	WebDriverWait w1 = new WebDriverWait(driver,10);
//	w1.until(ExpectedConditions.presenceOfElementLocated(By.id("com.net.shine:id/m_options")));
	//CommonMethods.selectMenuItems("matched_job","Jobs");
	//driver.scrollTo("Jobs");
	driver.findElementById("com.net.shine:id/matched_job").click();
	String text =driver.findElementById(Elements.HEADER_TEXT_ID).getText().replace(" ", "").trim();
	Assert.assertEquals(text, "MatchedJobs ");
	}
	@Test(priority=1)
	public void testCheckMenuIteminbox(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.className(Elements.SIDE_MENU_CLASS)).click();
		driver.findElement(By.id(Elements.SIDE_MENU_INBOX_BTN)).click();
	Assert.assertEquals(driver.findElementById(Elements.HEADER_TEXT_ID).getText(), "Inbox");
	
	}
	@Test(priority=2)
	public void testCheckMenuItemKonnect(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	CommonMethods.selectMenuItems("discover_layout","Shine Konnect");
	
	//driver.findElementById("com.net.shine:id/closeImg").click();
	
	//driver.findElement(By.id("com.net.shine:id/skip_btn")).click();
	if(driver.findElementById(Elements.HEADER_TEXT_ID).getText().contains("Import Contacts")){
//		if(isElementPresent(By.id("com.net.shine:id/close_update"))){
//			driver.findElement(By.id("com.net.shine:id/close_update")).click();
//		}
		driver.findElement(By.id(Elements.KONNECT_SKIP_BTN_ID)).click();
		Assert.assertEquals(isElementVisible(By.id("com.net.shine:id/sync_now_button")), true);
	} else {
		Assert.assertEquals(driver.findElementById(Elements.HEADER_TEXT_ID).getText(),"Shine Konnect");
		driver.findElement(By.id("com.net.shine:id/comp_cout")).getText();
	}
	}
	@Test(priority=3)
	public void testCheckMenuItemJobAlerts(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	CommonMethods.selectMenuItems("custom_job_alert","My Job Alerts");
//	driver.findElement(By.id(Elements.ALERT_CREATE_BTN_ID));
	//CommonMethods.createAlert();
	Assert.assertEquals(driver.findElementById(Elements.HEADER_TEXT_ID).getText(),"My Job Alerts");
	
	}
	@Test(priority=4)
	public void testCheckMenuItemProfileViews(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	CommonMethods.selectMenuItems("who_viewed","Profile Views");
	Assert.assertEquals(driver.findElementById(Elements.HEADER_TEXT_ID).getText(), "Profile Views  ");
	
//	int size=driver.findElementsById("com.net.shine:id/grid_view_profile").size();
	//Assert.assertNotEquals(size, 0);
	}
	
	//@Test
	public void testCheckMenuItemCareerInfo(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	CommonMethods.selectMenuItems("career_info_view","Career info");
	Assert.assertEquals(driver.findElementById(Elements.HEADER_TEXT_ID).getText(), "");
	
	}
	//@Test
	public void testCheckMenuItemCareerStore(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	CommonMethods.selectMenuItems("career_plus_view","");
	Assert.assertEquals(driver.findElementById(Elements.HEADER_TEXT_ID).getText(), "");
	
	}
	//@Test
	public void testCheckMenuItemRateApp(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	CommonMethods.selectMenuItems("rate_app","Rate the app");
	Assert.assertEquals(driver.findElementById(Elements.HEADER_TEXT_ID).getText(), "");
	
	}
	@Test(priority=5)
		public void testCheckMenuItemFeedBack(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		CommonMethods.selectMenuItems("feedback","Feedback");
		Assert.assertEquals(driver.findElementById("com.net.shine:id/feedback").getText(), "Your views & comments");
		driver.findElementById("com.net.shine:id/feedback").sendKeys("loren ispum");
		driver.findElementById("com.net.shine:id/submit_btn").click();
		//CommonMethods.clickDialog("Thank you for your feedback. This will help us in serving you better");
		//Assert.assertEquals(isElementPresent(By.id("com.net.shine:id/search_button")), true);
	}
	
	@Test(priority=6)
	public void testCheckMenuItemHelp(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	CommonMethods.selectMenuItems("help","Help");
	Assert.assertEquals(isElementPresent(By.id(Elements.HELP_GOT_IT_ID)), true);
	// swipe
	//driver.swipe(475, 500, 475, 200, 400) #swipe up
	//driver.swipe(475, 200, 475, 500, 400) #swipe down
	swipeLeft();
	swipeLeft();
	swipeLeft();
	swipeLeft();
	driver.findElementById(Elements.HELP_GOT_IT_ID).click();
	}
	@Test(priority=7)
	//need to add visible applied jobs
	public void testCheckMenuItemJobsApplied(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.className(Elements.SIDE_MENU_CLASS)).click();
	CommonMethods.selectMenuItems("jobs_applied","Jobs Applied");
	String text =driver.findElementById(Elements.HEADER_TEXT_ID).getText();
	Assert.assertEquals(text, "Applied Jobs    ");
	
	}
	@Test(priority=8)
	public void testCheckMenuItemLogout(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	CommonMethods.selectMenuItems("logout_view","Log Out");
	Assert.assertEquals(isElementPresent(By.id(Elements.LOGIN_BTN_ID)), true);
	
	
	}
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
		testName =testResult.getName();
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			System.out.println(testResult.getName()); 
			takeScreenshot(testResult.getName()+".jpg");

			 }
		//driver.close();
		//driver.quit();
		}
	
	@AfterClass
	public void tearDown() throws InterruptedException{
		driver.quit();
		downloadLog("MenuItems");
	}
	/**
    *
    * @return the Sauce Job id for the current thread
    */
   public String getSessionId() {
       return sessionId.get();
   }

   /**
    *
    * @return the {@link SauceOnDemandAuthentication} instance containing the Sauce username/access key
    */
   @Override
   public SauceOnDemandAuthentication getAuthentication() {
       return authentication;
   }
}
