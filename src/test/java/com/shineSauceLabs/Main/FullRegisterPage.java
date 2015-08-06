package com.shineSauceLabs.Main;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnsupportedCommandException;
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
public class FullRegisterPage extends BaseClass implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {

	@Test
	public void testRegisterwithResume() throws InterruptedException, UnsupportedCommandException{
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElementById(Elements.HELP_GOT_IT_ID).click();
		CommonMethods.getResume();
		CommonMethods.startShineLogin("register");
		CommonMethods.enterRegistrationDetails("");
		CommonMethods.uploadResume("yes","Resumes (1).doc");
		//CommonMethods.uploadResume("no","");
		CommonMethods.editResumeDetails("Regular");
		CommonMethods.selectMenuItems("logout_view","Log Out");
		}
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException, UnsupportedCommandException { 
		testName =testResult.getName();
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			System.out.println(testResult.getStatus()); 
			takeScreenshot(testResult.getName()+".jpg");
		
		 }
		//driver.close();
		driver.quit();
		}
	@AfterClass
	public void tearDown() throws InterruptedException{
		downloadLog("FullRegisterPage");
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
