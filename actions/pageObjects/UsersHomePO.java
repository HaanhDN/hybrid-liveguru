package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.users.UserHomePageUI;

public class UsersHomePO extends AbstractPage{
	WebDriver driver;
	
	public UsersHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public Object getSuccessMessage() {
		waitToElementVisible(driver, UserHomePageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserHomePageUI.REGISTER_SUCCESS_MESSAGE);
	}

}
