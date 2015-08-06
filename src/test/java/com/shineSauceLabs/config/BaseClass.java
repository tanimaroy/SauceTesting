package com.shineSauceLabs.config;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.HasNetworkConnection;

import java.awt.AWTException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.ITestResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonArray;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.common.Utils;
import com.saucelabs.saucerest.SauceREST;
import com.saucelabs.saucerest.SecurityUtils;
import com.saucelabs.testng.SauceOnDemandTestListener;
@Listeners({SauceOnDemandTestListener.class})
public class BaseClass implements SauceOnDemandSessionIdProvider{
	
	protected static AppiumDriver driver;
	protected static String saucePass="";
	protected static String sauceUser="";
	//public static WebDriver driver;
	public static AndroidDriver dri;
	public static int userFull = 0;
	public static int userHalf = 0;
	public static String fullName= " ";
	public static String keyword= " ";
	public static String jobApplied= " ";
	public static String jobID = " ";
	public static Date date;
	public static DateFormat dateFormat;
	public static String userName = " ";
	public static String testName = " ";
	public static List<String> url ;
	public static Properties CONFIG;
	public static ITestResult tr;
	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(sauceUser, saucePass);
	
	 public static ThreadLocal<String> sessionId = new ThreadLocal<String>();
	 
	 // Jenkins code

	
	 public Test testName1 ;
	 // Jenkins code end
	 @BeforeSuite
    public static void cleanUp() throws IOException{
    	File f = new File("C:/Users/f2736/Documents/HtMediaWorkspace/SSauce/screenShots");
		FileUtils.cleanDirectory(f);
    }

	
	@BeforeClass
    public void setUpJenkins() throws Exception {
dateFormat = new SimpleDateFormat("ddMMMMMyyyy-HHmmss");
		// get current date time with Date()
		date = new Date();
        // Construct DesiredCapabilities using the environment variables set by the Sauce plugin
        DesiredCapabilities capabilities = new DesiredCapabilities().android();
        String version = Utils.readPropertyOrEnv("SELENIUM_VERSION", "");
         if (!version.equals("")) {
            capabilities.setCapability("version", version);
        }
        capabilities.setCapability("platformVersion","4.4");
       capabilities.setCapability("appiumVersion", "1.4.7");
		capabilities.setCapability("deviceName","Android Emulator");
       // capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("app","sauce-storage:shine-job-search5.2.apk");
    //    capabilities.setCapability("name", "Shine Sauce Test "+dateFormat.format(date));
        capabilities.setCapability("maxDuration", "2000");
        capabilities.setCapability("command-timeout", "500");
        
       capabilities.setCapability("name", this.getClass().getSimpleName());
        capabilities.setCapability("platformName", Utils.readPropertyOrEnv("SELENIUM_PLATFORM", "ANDROID"));
       // capabilities.setCapability("browserName", Utils.readPropertyOrEnv("SELENIUM_BROWSER", "Android 5.0 (portrait)"));
        sauceUser = Utils.readPropertyOrEnv("SAUCE_USER_NAME", "");
        saucePass = Utils.readPropertyOrEnv("SAUCE_API_KEY", "");
System.out.println("Creating Appium session, this may take couple minutes..");
        driver = new AndroidDriver(
                new URL("http://" + sauceUser + ":" + saucePass + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
        
		System.out.println("Entered Cloud");
		sessionId.set(((AppiumDriver) driver).getSessionId().toString());
	 jobID = ((AppiumDriver) driver).getSessionId().toString();
      System.out.println(jobID);
     //NetworkConnectionSetting n= ((AndroidDriver) driver).getNetworkConnection();
     // n.value=2;
      //  ((AndroidDriver) driver).setNetworkConnection(n);
    // n.setWifi(true);
//NetworkConnectionSetting n = new NetworkConnectionSetting(4);
  //    ((AndroidDriver) driver).setNetworkConnection(n);
    }
	
	/**
     * Setup the environment before testing
	 * @throws InterruptedException 
     * @throws Exception
         */
	
  public static void downloadLog(String name) throws InterruptedException, UnsupportedCommandException{
	
	 // Thread.sleep(15000);
	  URL restEndpoint;
	  dateFormat = new SimpleDateFormat("ddMMMMMyyyy-HHmmss");
		// get current date time with Date()
		date = new Date();
	  String key = sauceUser + ":" + saucePass;
	 
      String auth_token = SecurityUtils.hmacEncode("HmacMD5", jobID, key);
      String authLink = "https://assets.saucelabs.com/jobs/" + jobID + "/log.json?auth=" + auth_token;
		//String authLink = sr.getPublicJobLink(sessionId);
		System.out.println(authLink);
	//	SauceREST sr = new SauceREST("troy2012" ,"a2226d54-263d-488a-9ba4-2dd8c436e503");
		 // String status=sr.retrieveResults("https://saucelabs.com/jobs/"+ jobID + "?auth=" + auth_token);

		  //The file that you want to download
		String fileName="C:/Users/f2736/Documents/HtMediaWorkspace/SSauce/screenShots/"+name+"-"+dateFormat.format(date)+".log";

		 try {
			// get URL content
			restEndpoint = new URL(authLink);
			//URLConnection con = restEndpoint.openConnection();
			int code =0;
			int count = 0;
			HttpURLConnection con ; 
	        
			do{ 
				con = (HttpURLConnection) restEndpoint.openConnection();
				con.setReadTimeout((int) TimeUnit.SECONDS.toMillis(10));
		        con.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(10));
			// open the stream and put it into BufferedReader
		        con.setDoOutput(true);
		       // con.setRequestMethod("HEAD"); 
		        con.setRequestMethod("GET");
		        code = con.getResponseCode();
		        System.out.println("" + code); 
		        
		        if(code==404){
		        Thread.sleep(3000);
		        con.disconnect();
		        }
		        count++;
		        }while(code==404 && count<8);
		        
	          
	            
	          //  addAuthenticationProperty(connection);
	            
	           // InputStream stream = con.getInputStream();
	            
	        //    BufferedInputStream in = new BufferedInputStream(stream);
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;

			//save to this filename
			
			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}

			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}

			bw.close();
			br.close();

			System.out.println("Done");

		 } catch (FileNotFoundException e){
				e.printStackTrace();
		 } catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
  
