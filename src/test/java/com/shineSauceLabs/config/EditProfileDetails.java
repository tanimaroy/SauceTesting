package com.shineSauceLabs.config;


import java.awt.AWTException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.shineSauceLabs.config.CommonMethods;

public class EditProfileDetails extends BaseClass{
	
	public static List<String> editExpDetails() throws AWTException{
		driver.findElement(By.id("com.net.shine:id/resume_title_field")).sendKeys("New Company Exp");
		// driver.hideKeyboard();
		driver.findElementById("com.net.shine:id/annual_salary_field").click();
		clickFromList(By.className("android.widget.CheckedTextView"), 0, "random");
		String annual_salary_Y= driver.findElementById("com.net.shine:id/annual_salary_field").getText();
//		driver.findElementsById("com.net.shine:id/annual_salary_field").get(1).click();
//		clickFromList(By.className("android.widget.CheckedTextView"), 0, "random");
//		String annual_salary_M= driver.findElementsById("com.net.shine:id/annual_salary_field").get(1).getText();
		
		String totalsalary = "Rs."+annual_salary_Y+" lakh 0 Thousands";

		String exp_Y= textFromDropDown(By.id("com.net.shine:id/duration_field"),By.className("android.widget.CheckedTextView"));
		
	String exp_M= textFromDropDown(By.id("com.net.shine:id/exp_month_field"),By.className("android.widget.CheckedTextView"));
		
		String totalexp = exp_Y+" - "+exp_M;
		
		String teamSize= textFromDropDown(By.id("com.net.shine:id/team_size_field"),By.className("android.widget.CheckedTextView"));
		WebDriverWait w1 = new WebDriverWait(driver,10);
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.net.shine:id/notice_period_field")));
		
		String notice= textFromDropDown(By.id("com.net.shine:id/notice_period_field"),By.className("android.widget.CheckedTextView"));
		
		List<String> expData = new LinkedList<String>();
		expData.add("New Company Exp");
		expData.add(totalsalary);
		expData.add(totalexp);
		expData.add(teamSize);
		expData.add(notice);
	
	return expData;
	}
	
	public static void enterDob(){
		driver.findElement(By.id("com.net.shine:id/dob")).click();
		
		List<WebElement>l =driver.findElements(By.className("android.widget.NumberPicker"));
		List<WebElement>l1= driver.findElements(By.className("android.widget.Button"));
		//driver.findElements(By.className("android.widget.NumberPicker")).get(2).findElements(By.className("android.widget.Button")).get(2).click();
	//int dd= 10;
	//int mm=10;
	//int yy=10;
	int count = 0;
	
	Random r1 = new Random();
	int dd = r1.nextInt(5);
	int mm = r1.nextInt(5);
	int yy = r1.nextInt(5);
	while(count<mm){
		l.get(0).findElements(By.className("android.widget.Button")).get(0).click();
	count++;
	}
	count=0;
	while(count<dd){
		l.get(1).findElements(By.className("android.widget.Button")).get(0).click();
		count++;
	}
	count=0;
	while(count<yy){
		l.get(2).findElements(By.className("android.widget.Button")).get(0).click();
	count++;
	}
	
	driver.findElement(By.id("android:id/button1")).click();
	}
	
