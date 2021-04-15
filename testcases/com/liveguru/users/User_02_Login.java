package com.liveguru.users;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserAccountDashboardPO;
import pageObjects.UsersHomePO;
import pageObjects.UsersLoginPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_02_Login extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);

		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Pre-condition - Step 01: Click on Account menu");
		homePage.clickOnAccountMenu(driver);

		log.info("Pre-condition - Step 02: Open Log In Page from Account menu");
		homePage.openMenuPageByTitle(driver, "Log In");
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Empty_Fields() {
		log.info("Login 1 - Step 01: Click on Login button");
		loginPage.clickLoginButton();
		
		log.info("Login 1 - Step 02: Verify required error message displays at Email Address field");
		verifyEquals(loginPage.getRequiredErrorMessageAtEmailField("email"), "This is a required field.");
		
		log.info("Login 1 - Step 03: Verify required error message displays at Password field");
		verifyEquals(loginPage.getRequiredErrorMessageAtPasswordField("pass"), "This is a required field.");

	}

	@Test
	public void TC_02_Correct_Email_Invalid_Password() {
		log.info("Login 2 - Step 01: Input Email Address textbox with value " + UserData.Login.USER_EMAIL + "");
		loginPage.inputEmailTextbox(UserData.Login.USER_EMAIL);
		
		log.info("Login 2 - Step 02: Input Password textbox with value '123'");
		loginPage.inputPasswordTextbox("123");
		
		log.info("Login 3 - Step 03: Click on Login button");
		loginPage.clickLoginButton();
		
		log.info("Login 2 - Step 04: Verify validation error message displayes at Password field");
		verifyEquals(loginPage.getValidationErrorMessageAtPasswordField("password-pass"), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_03_Invalid_Email_Correct_Password() {
		log.info("Login 3 - Step 01: Input Email Address Textbox with value 'gmlogin123@gmail'");
		loginPage.inputEmailTextbox("gmlogin123@gmail");
		
		log.info("Login 3 - Step 02: Input Password Textbox with value " + UserData.Login.USER_PASSWORD + "");
		loginPage.inputPasswordTextbox(UserData.Login.USER_PASSWORD);
		
		log.info("Login 3 - Step 03: Click on Login button");
		loginPage.clickLoginButton();
		
		log.info("Login 3 - Step 04: Verify validation error message displays at Email Adress field");
		verifyEquals(loginPage.getValidationErrorMessageAtEmailField("email-email"), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_04_Incorrect_Password() {
		log.info("Login 4 - Step 01: Input Email Address Textbox with value " + UserData.Login.USER_EMAIL + getRandomNumber() + "");
		loginPage.inputEmailTextbox(UserData.Login.USER_EMAIL);
		
		log.info("Login 4 - Step 02: Input Password Textbox with value " + UserData.Login.USER_PASSWORD + getRandomNumber() + "");
		loginPage.inputPasswordTextbox(UserData.Login.USER_PASSWORD + getRandomNumber());
		
		log.info("Login 4 - Step 03: Click on Login button");
		loginPage.clickLoginButton();
		
		log.info("Login 4 - Step 04: Verify error message displays under page title");
		verifyEquals(loginPage.getErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_05_Correct_Email_And_Password() {
		log.info("Login 5 - Step 01: Input Email Address Textbox with value " + UserData.Login.USER_EMAIL + "");
		loginPage.inputEmailTextbox(UserData.Login.USER_EMAIL);
		
		log.info("Login 5 - Step 02: Input Password Textbox with value " + UserData.Login.USER_PASSWORD + "");
		loginPage.inputPasswordTextbox(UserData.Login.USER_PASSWORD);
		
		log.info("Login 5 - Step 03: Click on Login button");
		loginPage.clickLoginButton();
		
		log.info("Login 5 - Step 04: Verify My Dashboard page title displays");
		accountDashboardPage = PageGeneratorManager.getAccountDashboardPage(driver);
		
		verifyEquals(accountDashboardPage.getUserAccountPageTitle(driver), "MY DASHBOARD");
		
		log.info("Login 5 - Step 05: Verify Welcome Message displays");
		verifyEquals(accountDashboardPage.getAccountDashboardWelcomeMessage(), "Hello," + " " + UserData.Account_Info.USER_FIRSTNAME + " " + UserData.Account_Info.USER_LASTNAME + "!");
	
	}

	UsersHomePO homePage;
	UsersLoginPO loginPage;
	UserAccountDashboardPO accountDashboardPage;
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
