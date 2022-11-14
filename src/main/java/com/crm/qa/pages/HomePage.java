package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	Actions build = new Actions(driver);

	@FindBy (xpath="//b[contains(text(),'The Rolling Point INC.')]")
	WebElement userNameLabel;
	
	@FindBy (xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy (xpath="//body/div[@id='ui']/div[@class='ui fluid container']/div[@id='main-nav']/div[3]/button[1]")
	WebElement newContactLink;
	
	//initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		//build.moveToElement(contactsLink).perform();
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsLink() throws InterruptedException {
		//build.moveToElement(dealsLink).perform();
		Thread.sleep(3000);
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContact() {
		build.moveToElement(contactsLink).perform();
		newContactLink.click();
		
	}
}
