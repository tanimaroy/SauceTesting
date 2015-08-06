package com.shineSauceLabs.config;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.shineSauceLabs.config.CommonMethods;

public class CommonMethods extends BaseClass {

	public static void startShineLogin(String text) {

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		if (text.contains("register")) {
			driver.findElementById(Elements.REGISTER_BTN_ID).click();
		} else {
			driver.findElementById(Elements.LOGIN_BTN_ID).click();
		}

	}

	public static void enterRegistrationDetails(String type)
			throws InterruptedException {

		driver.findElementById(Elements.REG_NAME_ID).sendKeys("Ravi Jain");
		if (type.contains("fresher")) {
			driver.findElementById(Elements.REG_EMAIL_ID).sendKeys(
					Elements.createUser("fresher"));
		} else {
			driver.findElementById(Elements.REG_EMAIL_ID).sendKeys(
					Elements.createUser(""));
		}
		driver.findElementById(Elements.REG_PASSWORD_ID)
				.sendKeys("Shine@12345");
		driver.findElementByName("Show").click();
		driver.findElementById(Elements.REG_MOBILE_ID).sendKeys(
				"9988" + userFull);
		// ViewActions.closeSoftKeyboard();
		// while(!driver.findElementById("android:id/title").getText().contains("Select City")){
		driver.findElementById(Elements.REG_CITY_ID).click();
		Thread.sleep(3000);
		driver.findElement(By.name("Gurgaon")).click();
		// selectRadioButton();
		driver.findElementById(Elements.REG_FUNC_AREA_ID).click();

		// selectRadioButton();
		driver.findElementByName("Audit").click();
		driver.findElementById(Elements.REG_INDUSTRY_ID).click();
		WebDriverWait w = new WebDriverWait(driver, 10);
		List<WebElement> industry = driver
				.findElementsByClassName("android.widget.CheckedTextView");
		industry.get(2).click();
		if (type.contains("fresher")) {
			driver.findElementById(Elements.REG_EXP_ID).click();

			List<WebElement> total_exp = driver
					.findElementsByClassName("android.widget.CheckedTextView");
			total_exp.get(0).click();

			w.until(ExpectedConditions.presenceOfElementLocated(By
					.className("android.widget.LinearLayout")));
			// driver.findElementByClassName("android.widget.LinearLayout").isDisplayed();

			driver.scrollTo("Register");
			w.until(ExpectedConditions.presenceOfElementLocated(By
					.id(Elements.REG_SALARY_ID)));
			driver.findElementById(Elements.REG_SALARY_ID).click();

			List<WebElement> current_salary = driver
					.findElementsByClassName("android.widget.CheckedTextView");
			current_salary.get(0).click();
		} else {
			driver.findElementById(Elements.REG_EXP_ID).click();

			List<WebElement> total_exp = driver
					.findElementsByClassName("android.widget.CheckedTextView");
			total_exp.get(2).click();
			w.until(ExpectedConditions.presenceOfElementLocated(By
					.className("android.widget.LinearLayout")));
			driver.scrollTo("Register");
			// driver.findElementByClassName("android.widget.LinearLayout").isDisplayed();
			w.until(ExpectedConditions.presenceOfElementLocated(By
					.id(Elements.REG_SALARY_ID)));
			driver.findElementById(Elements.REG_SALARY_ID).click();

			List<WebElement> current_salary = driver
					.findElementsByClassName("android.widget.CheckedTextView");
			current_salary.get(3).click();
		}

		driver.findElementById(Elements.REG_SUBMIT_BTN_ID).click();

	}

	public static void uploadResume(String ans, String resume) {
		int count = 0;

		if (ans.contains("no")) {
			// dont have resume
			if (count > 0) {
				driver.findElementById(Elements.POPUP_OK_BTN).click();
			}
			driver.scrollTo("I'll do it later");
			driver.findElementById(Elements.SKIP_BTN_ID).click();
			//
		} else if (ans.contains("yes")) {
			do {
				if (count > 0) {
					driver.findElementById(Elements.POPUP_OK_BTN).click();
				}
				WebDriverWait w = new WebDriverWait(driver, 10);
				w.until(ExpectedConditions.visibilityOfElementLocated(By
						.id(Elements.MOBILE_UPLOAD_ID)));
				driver.findElementById(Elements.MOBILE_UPLOAD_ID).click();
				// driver.scrollTo(resume);
				w.until(ExpectedConditions.visibilityOfElementLocated(By
						.name("Download")));
				// driver.findElementByName("Download").click();
				Elements.clickResumeRegister();
				// driver.findElementByName(resume).click();
				WebDriverWait w1 = new WebDriverWait(driver, 20);

				w1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
						.id(Elements.POPUP_ID)));
				count++;

			} while (!driver.findElementById(Elements.POPUP_ID).getText()
					.contains("Resume Uploaded Successfully") && count<6);

