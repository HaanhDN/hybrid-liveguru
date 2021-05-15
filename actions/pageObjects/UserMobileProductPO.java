package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.users.UsersAbstractPageUI;
import pageUIs.liveguru.users.UsersMobileProductPageUI;

public class UserMobileProductPO extends AbstractPage {
	WebDriver driver;
	
	public UserMobileProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public Object getSonyXperiaPriceOnProductPage(String productName) {
		return getElementText(driver, UsersMobileProductPageUI.DYNAMIC_PRODUCT_COST_BY_PRODUCT_NAME, productName);	
	}

	public void clickOnSonyXperiaProductName(String productName) {
		waitToElementClickable(driver, UsersAbstractPageUI.PRODUCT_TITLE, productName);
	}

	public void addProductToCart(String productName) {
		waitToElementClickable(driver, UsersMobileProductPageUI.DYNAMIC_ADD_TO_CART_BUTTON, productName);
		clickOnElement(driver, UsersMobileProductPageUI.DYNAMIC_ADD_TO_CART_BUTTON, productName);
		
	}


	
}
