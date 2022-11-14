package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	
	   @FindBy(xpath="//a[contains(text(),'Login')]")
	    WebElement logIn;
	    
	    @FindBy(name="email")
	    WebElement username;
	    
	    @FindBy(name="password")
	    WebElement password;
		
	    @FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	    WebElement loginBtn;
		
	    @FindBy(xpath="//a[contains(text(),'Sign Up')]")
	    WebElement SignUpBtn;
		
	    @FindBy(xpath="//img[@class='img-responsive']")
	    WebElement crmLogo;
	    
	   //Initializing the Page Object 
	   public LoginPage (){
		   PageFactory.initElements(driver, this);
	    	
	    }
	   
	   //Actions:
	   public String validateLoginPageTitle() {
		   return driver.getTitle();
	   }
	   
	   public boolean validateCRMImage() {
		  return crmLogo.isDisplayed();
	   }
	   
	   public HomePage login(String un, String pwd) throws InterruptedException  {
		 Thread.sleep(2000);
		   logIn.click();
		   username.sendKeys(un);
		   password.sendKeys(pwd);
		   loginBtn.click();
		//  Thread.sleep(4000);
		   
		   return new HomePage();
	   }

	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
}