			Assert.assertEquals(driver.findElementById(Elements.POPUP_ID)
					.getText(), "Resume Uploaded Successfully");
			driver.findElementById(Elements.POPUP_OK_BTN).click();
		}

	}

	public static void checkBlankField(By by, String label, String text) {
	//	WebElement e = driver.findElement(by);
		if (driver.findElement(by).getText().contains(label)) {
			driver.findElement(by).sendKeys(text);
		}
	}

	public static void editResumeDetails(String type) {
WebDriverWait w= new WebDriverWait(driver,10);
		if (type.contains("Regular")) {
			driver.findElementById(Elements.EDITREG_FUNC_AREA_ID).click();
			selectRadioButtonFunc();
			w.until(ExpectedConditions.presenceOfElementLocated(By.id(Elements.EDITREG_FUNC_AREA_ID)));
			System.out.println(driver.findElement(
					By.id(Elements.EDITREG_JOB_TITLE_ID)).getText());
			checkBlankField(By.id(Elements.EDITREG_JOB_TITLE_ID),
					"Job Title", "old job title 101");
			checkBlankField(By.id(Elements.EDITREG_COMPANY_NAME_ID),
					"Company name", "old job company 101");
			// if(!driver.findElementById("com.net.shine:id/start_year").isDisplayed()){
			// driver.hideKeyboard();
			// }
			
			// driver.findElementByName("Front Office / Receptionist").click();
//
			String start_year = textFromDropDown(
					By.id(Elements.EDITREG_START_Y_ID),
					By.className("android.widget.CheckedTextView"));
			String start_month = textFromDropDown(
					By.id(Elements.EDITREG_START_M_ID),
					By.className("android.widget.CheckedTextView"));
			if (start_year.contains("2015")) {
				driver.findElementById("com.net.shine:id/start_year").click();
				driver.findElementByName("2008").click();
			}

			// driver.findElementById("com.net.shine:id/alert_check").click();
			driver.findElementById(Elements.EDITREG_INDUSTRY_ID)
					.click();
			List<WebElement> industry_field = driver
					.findElementsByClassName("android.widget.CheckedTextView");
			industry_field.get(3).click();
			// driver.findElementById("android:id/title").click();
			// driver.findElementByName("Cabin Crew").click();

			// driver.findElementById("com.net.shine:id/qual_field").click();
		}

		String qual_field = textFromDropDown(
				By.id(Elements.EDITREG_QUALIFICATION_ID),
				By.className("android.widget.CheckedTextView"));
		driver.scrollTo("Skills");
		driver.findElementById(Elements.EDITREG_SPECIALIZATION_ID).click();
		selectRadioButtonFunc();
		// driver.findElementByName("Anthropology").click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id(Elements.EDITREG_COURSE_TYPE_ID)));
		String edu_stream_field = driver.findElementById(
				Elements.EDITREG_SPECIALIZATION_ID).getText();
		String course_type_field = textFromDropDown(
				By.id(Elements.EDITREG_COURSE_TYPE_ID),
				By.className("android.widget.CheckedTextView"));
		checkBlankField(By.id(Elements.EDITREG_INSTITUTE_NAME_ID),
				"Select institute name", "college new name 101");

		// driver.hideKeyboard();

		String passout_yr_field = textFromDropDown(
				By.id(Elements.EDITREG_PASSOUT_Y_ID),
				By.className("android.widget.CheckedTextView"));
		driver.scrollTo("Save");
		// selectRadioButton();
		checkBlankField(By.id(Elements.EDITREG_SKILL_N_ID), "Skill Name",
				"Java 101");

		String skill_level_field = textFromDropDown(
				By.id(Elements.EDITREG_SKILL_Y_ID),
				By.className("android.widget.CheckedTextView"));
		String totalSkill = "new skill 001," + skill_level_field + " Yrs";

		driver.findElementById(Elements.REG_SUBMIT_BTN_ID).click();

		// Assert.assertTrue(isElementVisible(By.id("com.net.shine:id/search_button")));

	}
