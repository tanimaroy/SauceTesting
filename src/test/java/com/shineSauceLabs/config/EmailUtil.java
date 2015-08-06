package com.shineSauceLabs.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.testng.annotations.AfterSuite;
import org.w3c.dom.*;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
//import org.apache.log4j.PropertyConfigurator;


public class EmailUtil {
	
	
	//********************* Email with attachment *********************
	public static Properties CONFIG;
	
	public static void sendAttachmentEmail(Session session, String toEmail, String subject, String body) throws Exception {
	     try{
	          MimeMessage msg = new MimeMessage(session);      
	          msg.setFrom(new InternetAddress("f2736@htmedia.in", "NoReply-HT"));
	          msg.setReplyTo(InternetAddress.parse("f2736@htmedia.in", false));
	          msg.setSubject(subject, "UTF-8");
	          msg.setSentDate(new Date());
	          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	          
	        
	          // Create the message body part
	          BodyPart messageBodyPart = new MimeBodyPart();
	          
	          // creates body part for the attachment
	          MimeBodyPart attachPart = new MimeBodyPart();
	       
	          
	          
	          //Calling function to attach the HTML report in a Email Body
	          //body= readFile("D:\\HTCampus\\test-output\\emailable-report.html");
	         // body=readFile("D:\\RecruiterWorkspace\\IP78IndiaHiring\\test-output\\emailable-report.html");
	          body=readFile("C:/Users/f2736/Documents/HtMediaWorkspace/shineSauceLabs/target/surefire-reports/emailable-report.html");
	          
	          
	          // Fill the bodypart in Email body
	          messageBodyPart.setContent(body,"text/html");
	          msg.setContent(body,"text/html");
	          
	          
	          // Create a multipart message for attachment
	          Multipart multipart = new MimeMultipart();
	  
	        
	          //String[] attachFiles = aDirectory.list();
	         
	          // Second part is attachment
//	          String[] attachFiles = new String[13];
//	          attachFiles[0] = "D:\\HTCampus\\screenshots\\Registration.jpg";
//	          attachFiles[1] = "D:\\HTCampus\\screenshots\\SearchInstitute.jpg";
//	          attachFiles[2] = "D:\\HTCampus\\screenshots\\VerifyEmail.jpg";
//			  attachFiles[3] = "D:\\HTCampus\\screenshots\\AskYourQuestion.jpg";
//			 // attachFiles[4] = "D:\\HTCampus\\screenshots\\SaveSearchResults.jpg";
//			  attachFiles[4] = "D:\\HTCampus\\screenshots\\CollegeProspectusDownload.jpg";
//			  attachFiles[5] = "D:\\HTCampus\\screenshots\\MockArticlePage.jpg";
//			  attachFiles[6] = "D:\\HTCampus\\screenshots\\UserAccount.jpg";
//			  //attachFiles[7] = "D:\\HTCampus\\screenshots\\AssistMe.jpg";
//			  attachFiles[7] = "D:\\HTCampus\\screenshots\\CatUserInput.jpg";
//			  attachFiles[8] = "D:\\HTCampus\\screenshots\\NavigationMenu.jpg";
//			  attachFiles[9] = "D:\\HTCampus\\screenshots\\SalaryPredictor.jpg";
//			  attachFiles[10] = "D:\\HTCampus\\screenshots\\NoProfileDetails.jpg";
//			  attachFiles[11] = "D:\\HTCampus\\screenshots\\prospectusError.jpg";
			// String appLog = System.getProperty("user.dir")+"\\src\\config\\Application.log";
	         // attachFiles[0] = "D:\\Desimartini_Selenium\\HTCampus\\screen\\Registration.jpg";
	          
			 
	          String directory = "C:/Users/f2736/Documents/HtMediaWorkspace/shineSauceLabs/screenShots";
	          File[] files = new File(directory).listFiles();
	          String[] attachFiles = new String[files.length];
	          int i =0;
	        
	          for(File file : files){
	        	  
	            if(file.isFile() && i<files.length){
	             // System.out.println(file.getAbsolutePath());
	              attachFiles[i] = file.getAbsolutePath();
	              System.out.println(i);
	              
	            }
	            i++;
	          }
	        
	        //  attachFiles[files.length] = System.getProperty("user.dir")+"\\src\\config\\Application.log";
	          System.out.println(attachFiles.length);
	          if (attachFiles != null && attachFiles.length > 0) {
		            for (String filePath : attachFiles) {
		            	System.out.println(filePath);
					File f = new File(filePath);
		                 attachPart = new MimeBodyPart();
		 
		                try {
		                    if(f.exists() && !f.isDirectory()){
		                    attachPart.attachFile(filePath);
		                	} else {
		                		//System.out.println(filePath);
		                		continue;
		                		
		                	}
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		               // } finally{
		                	 //attachPart.attachFile(appLog);
		                }
		 
		                multipart.addBodyPart(attachPart);
		            }
		        }
	          
	         /* DataSource source = new FileDataSource(attachFile);
	          attachPart.setDataHandler(new DataHandler(source));
	          attachPart.setFileName(new File(attachFile).getName());
	           
	          multipart.addBodyPart(messageBodyPart);
	          multipart.addBodyPart(attachPart);
	          
	          messageBodyPart = new MimeBodyPart();*/
        
	          multipart.addBodyPart(messageBodyPart);
	          // Send the complete message parts
	          msg.setContent(multipart);
	          msg.saveChanges();
	          
	          // Send message
	          Transport.send(msg);
	          System.out.println("Email Sent Successfully!!");
	       }catch (MessagingException e) {
	          e.printStackTrace();
	       } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	     }
	 }
		
	private static String readFile( String file ) throws Exception {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}
	
	
	
	public static void main(String[] args) throws Exception {
      //  CONFIG =new Properties();
		// FileInputStream cn=new FileInputStream(System.getProperty("user.dir")+"/src/config/Config.properties");
		 //CONFIG.load(cn);
        final String fromEmail = "f2736@htmedia.in"; //requires valid email id
        final String password = "Milotic.2015"; // correct password for email id
        
        final String toEmail = "nikunj.bhatter@hindustantimes.com,mansha.chuttani@hindustantimes.com,sumit.jain@hindustantimes.com,rajesh.kaushik@hindustantimes.com,ankur.gupta@hindustantimes.com,tanima.roy@hindustantimes.com,nisarg.mehta@hindustantimes.com,Jaspreet.Oberoi@hindustantimes.com,gaurav.bansal@hindustantimes.com"; // any email id
        
     //   final String toEmail = "tanima.roy@hindustantimes.com"; // any email id
        
        
       // final String toEmail = "vikas.srivastava@hindustantimes.com"; // any email id
        String[] text = new String[4];
        try {

        	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        	Document doc = docBuilder.parse (new File("C:/Users/f2736/Documents/HtMediaWorkspace/shineSauceLabs/target/surefire-reports/testng-results.xml"));

        	// normalize text representation
        	doc.getDocumentElement ().normalize ();
        	


        	NodeList results = doc.getElementsByTagName("testng-results");
        	

        	Element firstNameElement = (Element)results.item(0);
        	NamedNodeMap r2 = firstNameElement.getAttributes();
        	
        	System.out.println(r2.getLength());
        	for (int i = 0; i < r2.getLength(); ++i)
        	{
        	    Node attr = r2.item(i);
        	    text[i]=attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"";
        	    //System.out.println(attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"");
        	}

        } catch(Exception e){
        	
        }
        System.out.println(Arrays.toString(text));
        Properties props = new Properties();
        
        props.put("mail.smtp.host", "pod51024.outlook.com"); //SMTP Host - office 
       // props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host - office
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
       
        
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
        //override the getPasswordAuthentication method
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(fromEmail, password);
        	}
        };
	
	    Session session = Session.getInstance(props, auth);
	//	System.out.println(CONFIG.getProperty("testSiteURL"));
	    System.out.println("Authorization passed...");
	    
	     //Calling Email Function with attachment // add version no
        EmailUtil.sendAttachmentEmail(session, toEmail,"Shine Android SauceLabs Report"+" "+Arrays.toString(text), "Sir, Check your Automation report.");
	}        
}	            