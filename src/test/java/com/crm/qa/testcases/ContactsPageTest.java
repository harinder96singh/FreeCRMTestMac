package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	 LoginPage loginPage; 
	 HomePage homePage;
	 ContactsPage contactsPage;
	 TestUtil testUtil;
	 String sheetName = "contacts";
	 
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil(); 
		contactsPage = new ContactsPage();
		homePage = new HomePage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		
				
	}
	
	
	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.contactsLabel(),"conTactsLabel does not match");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority = 2, dataProvider="getCRMTestData")
	public void validateCreateMultipleNewContact(String title, String firstName, String lastName, String company) throws InterruptedException {
	    homePage.clickOnNewContact();
	    //contactsPage.createNewContact("Mr.","Tom", "Peter", "Google");
	    contactsPage.createNewContact(title, lastName, firstName, lastName);
	    
	}
	
	@Test(priority = 3)
	public void validateCreateSingleNewContact() {
	    homePage.clickOnNewContact();
	    contactsPage.createNewContact("Mr.","Tom", "Peter", "Google");
	    
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
