package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static UserHomePO getHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}

	public static UserRegisterPO getRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}

	public static UserLoginPO getLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}

	public static UserAccountDashboardPO getAccountDashboardPage(WebDriver driver) {
		return new UserAccountDashboardPO(driver);
	}
	
	public static UserMobileProductPO getUserMobileProductPage(WebDriver driver) {
		return new UserMobileProductPO(driver);
	}
	
	public static UserProductDetailPO getUserProductDetailPage(WebDriver driver) {
		return new UserProductDetailPO(driver);
	}
	
	public static UserCartPO getUserCartPage(WebDriver driver) {
		return new UserCartPO(driver);
	}
	
	public static UserCheckoutPO getUserCheckoutPage(WebDriver driver) {
		return new UserCheckoutPO(driver);
	}
	
}
