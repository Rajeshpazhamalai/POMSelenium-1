package com.Web;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_SignUpTests 
{
	 WebDriver driver;
	 WebDriverObject driverObj=new WebDriverObject();
	 FileManager fileManager=new FileManager();
	 WebDriverHelper driverHelper=new WebDriverHelper();
	 @BeforeClass
	 void setup() throws IOException, InterruptedException 
	 {
		 String browser=fileManager.pReader("browser");
		 driver=driverObj.setup(browser);
		 driver.get(fileManager.pReader("urlSignUP"));
	 }
	 @Test
	 public void userSignUp() throws IOException, InterruptedException 
	 {
		 SignUpPage signUp=new SignUpPage(driver);
		 Thread.sleep(5000);
		 signUp.btnCloseCookies.click();
		 driverHelper.typeText(signUp.txtEmail, fileManager.pReader("email"));
		 driverHelper.typeText(signUp.txtCreatePassword, fileManager.pReader("newPassword"));
		 driverHelper.typeText(signUp.textConfirmPassword, fileManager.pReader("newPassword"));
		 driverHelper.typeText(signUp.txtFirstName, fileManager.pReader("FirstName"));
		 driverHelper.typeText(signUp.txtLastName, fileManager.pReader("LastName"));
		 signUp.selectCountryFromOptions(fileManager.pReader("country"));
		 if(fileManager.pReader("country").equals("India")) 
		 {
			 if(signUp.dropDownState.isEnabled())
			 {
			 signUp.selectStateFromOptions(fileManager.pReader("state"));
			 }
		 }		 
		 driverHelper.typeText(signUp.txtCity, fileManager.pReader("City"));
		 driverHelper.typeText(signUp.txtPhone, fileManager.pReader("Phone"));
		 signUp.chkBoxJobAlert.click();
		 signUp.selectJoblocationFromOptions(fileManager.pReader("locationName"));
		 
	 }
	 @AfterClass
	 void closeDriver() {
		 //driver.close();
	 }
}