//////////////////
	public static void selectMenuItems(String menu, String more) {
		driver.findElement(By.className(Elements.SIDE_MENU_CLASS)).click();
		

		WebDriverWait w1 = new WebDriverWait(driver, 20);
		

		// com.net.shine:id/matched_job

		if (more.contains("Login") || more.contains("Register")) {
			// driver.scrollTo("More");
			// driver.findElementById("com.net.shine:id/more").click();
			 w1.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.net.shine:id/logged_out_top_bar")));
			driver.findElementById("com.net.shine:id/" + menu).click();
			String[] menu1 = menu.split("_");
			
		} else {
			// driver.scrollTo(driver.findElementById("com.net.shine:id/"+menu.replace("_layout",
			// "")+"_tv").getText());
			 w1.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className("android.widget.ScrollView"))));
			driver.scrollTo(more);
			System.out.println("com.net.shine:id/" + menu);
			driver.findElementById("com.net.shine:id/" + menu).click();
		}

	}

	public static void createAlert() {
		WebDriverWait w=new WebDriverWait(driver,10);
		driver.findElementById(Elements.ALERT_EMAIL_ID).sendKeys(
				fullName);
		driver.findElementById(Elements.ALERT_NAME_ID).sendKeys(
				"New create alert 001");
		// no login
		

		// driver.hideKeyboard();
		driver.findElementById(Elements.ALERT_LOCATION_ID).click();
		clickFromList(By.className("android.widget.CheckedTextView"), 0,
				"random");
		driver.findElementById(Elements.DROPDOWN_OK_BTN_ID).click();
		String location = driver.findElementById(Elements.ALERT_LOCATION_ID)
				.getText();

		// location1 = location;
		// driver.findElementById("android:id/button1").click();

		String min_exp_field = textFromDropDown(
				By.id(Elements.ALERT_MIN_EXP_ID),
				By.className("android.widget.CheckedTextView"));
		String min_sal_field = textFromDropDown(
				By.id(Elements.ALERT_MIN_SAL_ID),
				By.className("android.widget.CheckedTextView"));
		driver.scrollTo("Industry");
		driver.findElementById(Elements.ALERT_INDUSTRY_ID).click();
		clickFromList(By.className("android.widget.CheckedTextView"), 0,
				"random");
		clickFromList(By.className("android.widget.CheckedTextView"), 0,
				"random");
		driver.findElementById(Elements.DROPDOWN_OK_BTN_ID).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id(Elements.ALERT_INDUSTRY_ID)));
		String industry_type_field = driver.findElementById(
				Elements.ALERT_INDUSTRY_ID).getText();
		String[] keywords = industry_type_field.split("/");
		driver.scrollTo("SAVE");
		driver.findElementById(Elements.ALERT_KEYWORDS_ID).sendKeys(
				keywords[0]);
		
		driver.findElementById(Elements.ALERT_SAVE_BTN_ID).click();
	}

	public static void enterSearchCriteria() {

		driver.findElementById("com.net.shine:id/min_exp_field").click();
		// Select s1 = new
		// Select(driver.findElementById("android:id/select_dialog_listview"));
		// System.out.println(s1.getOptions().get(3).getText());
		List<WebElement> exp = driver
				.findElementsByClassName("android.widget.CheckedTextView");
		exp.get(3).click();
		driver.findElementById("com.net.shine:id/min_sal_field").click();
		driver.findElementById("android:id/select_dialog_listview");
		exp.get(3).click();

		Random r1 = new Random();
		int optionIndex = r1.nextInt(exp.size());
		driver.findElementById("com.net.shine:id/industry_type_field").click();
		driver.findElementById("android:id/select_dialog_listview");
		exp.get(optionIndex).click();
		String keywords = driver.findElementById(
				"com.net.shine:id/industry_type_field").getText();
		driver.findElementById("com.net.shine:id/keyword").sendKeys(keywords);
		// driver.hideKeyboard();
		keyword = keywords;
		driver.findElementById("com.net.shine:id/search_btn").click();
	}

	public static String clickJobOption(String r, int index) {
		//driver.context("NATIVE_APP");
	//	driver.swipe(475, 200, 475, 500, 400); // swipe down
		List<WebElement> l1 = driver
				.findElementsById("com.net.shine:id/grid_layout").get(0).findElements(By.className("android.widget.LinearLayout"));
		List<WebElement> t1 = driver.findElementsById("com.net.shine:id/title");
		List<WebElement> a1 = driver
				.findElementsById("com.net.shine:id/apply_job");
		Random r1 = new Random();
		if (r.contains("out")) {
			index = r1.nextInt(l1.size()-1);
			r = t1.get(index).getText();

			a1.get(index).click();
			if(driver.findElement(By.id("com.net.shine:id/m_title")).getText().contains("Confirmation")){
				driver.findElement(By.id(Elements.SKIP_BTN_ID)).click();
			}
			Assert.assertEquals(
					isElementPresent(By.id("com.net.shine:id/applied_btn")),
					true);
		} else {
			if (r.contains("0")) {
				// r = t1.get(index).getText();
				l1.get(index).click();

			} else if (r.contains("random")) {

				index = r1.nextInt(l1.size()-1);
				r = t1.get(index).getText();
				l1.get(index).click();
				if(driver.findElement(By.id("com.net.shine:id/m_title")).getText().equalsIgnoreCase("Confirmation")){
					driver.findElement(By.id(Elements.SKIP_BTN_ID)).click();
				}
			}
		}

		return r;
	}

	public static void searchFilter() throws InterruptedException {
		driver.findElementById("com.net.shine:id/freshness_facets").click();
		// driver.findElementById("com.net.shine:id/relevence_facets").click();
		String id[] = new String[3];
		id[0] = "locations_layout";
		id[1] = "experience_layout";
		id[2] = "salary_layout";
		// id[3]="industry_layout";
		// id[4]="fun_area_layout";

		String c[] = new String[3];
		c[0] = "location_count";
		c[1] = "ex_count";
		c[2] = "sal_count";
		// c[3]="ind_count";
		// c[4]="farea_count";
		String text[] = new String[3];
		int count = 0;
		int no = 0;
		while (count < 3) {
			Thread.sleep(2000);
			driver.findElementById("com.net.shine:id/" + id[count]).click();
			Thread.sleep(2000);
			clickFromList(By.id("com.net.shine:id/list_view"), 0, "random");

			// System.out.println(n);
			// text[count]=
			// driver.findElementsByClassName("android.widget.LinearLayout").get(n).findElements(By.className("android.widget.LinearLayout")).get(1).findElements(By.className("android.widget.TextView")).get(0).getText();
			// text[count]=
			// driver.findElementsById("com.net.shine:id/title_tv").get(n).getText();
			// System.out.println(text[count]);
			driver.findElementById("com.net.shine:id/done_text1").click();
			Thread.sleep(5000);
			// no=
			// Integer.parseInt(driver.findElementById("com.net.shine:id/"+c[count]).getText().replace("(",
			// "").replace(")", "").replace(" ", ""));
			try {
				// Assert.assertEquals(no, 1);
			} catch (AssertionError e) {

			}
			count++;
		}
		driver.findElementById("com.net.shine:id/industry_layout").click();
		clickFromList(By.id("com.net.shine:id/list_view"), 0, "0");
		driver.findElementById("com.net.shine:id/done_text1").click();

		driver.findElementById("com.net.shine:id/refine_text1").click();
		// driver.findElementById("com.net.shine:id/reset_facets_all").click();

	}

	public static void clickApply(String text) {
		WebDriverWait w1 = new WebDriverWait(driver, 10);
		
		if (text.contains("out")) {
			w1.until(ExpectedConditions.presenceOfElementLocated(By
					.id("com.net.shine:id/apply_job")));
			driver.findElementById("com.net.shine:id/apply_job").click();
		} else {
			w1.until(ExpectedConditions.presenceOfElementLocated(By
					.id("com.net.shine:id/apply_btn")));
			driver.findElementById("com.net.shine:id/apply_btn").click();
			// Assert.assertEquals(isElementPresent(By.id("com.net.shine:id/apply_text")),
			// true);
		}
		if(driver.findElement(By.id("com.net.shine:id/m_title")).getText().equalsIgnoreCase("Confirmation")){
			driver.findElement(By.id(Elements.SKIP_BTN_ID)).click();
		}
	}

	public static void clickDialog(String text) {
		WebDriverWait w1 = new WebDriverWait(driver, 10);
		w1.until(ExpectedConditions.presenceOfElementLocated(By
				.id("com.net.shine:id/dialog_msg")));
		Assert.assertEquals(
				driver.findElementById("com.net.shine:id/dialog_msg").getText(),
				text);
		driver.findElementById("com.net.shine:id/ok_btn").click();
	}

	public static void verifyMultipleAlerts(String text) {
		CommonMethods.selectMenuItems("custom_job_alert", "My Job Alerts");
		List<WebElement> l = driver.findElements(By
				.id("com.net.shine:id/list_view"));
		List<WebElement> l1 = l.get(0).findElements(
				By.className("android.widget.LinearLayout"));

		if (l1.size() > 0) {
			String text1 = l1
					.get(l.size() - 1)
					.findElements(By.className("android.widget.LinearLayout"))
					.get(0)
					.findElements(By.className("android.widget.RelativeLayout"))
					.get(0).findElement(By.id("com.net.shine:id/alert_name"))
					.getText();
			Assert.assertEquals(text1, text);
			List<WebElement> l2 = l1.get(l.size() - 1).findElements(
					By.className("android.widget.LinearLayout"));
			driver.findElementById("com.net.shine:id/menu_recent").click();
			driver.findElementByName("Delete").click();
		} else {
			Assert.assertEquals(
					driver.findElementById("com.net.shine:id/alert_name")
							.getText(), "new alert for " + text);
			driver.findElementById("com.net.shine:id/menu_recent").click();
			driver.findElementByName("Delete").click();
		}
	}

	public static void getResume() {
		WebDriverWait w = new WebDriverWait(driver, 10);
		CommonMethods.startShineLogin("Login");
		
		existingUserLogin(0);
		
		// driver.findElementById("com.net.shine:id/search_button").click();
		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElementById("com.net.shine:id/edit_profile").click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("com.net.shine:id/basic_info_layout")));
		driver.scrollTo("Resume");