	public static List<String> editJob() throws AWTException{
	/*	List <WebElement> l1 = driver.findElementsById("com.net.shine:id/experience_detail_view");
		System.out.println("elements in addjob2="+l1.size());
		List <WebElement> l2 = driver.findElements(By.className("android.widget.RelativeLayout"));
		System.out.println("elements in addjob2="+l2.size());
		l2.get(7).findElements(By.className("android.widget.LinearLayout")).get(1).findElements(By.className("android.widget.ImageView")).get(0).click();
		//List <WebElement> l1 = driver.findElementsByClassName("android.widget.RelativeLayout");
		//l1.get(7).findElements(By.className("android.widget.LinearLayout")).get(0).findElements(By.className("android.widget.ImageView")).get(0).click();
		//clickFromList(By.className("android.widget.ImageView"),3,"0");
		List <WebElement> l3 = driver.findElements(By.className("android.widget.ImageView"));
		System.out.println(l3.size());
		
		l3.get(0).click(); */
		clickaddORedit("edit",By.id("com.net.shine:id/job_detail_view"));
		clearAndEnter(By.id("com.net.shine:id/job_title_field"),"new company 003");
		clearAndEnter(By.id("com.net.shine:id/comp_name_field"),"new company name 003");
		// driver.hideKeyboard();
		String industry_name_field= textFromDropDown(By.id("com.net.shine:id/industry_name_field"),By.className("android.widget.CheckedTextView"));
		
		 driver.findElement(By.id("com.net.shine:id/func_area_field")).click();
		 selectRadioButton();
		 String func_area_field= driver.findElement(By.id("com.net.shine:id/func_area_field")).getText();
		 String start_year= textFromDropDown(By.id("com.net.shine:id/start_year"),By.className("android.widget.CheckedTextView"));
		String start_month= textFromDropDown(By.id("com.net.shine:id/start_month"),By.className("android.widget.CheckedTextView"));
		String totalexp = start_year+" Yrs - "+start_month+" Months";
		List<String> eJob = new LinkedList<String>();
		//eJob.add("new company 003");
		eJob.add("new company name 003");
		eJob.add(industry_name_field);
		eJob.add(func_area_field);
		eJob.add(totalexp);
		return eJob;
	}
	/*
	 * 
		List <WebElement> l1 = driver.findElementsById("com.net.shine:id/experience_detail_view");
		System.out.println("elements in addjob1="+l1.size());
		List <WebElement> l2 = l1.get(0).findElements(By.className("android.widget.RelativeLayout"));
		System.out.println("elements in addjob2="+l2.size());
		List <WebElement> l3 = l2.get(6).findElements(By.className("android.widget.ImageView"));
		System.out.println("elements in addjob3="+l3.size());
	//	List <WebElement> add =driver.findElements(By.id("com.net.shine:id/add_btn"));
		//System.out.println("add button no:"+add.size());
	//	add.get(0).click();
		//driver.findElementById("com.net.shine:id/add_btn").click();//6
	//	l1.get(0).findElements(By.className("android.widget.RelativeLayout")).get(1).findElements(By.className("android.widget.ImageView")).get(1).click();
		//clickFromList(By.id("com.net.shine:id/add_btn"),1,"0");
		l3.get(0).click();
		System.out.println(l3.get(0).getText());
	 */ //com.net.shine:id/job_detail_view
	// com.net.shine:id/education_profile_comp
	// com.net.shine:id/skill_profile_comp
	public static void clickaddORedit(String action,By by){
		List <WebElement> l1 = driver.findElements(by);
		List <WebElement> l2 = l1.get(0).findElements(By.className("android.widget.RelativeLayout"));
		System.out.println(l1.size());
		// add
		if(action.contains("add")){
		l2.get(0).findElements(By.className("android.widget.TextView")).get(1).click();
		} else if (action.contains("edit")){
			l2.get(l2.size()-1).findElements(By.className("android.widget.LinearLayout")).get(1).findElements(By.className("android.widget.ImageView")).get(1).click();
		} else if(action.contains("x")){
			l2.get(l2.size()-1).findElements(By.className("android.widget.LinearLayout")).get(1).findElements(By.className("android.widget.ImageView")).get(0).click();
		}
	}
	public static List<String> addJob(){
		clickaddORedit("add",By.id("com.net.shine:id/job_detail_view"));
		driver.context("NATIVE_APP");
		driver.tap(682,144,748,210);
		driver.findElement(By.id("com.net.shine:id/job_title_field")).sendKeys("new company 002");
		driver.findElement(By.id("com.net.shine:id/comp_name_field")).sendKeys("new company name 002");
			
			String industry_name_field= textFromDropDown(By.id("com.net.shine:id/industry_name_field"),By.className("android.widget.CheckedTextView"));
			
			 driver.findElement(By.id("com.net.shine:id/func_area_field")).click();
			 selectRadioButton();
			 String func_area_field= driver.findElement(By.id("com.net.shine:id/func_area_field")).getText();
			String start_year= textFromDropDown(By.id("com.net.shine:id/start_year"),By.className("android.widget.CheckedTextView"));
		
			if(start_year.contains("2015")){
				driver.findElementById("com.net.shine:id/start_year").click();
				driver.findElementByName("2008").click();   
				start_year="2008";
			}
			int endYear = Integer.parseInt(start_year) + 2;
			String start_month= textFromDropDown(By.id("com.net.shine:id/start_month"),By.className("android.widget.CheckedTextView"));
			driver.findElement(By.id("com.net.shine:id/end_year")).click();
			driver.findElement(By.name(Integer.toString(endYear))).click();
			
			driver.findElement(By.id("com.net.shine:id/end_month")).click();
			driver.findElement(By.name("Jan")).click();
			String totalexp = start_year+" Yrs - "+start_month+" Months";
			List<String> aJob = new LinkedList<String>();
			//aJob.add("new company 002");
			aJob.add("new company name 002");
			aJob.add(industry_name_field);
			aJob.add(func_area_field);
			aJob.add(totalexp);
			return aJob;
	}
	
