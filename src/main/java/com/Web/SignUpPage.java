package com.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
WebDriver driver;
	
	//Constructor
	public SignUpPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@class='optanon-alert-box-close banner-close-button']")
	WebElement btnCloseCookies;
	@FindBy(id="CareersRegistration_EmailAddress")
	WebElement txtEmail;
	@FindBy(id="CareersRegistration_Password")
	WebElement txtCreatePassword;
	@FindBy(id="CareersRegistration_RetypePassword") 
	WebElement textConfirmPassword;
	
	@FindBy(id="CareerRegistration_FirstName")
	WebElement txtFirstName;
	@FindBy(id="CareerRegistration_LastName")
	WebElement txtLastName;
	
	@FindBy(xpath="//div[@class='col-sm-6']//div[@class='col-xs-12 col-sm-10 custom-dropdown']//span[@class='acn-icon icon-arrow-dropdown']")
	WebElement dropDownCountry;
	
	@FindBy(xpath="(//button[@data-id='ddBoxRegistrationStateProvince']/span)[2]")
	WebElement dropDownState;
		
	//@FindBy(xpath="(//div[@class='btn-group bootstrap-select form-control validate-excluded-field' and @aria-labelledby='ddBoxRegistrationStateProvince-label']")
	//WebElement dropDownState;
	
	@FindBy(id="CareerRegistration_City") 
	WebElement txtCity;
	@FindBy(id="TalentConnectionRegistration_PhoneNumber")
	WebElement txtPhone;
	@FindBy(id="chkJobAlert")
	WebElement chkBoxJobAlert;
	
	@FindBy(xpath="(//button[@data-id='ddlPreferredCountryRegion']/span[@class='shortText dotdot'])")
	WebElement preferredjoblocation;
	
	String countryPath="//span[text()='";
	public void selectCountryFromOptions(String countryName) 
	{
		try 
		{
			dropDownCountry.click();
			driver.findElement(By.xpath(countryPath+countryName+"']")).click();
			
		}catch(Exception e) 
		{
			System.out.println("Not able to select Country");
		}
	}
	String statePath="//span[text()='";
	public void selectStateFromOptions(String stateName) 
	{
		try 
		{
			dropDownState.click();
			driver.findElement(By.xpath(statePath+stateName+"']")).click();
				
		}catch(Exception e) 
		{
			System.out.println("Not able to select State");
		}
	}	
	String joblocationpath="//span[text()='";
	public void selectJoblocationFromOptions(String locationName) 
	{
		try 
		{
			preferredjoblocation.click();
			driver.findElement(By.xpath(joblocationpath+locationName+"']")).click();
				
		}catch(Exception e) 
		{
			System.out.println("Not able to select job location");
		}
	}
}
