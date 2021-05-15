package com.liveguru.users;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserHomePO;
import pageObjects.UserMobileProductPO;
import pageObjects.UserProductDetailPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_03_Product_Price_Display extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);

		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Verify_Product_Price_Display() {
		log.info("Price Display - Step 01: Click on 'Mobile' menu");
		homePage.clickOnMobileMenu();
		mobileProductPage = PageGeneratorManager.getUserMobileProductPage(driver);

		log.info("Price Display - Step 02: Get price of 'Sony Xperia' mobile");
		mobileProductPage.getSonyXperiaPriceOnProductPage("Sony Xperia");

		log.info("Price Display - Step 03: Click on 'Sony Xperia' detail");
		mobileProductPage.clickOnSonyXperiaProductName("Sony Xperia");
		productDetailPage = PageGeneratorManager.getUserProductDetailPage(driver);

		log.info("Price Display - Step 04: Get price of 'Sony Xperia' on Detail page");
		productDetailPage.getSonyXperiaPriceOnDetailPage();

		log.info("Price Display - Step 05: Verify Price of 'Sony Xperia' in Product page & Detail page are equal");
		verifyEquals(mobileProductPage.getSonyXperiaPriceOnProductPage("Sony Xperia"), productDetailPage.getSonyXperiaPriceOnDetailPage());

	}

	UserHomePO homePage;
	UserMobileProductPO mobileProductPage;
	UserProductDetailPO productDetailPage;

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