	public void deleteJob(){
		driver.scrollTo("Employment");
		clickaddORedit("x",By.id("com.net.shine:id/job_detail_view"));
		List<WebElement> l = driver.findElements(By.className("android.widget.RelativeLayout"));
		System.out.println("delete job:"+l);
	
		List<WebElement> l1 = driver.findElementsById("com.net.shine:id/label");
		int count = 0;
		while(count<l1.size()){
			if(l1.get(count).getText().contains("new company name 002")){
				driver.findElementsByClassName("android.widget.ImageView").get(count).click();
				Assert.assertEquals(driver.findElementById("com.net.shine:id/dialog_msg").getText(), "Are you sure you want to delete this job ?");
				driver.findElementById("com.net.shine:id/yes_btn").click();
				Assert.assertEquals(driver.findElementById("com.net.shine:id/dialog_msg").getText(), "Job details have been updated successfully");
				driver.findElementById("com.net.shine:id/ok_btn").click();
				driver.scrollTo("Job Details");
				Assert.assertNotEquals(l1.get(count).getText(),"new company name 002");	
				break;
					} else {
						count++;
					}
		}
	}
	public static List<String> addEducation(){
		driver.scrollTo("Education Details");
		//clickFromList(By.id("com.net.shine:id/add_btn"),1,"0");//4
	//	driver.findElements(By.id("com.net.shine:id/education_profile_comp")).get(0).findElements(By.className("android.widget.RelativeLayout")).get(0).findElements(By.className("android.widget.ImageView")).get(1).click();
		List <WebElement> l2 = driver.findElements(By.className("android.widget.RelativeLayout"));
		System.out.println("elements in addjob2="+l2.size());
//		List <WebElement> l3 = l2.get(1).findElements(By.className("android.widget.ImageView"));
//		System.out.println("elements in addjob3="+l3.size());
		List <WebElement> add =driver.findElements(By.id("com.net.shine:id/add_btn"));
		System.out.println("add button no:"+add.size());
		add.get(1).click();	
		//driver.findElementsById("com.net.shine:id/add_btn").get(1).click();
		driver.findElement(By.id("com.net.shine:id/ins_name_field")).sendKeys("new education 002");
			//driver.findElementById("com.net.shine:id/comp_name_field").sendKeys("new education name 002");
			
			String qual_field= textFromDropDown(By.id("com.net.shine:id/qual_field"),By.className("android.widget.CheckedTextView"));
			driver.findElementById("com.net.shine:id/edu_stream_field").click();
			selectRadioButton();
			String edu_stream_field= driver.findElementById("com.net.shine:id/edu_stream_field").getText();
			String course_type_field= textFromDropDown(By.id("com.net.shine:id/course_type_field"),By.className("android.widget.CheckedTextView"));
			String passout_yr_field= textFromDropDown(By.id("com.net.shine:id/passout_yr_field"),By.className("android.widget.CheckedTextView"));
			List<String> aEd = new LinkedList<String>();
			aEd.add(qual_field);
			aEd.add(edu_stream_field);
			aEd.add("new education 002");
			aEd.add(course_type_field);
			aEd.add(passout_yr_field);
			return aEd;
	}
	