//		MobileElement element = (MobileElement)driver.findElement(By.id("com.net.shine:id/menu_resume"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		HashMap<String, String> scrollObject = new HashMap<String, String>();
//		scrollObject.put("direction", "down");
//		scrollObject.put("element", ((RemoteWebElement) element).getId());
//		scrollObject.put("text", "Resume"); 
//		js.executeScript("mobile: scroll", scrollObject);
	//	List<WebElement> l1 = driver.findElementsById("com.net.shine:id/menu_resume"); // old
		//l1.get(l1.size()-1);	
		driver.findElementById("com.net.shine:id/menu_resume").click();// resume
		w.until(ExpectedConditions.visibilityOfElementLocated(By
				.name("Download")));
		driver.findElementByName("Download").click();
		CommonMethods.selectMenuItems("logout_view", "Log Out");
	}
	
	public static void verifyAlerts(List<String>al,String para){
		int count;
		List<WebElement> l = driver.findElements(By.id("com.net.shine:id/list_view")).get(0).findElements(By.className("android.widget.LinearLayout"));
		String alertName =" ";
		
	for(count=0;count<l.size();count++){	
		alertName=l.get(count).findElements(By.className("android.widget.LinearLayout")).get(0).findElements(By.className("android.widget.RelativeLayout")).get(0).findElement(By.id("com.net.shine:id/alert_name")).getText();
	if(alertName.contains(al.get(0))){
		break;
	
	}
	}
	List<WebElement> l2 = l.get(count).findElements(By.className("android.widget.LinearLayout")).get(0).findElements(By.className(Elements.TEXT_VIEW_CLASS));
	System.out.println(l2.size());
	if(!para.contains("min")){
		String ind=l2.get(l2.size()-1).getText().replace(" ", "").trim();
		Assert.assertEquals(ind,"Industry:"+al.get(3));
	}
	
	Assert.assertEquals(l2.get(1).getText().replaceAll("\\s+",""),"Keyword:"+al.get(1));
	Assert.assertEquals(l2.get(3).getText().replaceAll("\\s+",""),"Location:"+al.get(2));
	
		}

}
