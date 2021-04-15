package com.liveguru.users;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UsersHomePO;
import pageObjects.UsersRegisterPO;

public class User_01_Register extends AbstractTest {
	WebDriver driver;
	String firstName, lastName, email, password;
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		email = "automationFC" +getRandomNumber() + "@xyz.com";
		password = "123123";
		
	}
	
	@Test
	public void TC_01_Register_Unsuccessful_All_Fields_Empty() {
		log.info("Register 1 - Step 01: Open Register Page ");
		homePage.clickOnAccountMenu(driver);
		homePage.openMenuPageByTitle(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Register 1 - Step 02: Click Register button ");
		registerPage.clickRegisterButton();
		
		log.info("Register 1 - Step 03: Verify Error Message on required fields ");
		verifyEquals(registerPage.getRequiredErrorMessageAtFirstNameField("firstname"), "This is a required field.");
		verifyEquals(registerPage.getRequiredErrorMessageAtLastNameField("lastname"), "This is a required field.");
		verifyEquals(registerPage.getRequiredErrorMessageAtEmailAddressField("email_address"), "This is a required field.");
		verifyEquals(registerPage.getRequiredErrorMessageAtPasswordField("password"), "This is a required field.");
		verifyEquals(registerPage.getRequiredErrorMessageAtConfirmPasswordField("confirmation"), "This is a required field.");
		
	}
	
	
	@Test
	public void TC_02_Register_Unsuccessful_Invalid_Email_And_Password() {
		log.info("Register 2 - Step 01: Reload Register Page ");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Register 2 - Step 02: Input in Firstname field with value " + firstName + "");
		registerPage.inputFirstNameTextbox(firstName);
		
		log.info("Register 2 - Step 03: Input in Lastname field with value " + lastName + "");
		registerPage.inputLastNameTextbox(lastName);
		
		log.info("Register 2 - Step 04: Input in Email Address field with value 'AutomationFC@gmail'");
		registerPage.inputEmailTextbox("AutomationFC@gmail");
		
		log.info("Register 2 - Step 05: Input in Password field with value '123'");
		registerPage.inputPasswordTextbox("123");
		
		log.info("Register 2 - Step 06: Input in Confirm Password field with value '123'");
		registerPage.inputConfirmPasswordTextbox("123");
		
		log.info("Register 2 - Step 07: Click on Register button");
		registerPage.clickRegisterButton();
		
		log.info("Register 2 - Step 08: Verify error message displays at Email Address field");
		verifyEquals(registerPage.getValidationErrorMessageAtEmailAddressField("email-email_address"), "Please enter a valid email address. For example johndoe@domain.com.");	
		
		log.info("Register 2 - Step 09: Verify error message displays at Password field");
		verifyEquals(registerPage.getValidationErrorMessageAtPasswordField("password-password"), "Please enter 6 or more characters without leading or trailing spaces.");	
	}
	
	
	@Test
	public void TC_03_Register_Unsuccessful_Unmatched_Password() {
		log.info("Register 3 - Step 01: Reload Register Page ");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Register 3 - Step 02: Input in Firstname field with value " + firstName + "");
		registerPage.inputFirstNameTextbox(firstName);
		
		log.info("Register 3 - Step 03: Input in Lastname field with value " + lastName + "");
		registerPage.inputLastNameTextbox(lastName);
		
		log.info("Register 3 - Step 04: Input in Email Address field with value " + email + "");
		registerPage.inputEmailTextbox(email);
		
		log.info("Register 3 - Step 05: Input in Password field with value " + password + "");
		registerPage.inputPasswordTextbox(password);
		
		log.info("Register 3 - Step 06: Input in Confirm Password field with value " + password + getRandomNumber() + "");
		registerPage.inputConfirmPasswordTextbox(password + getRandomNumber());
		
		log.info("Register 3 - Step 07: Click on Register button");
		registerPage.clickRegisterButton();
		
		log.info("Register 3 - Step 08: Verify error message displays at Confirm Password field");
		verifyEquals(registerPage.getValidationErrorMessageAtConfirmPasswordField("cpassword-confirmation"), "Please make sure your passwords match.");	
	}
	
	
	@Test
	public void TC_04_Register_Successful() {
		log.info("Register 4 - Step 01: Reload Register Page ");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Register 4 - Step 02: Input in Firstname field with value " + firstName + "");
		registerPage.inputFirstNameTextbox(firstName);
		
		log.info("Register 4 - Step 03: Input in Lastname field with value " + lastName + "");
		registerPage.inputLastNameTextbox(lastName);
		
		log.info("Register 4 - Step 04: Input in Email Address field with value " + email + "");
		registerPage.inputEmailTextbox(email);
		
		log.info("Register 4 - Step 05: Input in Password field with value " + password + "");
		registerPage.inputPasswordTextbox(password);
		
		log.info("Register 4 - Step 06: Input in Confirm Password field with value " + password + "");
		registerPage.inputConfirmPasswordTextbox(password);
		
		log.info("Register 4 - Step 06: Select Signup for Newsletter checkbox");
		registerPage.selectSignupNewsletterCheckbox();
		
		log.info("Register 4 - Step 08: Click on Register button");
		registerPage.clickRegisterButton();
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Register 4 - Step 09: Verify Success message displays on My Dashboard page");
		verifyEquals(homePage.getSuccessMessage(), "Thank you for registering with Main Website Store.");
	}
	
	UsersHomePO homePage;
	UsersRegisterPO registerPage;
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