	public static void deleteEducation(){
		driver.findElementsById("com.net.shine:id/education_detail_view").get(0).findElements
		(By.className("android.widget.RelativeLayout")).get(5).findElements
		(By.className("android.widget.LinearLayout")).get(1).findElement(By.id("com.net.shine:id/delete_skills")).click();
	List<WebElement> l1 = driver.findElementsById("com.net.shine:id/field_name");
	int count=0;
	while(count<l1.size()){
		Assert.assertNotEquals(l1.get(count).getText(), "new education 002");
		count++;
	}
	}
	
	public static List<String> editEducation() throws AWTException{
		driver.findElementsById("com.net.shine:id/education_detail_list").get(0).findElements(By.className("android.widget.RelativeLayout")).get(0).findElements(By.className("android.widget.LinearLayout")).get(1).findElements(By.className("android.widget.ImageView")).get(1).click();
		
		
//		List<WebElement> l1 = driver.findElementsByClassName("android.widget.ImageView");
//		int count = l1.size() - 1;
//		l1.get(count).click();
		clearAndEnter(By.id("com.net.shine:id/ins_name_field"),"new education 003");
		//driver.findElementById("com.net.shine:id/comp_name_field").sendKeys("new education name 003");
		
		String qual_field= textFromDropDown(By.id("com.net.shine:id/qual_field"),By.className("android.widget.CheckedTextView"));
		
		String edu_stream_field= driver.findElementById("com.net.shine:id/edu_stream_field").getText();
		String course_type_field= textFromDropDown(By.id("com.net.shine:id/course_type_field"),By.className("android.widget.CheckedTextView"));
		String passout_yr_field= textFromDropDown(By.id("com.net.shine:id/passout_yr_field"),By.className("android.widget.CheckedTextView"));
		List<String> eEd = new LinkedList<String>();
		eEd.add(qual_field);
		eEd.add(edu_stream_field);
		eEd.add("new education 003");
		eEd.add(course_type_field);
		eEd.add(passout_yr_field);
		return eEd;
	}
	public static List<String> addSkill(){
		driver.scrollToExact("Skills");
		driver.findElementById("com.net.shine:id/add_new_skills").click();
		
	//	driver.findElementById("com.net.shine:id/add_btn").click();
		driver.findElementById("com.net.shine:id/skill_name").sendKeys("new skill 111");
		
		String skill_level_field= textFromDropDown(By.id("com.net.shine:id/skill_level_field"),By.className("android.widget.CheckedTextView"));
		String totalSkill = "new skill 001,"+skill_level_field+" Yrs";
		List<String> aSki = new LinkedList<String>();
		aSki.add(totalSkill);
	    return aSki;
	}
	public static List<String> editSkill() throws AWTException{
driver.scrollTo("Skills");
		driver.findElementById("com.net.shine:id/editskill").click();
		clearAndEnter(By.id("com.net.shine:id/skill_name"),"new skill 222");
		String skill_level_field= textFromDropDown(By.id("com.net.shine:id/skill_level_field"),By.className("android.widget.CheckedTextView"));
		String totalSkill = "new skill 002,"+skill_level_field+" Yrs";
		List<String> eSki = new LinkedList<String>();
		eSki.add(totalSkill);
	    return eSki;
	}
	public static void deleteSkills(){
	//	driver.findElementById("com.net.shine:id/editskill").click();
//		List<WebElement> l1 = driver.findElementsById("com.net.shine:id/e_details");
//		int count=0;
//		while(count<l1.size())
//			if(l1.get(0).findElements(By.className("android.widget.LinearLayout"))
//					.get(count).findElement(By.id("com.net.shine:id/skill_name")).getText().contains("new skill 002")){
//		l1.get(0).findElements(By.className("android.widget.LinearLayout")).get(count).findElement(By.id("com.net.shine:id/delete_skill")).click();
//		Assert.assertNotEquals(l1.get(0).findElements(By.className("android.widget.LinearLayout"))
//				.get(count).findElement(By.id("com.net.shine:id/skill_name")).getText(),"new skill 002");	
//		break;
//			} else {
//				count++;
//			}
		
		List<WebElement> l1 = driver.findElementsById("com.net.shine:id/e_details");
		int count=0;
		while(count<l1.size()){
			if(l1.get(count).findElement(By.id("com.net.shine:id/skill_name")).getText().contains("new skill 111")){
				
				l1.get(count).findElement(By.id("com.net.shine:id/delete_skill")).click();
	//	Assert.assertNotEquals(l1.get(count).getText(),"new skill 002");	
		break;
			} else {
				count++;
			}
		}
			}
	public static List<String> editDesJob(){
		driver.scrollTo("Desired Job Details");
		String ind1=driver.findElementById("com.net.shine:id/desired_industry").getText();
driver.findElementById("com.net.shine:id/desired_edit").click();
driver.findElementById("com.net.shine:id/city_name_des").click();
clickFromList(By.className("android.widget.CheckedTextView"),0, "random");
driver.findElementById("android:id/button1").click();
		String city_name_des= driver.findElementById("com.net.shine:id/city_name_des").getText();
		String func_area_field_des = driver.findElementById("com.net.shine:id/func_area_field_des").getText();
		driver.findElementById("com.net.shine:id/industry_name_field_des").click();
		clickFromList(By.className("android.widget.CheckedTextView"),0, "random");
		driver.findElementById("android:id/button1").click();
		String industry_name_field_des= driver.findElementById("com.net.shine:id/industry_name_field_des").getText();
		
		String annual_salary_field_des= textFromDropDown(By.id("com.net.shine:id/annual_salary_field_des"),By.className("android.widget.CheckedTextView"));
		String job_type_field= textFromDropDown(By.id("com.net.shine:id/annual_salary_field_des"),By.className("android.widget.CheckedTextView"));
	
	    String shift_type = driver.findElementById("com.net.shine:id/radioShiftNo").getText(); 
	    List<String> dJob = new LinkedList<String>();
	    dJob.add(city_name_des);
	    dJob.add(func_area_field_des);
	    dJob.add(industry_name_field_des);
	    dJob.add(job_type_field);
	    dJob.add(annual_salary_field_des);
	    dJob.add(shift_type);
		return dJob;
	}

