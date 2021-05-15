package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.users.UsersProductDetailPageUI;

public class UserProductDetailPO extends AbstractPage {
	WebDriver driver;
	
	public UserProductDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public Object getSonyXperiaPriceOnDetailPage() {
		return getElementText(driver, UsersProductDetailPageUI.PRODUCT_PRICE_ON_DETAIL_PAGE);
		
	}


	
}