	public static void existingUserLogin(int no){
		if(no==0){
			driver.findElementById("com.net.shine:id/email").sendKeys("f2736@htmedia.in");
		//	driver.findElementById("com.net.shine:id/email").sendKeys("fftestshine158551@ymail.com");
//	driver.hideKeyboard();
	driver.findElement(By.id("com.net.shine:id/password")).click();
//	driver.findElementById("com.net.shine:id/password").sendKeys("Shine@12345");
			driver.findElementById("com.net.shine:id/password").sendKeys("password@123");
			//driver.findElementById("com.net.shine:id/login_btn").click();
		} else {
		//driver.findElementById("com.net.shine:id/email").sendKeys("Ankurgupta18@gmail.com");
		//driver.findElementById("com.net.shine:id/email").sendKeys("fftestshine151977@mailinator.com");
driver.findElementById("com.net.shine:id/email").sendKeys(fullName);
//driver.hideKeyboard();
driver.findElement(By.id("com.net.shine:id/password")).click();
//driver.findElementById("com.net.shine:id/password").sendKeys("ankur1");
		driver.findElementById("com.net.shine:id/password").sendKeys("Shine@12345");
		
		}
		driver.findElementById("com.net.shine:id/login_btn").click();
//		if(isElementPresent(By.id("com.net.shine:id/mobile_upload"))==true){
//			driver.scrollTo("I'll do it later");
//			driver.findElementById("com.net.shine:id/skip").click();
//		}
	}
	
	
	public static String textFromDropDown(By b1,By b2){
		WebDriverWait w1 = new WebDriverWait(driver,10);
		
		driver.findElement(b1).click();
		clickFromList(b2, 0, "random");
		w1.until(ExpectedConditions.presenceOfElementLocated(b1));
		return driver.findElement(b1).getText();
	}
	
