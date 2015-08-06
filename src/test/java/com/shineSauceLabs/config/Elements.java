package com.shineSauceLabs.config;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends BaseClass{
	
public static String REGISTER_BTN_ID ="com.net.shine:id/register_btn";

public static String LOGIN_BTN_ID = "com.net.shine:id/login_btn";

public static String REG_NAME_ID = "com.net.shine:id/name";

public static String REG_EMAIL_ID = "com.net.shine:id/email";

public static String REG_PASSWORD_ID="com.net.shine:id/password";

public static String REG_MOBILE_ID ="com.net.shine:id/mobile_field";

public static String REG_CITY_ID="com.net.shine:id/city";

public static String REG_FUNC_AREA_ID="com.net.shine:id/fun_area";

public static String REG_INDUSTRY_ID="com.net.shine:id/industry";

public static String REG_SALARY_ID="com.net.shine:id/current_salary";

public static String REG_EXP_ID="com.net.shine:id/total_exp";

public static String REG_SUBMIT_BTN_ID="com.net.shine:id/submit_btn";

public static String EDITREG_JOB_TITLE_ID="com.net.shine:id/job_title_field";

public static String EDITREG_COMPANY_NAME_ID="com.net.shine:id/comp_name_field";

public static String EDITREG_FUNC_AREA_ID="com.net.shine:id/func_area_field";

public static String EDITREG_START_Y_ID="com.net.shine:id/start_year";

public static String EDITREG_START_M_ID="com.net.shine:id/start_month";

public static String EDITREG_INDUSTRY_ID="com.net.shine:id/industry_name_field";

public static String EDITREG_QUALIFICATION_ID="com.net.shine:id/qual_field";

public static String EDITREG_SPECIALIZATION_ID="com.net.shine:id/edu_stream_field";

public static String EDITREG_COURSE_TYPE_ID="com.net.shine:id/course_type_field";

public static String EDITREG_INSTITUTE_NAME_ID="com.net.shine:id/ins_name_field";

public static String EDITREG_PASSOUT_Y_ID="com.net.shine:id/passout_yr_field";

public static String EDITREG_SKILL_N_ID="com.net.shine:id/skill_name";

public static String EDITREG_SKILL_Y_ID="com.net.shine:id/skill_level_field";

public static String HELP_GOT_IT_ID="com.net.shine:id/got_it";

public static String POPUP_ID="com.net.shine:id/dialog_msg";

public static String POPUP_OK_BTN="com.net.shine:id/ok_btn";

public static String SKIP_BTN_ID="com.net.shine:id/skip";

public static String KONNECT_SKIP_BTN_ID="com.net.shine:id/skip_btn";

public static String MOBILE_UPLOAD_ID="com.net.shine:id/mobile_upload";

public static String SIDE_MENU_CLASS="android.widget.ImageButton";

public static String SIDE_MENU_USERNAME_ID="com.net.shine:id/user_name";

public static String SIDE_MENU_INBOX_BTN="com.net.shine:id/inbox";

public static String GRID_VIEW_ID="com.net.shine:id/grid_view";

public static String NO_MAILS_ID="com.net.shine:id/progress_text";

public static String APPLY_JOB_ID="com.net.shine:id/apply_job";

public static String APPLY_BTN_ID="com.net.shine:id/apply_btn";

public static String APPLIED_JOB_ID="com.net.shine:id/applied_job";

public static String ALERT_CREATE_BTN_ID="com.net.shine:id/create_new_alert";

public static String ALERT_NAME_ID="com.net.shine:id/alert_name";

public static String ALERT_EMAIL_ID="com.net.shine:id/email_id";

public static String ALERT_LOCATION_ID="com.net.shine:id/location";

public static String DROPDOWN_OK_BTN_ID="android:id/button1";

public static String ALERT_MIN_EXP_ID="com.net.shine:id/min_exp_field";

public static String ALERT_MIN_SAL_ID="com.net.shine:id/min_sal_field";

public static String ALERT_INDUSTRY_ID="com.net.shine:id/industry_type_field";

public static String ALERT_KEYWORDS_ID="com.net.shine:id/keywords";

public static String ALERT_SAVE_BTN_ID="com.net.shine:id/cj_update_add_btn";

public static String ALERT_MENU_ID="com.net.shine:id/menu_recent";

public static String TEXT_VIEW_CLASS= "android.widget.TextView";

public static String SEARCH_BTN_ID="com.net.shine:id/search_btn";

public static String SEARCH_MORE_ID="com.net.shine:id/more";

public static String MATCHED_JOB_BTN_ID = "com.net.shine:id/match_job_btn";

public static String HEADER_TEXT_ID="com.net.shine:id/m_title";

public static String KONNECT_BTN_ID="com.net.shine:id/konnect_btn";

public static String createUser(String type){
	Random r = new Random( System.currentTimeMillis() );
    int n= (1 + r.nextInt(2)) * 100000 + r.nextInt(100000) ;
    char c = (char)(r.nextInt(26) + 'a');
    
    String user = " ";
    if(type.contains("fresher")){
    	user ="fftestFresher"+n+"@"+c+"mail.com";
    	System.out.println(user);
    	fullName = user;
    	userFull = n;
    } else {
    	user = "fftestshine"+n+"@"+c+"mail.com";
    	System.out.println(user);
    	fullName = user;
    	userFull = n;
    }
	return user;
}
public static void clickResumeRegister(){
	List<WebElement> l1 = driver.findElements(By.className("android.widget.ListView")).get(0).findElements(By.className("android.widget.LinearLayout"));
	System.out.println(l1.size());
	l1.get(l1.size()-1).click();
}
}
