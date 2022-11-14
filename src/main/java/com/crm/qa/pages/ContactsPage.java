package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement clickCreateButton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="company")
	WebElement companyName;
	
	//i[@class='save icon']
	@FindBy(xpath="//i[@class='save icon']")
	WebElement save;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactsLabel() {
	return	contactsLabel.isDisplayed();
	}
	

	public void createNewContact(String title, String ftName, String ltName, String cpName)  {
		Actions build = new Actions(driver);
		clickCreateButton.click();
		//Thread.sleep(3000);
		build.moveToElement(lastName).perform();
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
	    //companyName.sendKeys(cpName);
		
		//Select select = new Select(driver.findElement(By.xpath("//div[@class='ui selection upward dropdown']//div[@class='divider default text'][contains(text(),'Select')]")));
		//select.selectByVisibleText(category);
		//Thread.sleep(3000);
		save.click();
		
		
		
	}
}