	public static void verifyDesiredJobDetails(List<String> data){
		driver.scrollTo("Desired Job Details");
		//Assert.assertEquals(driver.findElementById("com.net.shine:id/desired_location"), data.get(0));
		//Assert.assertEquals(driver.findElementById("com.net.shine:id/desired_functional_area").getText(), data.get(1));
	//	Assert.assertEquals(driver.findElementById("com.net.shine:id/desired_industry").getText(), data.get(2));
		Assert.assertEquals(driver.findElementById("com.net.shine:id/desired_job_type").getText(), data.get(3));
		Assert.assertEquals(driver.findElementById("com.net.shine:id/desired_shift_type").getText(), data.get(4));
		Assert.assertEquals(driver.findElementById("com.net.shine:id/desired_salary").getText(), data.get(5));
	}
	
	public static void addResume(){
		driver.scrollTo("Resume");
		driver.findElementById("com.net.shine:id/add_new_resumes").click();
		CommonMethods.uploadResume("yes","Shine_Resume.docx");
		List<WebElement> l = driver.findElementsById("com.net.shine:id/field_name");
		int count =0;
		
		while(count<l.size()){
			String[] resume=l.get(count).getText().split("_");
			if(resume[0].contains("Shine")){
				Assert.assertEquals(resume[0], "Shine");
				break;
			} else{
				count++;
			}
		}
	}
	