	public static void selectRadioButton(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		WebDriverWait w1 = new WebDriverWait(driver,10);
		w1.until(ExpectedConditions.presenceOfElementLocated(By.id("com.net.shine:id/dialog_item_label")));
List<WebElement> l0 = driver.findElementsById("com.net.shine:id/dialog_item_label");
		
		List<WebElement> l3 =l0.get(0).findElements(By.className("android.widget.LinearLayout"));
		l3.remove(0);
		l3.remove(2);
		Random r1 = new Random();
		int index = r1.nextInt(l3.size());
		System.out.println(l3.get(index).findElement(By.id("com.net.shine:id/radioGroup_selection")).findElement(By.id("com.net.shine:id/selected")).getText());
		l3.get(index).findElement(By.id("com.net.shine:id/radioGroup_selection")).findElement(By.id("com.net.shine:id/selected")).click();
	}
	public static void selectRadioButtonFunc() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebDriverWait w1 = new WebDriverWait(driver, 10);
		w1.until(ExpectedConditions.presenceOfElementLocated(By
				.id("com.net.shine:id/my_list")));
		List<WebElement> l0 = driver
				.findElementsById("com.net.shine:id/my_list");

		List<WebElement> l3 = l0.get(0).findElements(
				By.className("android.widget.LinearLayout"));
		l3.remove(0);
		l3.remove(2);
		Random r1 = new Random();
		int index = r1.nextInt(l3.size());
		System.out.println(l3.get(index)
				.findElement(By.id("com.net.shine:id/radioGroup_selection"))
				.findElement(By.id("com.net.shine:id/selected")).getText());
		l3.get(index)
				.findElement(By.id("com.net.shine:id/radioGroup_selection"))
				.findElement(By.id("com.net.shine:id/selected")).click();
	}


	public static void clearAndEnter(By by, String text) throws AWTException {

		String name = driver.findElement(by).getText();
		WebElement e1 = driver.findElement(by);
		System.out.println(name.length());
		int count = 0;
	int  t = name.length();
	e1.click();
	while(count<t){
	((AndroidDriver) driver).sendKeyEvent(AndroidKeyCode.BACKSPACE);
	count++;
	}
	driver.findElement(by).sendKeys(text);
	}
	public static Integer clickFromList(By by, int index, String r){
		List<WebElement> l1 = driver.findElements(by);
		
		if(r.contains("0")){
			
		l1.get(index).click();
		
		} else if(r.contains("random")) {
			Random r1 = new Random();
			index = r1.nextInt(l1.size());
			l1.get(index).click();
		}
		return index;
		
	}
	
	public static void takeScreenshot(String picture) throws IOException, UnsupportedCommandException {
		try{
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		File f = new File("C:/Users/f2736/Documents/HtMediaWorkspace/SSauce/screenShots/"
				+ picture);
		if (f.isFile() && f.exists()) 
        { f.delete();
System.out.println("successfully deleted");
FileUtils.copyFile(scrFile, f);
        }else{
		FileUtils.copyFile(scrFile, f);
        }
		}catch(UnsupportedCommandException e){
			
			System.out.println(picture +"screenshot could not be taken");
		}
	}
	public static void swipeLeft(){
		// left
		
		driver.context("NATIVE_APP"); 
		Dimension size = driver.manage().window().getSize(); 
		int startx = (int) (size.width * 0.8); 
		int endx = (int) (size.width * 0.20); 
		int starty = size.height / 2; 
		driver.swipe(startx, starty, endx, starty, 1000);
	}
	
	public static void swipeRight(){
		driver.context("NATIVE_APP"); 
		Dimension size = driver.manage().window().getSize(); 
		int endx = (int) (size.width * 0.8); 
		int startx = (int) (size.width * 0.20); 
		int starty = size.height / 2; 
		driver.swipe(startx, starty, endx, starty, 1000);
	}
	public static void scrollDown(){
		
		WebElement element = driver.findElement(By.name("Skills"));
		 TouchAction touchAction = new TouchAction(driver);
		driver.performTouchAction(touchAction.moveTo(element));
		
	    
	}
	protected static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
protected static boolean isTextPresent(String text){
	try{
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		Assert.assertTrue(list.size() > 0);
		return true;
	} catch (NoSuchElementException e) {
		return false;
	}
}
	protected static boolean isElementVisible(By by) {
		try {
			driver.findElement(by).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Override
	public String getSessionId() {
		// TODO Auto-generated method stub
		return null;
	}
}