	public static void editResumeMenu() throws InterruptedException{
		driver.findElementsById("com.net.shine:id/menu_resume").get(0).click(); //old resume
		driver.findElementByName("Set as default").click();
		
		//driver.scrollTo("Resume");
		driver.findElementsById("com.net.shine:id/menu_resume").get(1).click();
		driver.findElementByName("Delete").click();
		Thread.sleep(3000);
		List<WebElement> l = driver.findElementsById("com.net.shine:id/field_name");
		int count =0;
		String[] resume= new String[l.size()];
		while(count<l.size()){
			resume=l.get(count).getText().split("_");
			if(resume[0].contains("Shine")){
				Assert.assertEquals(resume[0], "Shine");
				break;
			} else{
				
				count++;
			}
			
		}
		System.out.println(resume[0]);
		Assert.assertNotEquals(resume[0], "Shine");
		//driver.findElementById("Download").click();
	}
	
	public static void editProfile(List<String> data){
		WebDriverWait w1 = new WebDriverWait(driver,5);
		w1.until(ExpectedConditions.presenceOfElementLocated(By.id("com.net.shine:id/user_info_layout")));
List<WebElement>l1 = driver.findElementsByClassName("android.widget.TextView");
int count = 0;
System.out.println(l1.size());
while (count< l1.size()){
	
//	if(l1.get(count).getText().contains("Profile Title:") && l1.get(count+1).getText().contains(data.get(0))){
//		count = count +1;
//		Assert.assertEquals(l1.get(count).getText(),data.get(0));
//		count = count + 2;
//		Assert.assertEquals(l1.get(count).getText(),data.get(1));
//		count = count + 2;
//		Assert.assertEquals(l1.get(count).getText(),data.get(2));
//		count = count + 2;
//		Assert.assertEquals(l1.get(count).getText(),data.get(3));
//		count = count + 2;
//		Assert.assertEquals(l1.get(count).getText().replace("+", ""),data.get(4));
//		count ++;
//		break;
//	
//	} else 
	if(l1.get(count).getText().contains("Company Name:")&&l1.get(count+1).getText().contains(data.get(0))){
		count = count +1;
		Assert.assertEquals(l1.get(count).getText(),data.get(0));
		count = count + 2;
		Assert.assertEquals(l1.get(count).getText(),data.get(1));
		count = count + 2;
		Assert.assertEquals(l1.get(count).getText(),data.get(2));
		count = count + 2;
		Assert.assertEquals(l1.get(count).getText(),data.get(3));
		count ++;
		break;
	} else if (l1.get(count).getText().contains("Qualification Level:")&&l1.get(count+1).getText().contains(data.get(0))){
		count = count +1;
		Assert.assertEquals(l1.get(count).getText(),data.get(0));
		count = count + 3;
		Assert.assertEquals(l1.get(count).getText(),data.get(1));
		count = count + 2;
		Assert.assertEquals(l1.get(count).getText(),data.get(2));
		count = count + 2;
		Assert.assertEquals(l1.get(count).getText(),data.get(3));
		count = count + 2;
		Assert.assertEquals(l1.get(count).getText(),data.get(4));
		count++;
		break;
	} else if (l1.get(count).getText().contains("Skills")&&l1.get(count+1).getText().contains(data.get(0))){
		count = count +1;
		System.out.println(count);
		Assert.assertEquals(l1.get(count).getText(),data.get(0));
		count++;
		break;
//	} else if (l1.get(count).getText().contains("Desired Job Details")){
//		count = count +1;
//		Assert.assertEquals(l1.get(count).getText(),data.get(0));
//		count = count + 2;
//		Assert.assertEquals(l1.get(count).getText(),data.get(1));
//		count = count + 2;
//		Assert.assertEquals(l1.get(count).getText(),data.get(2));
//		count = count + 2;
//		Assert.assertEquals(l1.get(count).getText(),data.get(3));
//		count = count + 2;
//		Assert.assertEquals(l1.get(count).getText(),data.get(4));
//		count = count + 2;
//		Assert.assertEquals(l1.get(count).getText(),data.get(5));
//		count++;
	} else {
		count ++;
	}
}
	}
}
