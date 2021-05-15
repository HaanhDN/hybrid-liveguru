package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.users.UserCheckoutPageUI;

public class UserCheckoutPO extends AbstractPage{
	WebDriver driver;
	
	public UserCheckoutPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmailTextbox(String userEmail) {
		waitToElementVisible(driver, UserCheckoutPageUI.USER_EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.USER_EMAIL_TEXTBOX, userEmail);
	}

	public void inputPasswordTextbox(String userPassword) {
		waitToElementVisible(driver, UserCheckoutPageUI.USER_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.USER_PASSWORD_TEXTBOX, userPassword);
	}

	public void clickLoginButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.LOGIN_BUTTON);
		clickOnElement(driver, UserCheckoutPageUI.LOGIN_BUTTON);
	}

	public Object getCheckoutStepTitle() {
		waitToElementVisible(driver, UserCheckoutPageUI.CHECKOUT_STEP_TITLE);
		return getElementText(driver, UserCheckoutPageUI.CHECKOUT_STEP_TITLE);
	}

	public void selectBillingAddress(String newAddress) {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutPageUI.BILLING_ADDRESS_DROPDOWN, newAddress);
	}
	
	public Object getUserFirstName(String attributeName) {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCheckoutPageUI.BILLING_FIRSTNAME_TEXTBOX, attributeName);
	}

	public Object getUserLastName(String attributeName) {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCheckoutPageUI.BILLING_LASTNAME_TEXTBOX, attributeName);
	}

	public void inputUserAddress(String billingAddress) {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_ADDRESS_TEXTBOX, billingAddress);
	}

	public void inputCity(String billingCity) {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_CITY_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_CITY_TEXTBOX, billingCity);
	}

	public void selectStateDropdown(String billingState) {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_STATE_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutPageUI.BILLING_STATE_DROPDOWN, billingState);
	}

	public void inputZIP(String billingZIP) {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_ZIP_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_ZIP_TEXTBOX, billingZIP);
	}

	public void selectCountryDropdown(String billingCountry) {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutPageUI.BILLING_COUNTRY_DROPDOWN, billingCountry);
	}

	public void inputTelephone(String billingTelephone) {
		waitToElementVisible(driver, UserCheckoutPageUI.BILLING_TELEPHONE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_TELEPHONE_TEXTBOX, billingTelephone);
	}

	public void clickBillingContinueButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.BILLING_CONTINUE_BUTTON);
		clickOnElement(driver, UserCheckoutPageUI.BILLING_CONTINUE_BUTTON);
	}

	public Object getShippingMethod() {
		waitToElementVisible(driver, UserCheckoutPageUI.SHIPPING_METHOD);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_METHOD);
	}

	public Object getFlatRate() {
		waitToElementVisible(driver, UserCheckoutPageUI.FLAT_RATE);
		return getElementText(driver, UserCheckoutPageUI.FLAT_RATE);
	}

	public void clickShipToThisAddressRadio() {
		waitToElementClickable(driver, UserCheckoutPageUI.SHIP_TO_THIS_ADDRESS_RADIO_BUTTON);
		clickOnElement(driver, UserCheckoutPageUI.SHIP_TO_THIS_ADDRESS_RADIO_BUTTON);
	}

	public void selectCheckMoneyOrderRadio() {
		waitToElementClickable(driver, UserCheckoutPageUI.CHECK_MONEY_ORDER_RADIO_BUTTON);
		clickOnElement(driver, UserCheckoutPageUI.CHECK_MONEY_ORDER_RADIO_BUTTON);
		
	}

	public Object getProductNameInOrderReview() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_REVIEW_PRODUCT_NAME);
		return getElementText(driver, UserCheckoutPageUI.ORDER_REVIEW_PRODUCT_NAME);
	}

	public Object getProductPriceInOrderReview() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_REVIEW_PRODUCT_PRICE);
		return getElementText(driver, UserCheckoutPageUI.ORDER_REVIEW_PRODUCT_PRICE);
	}

	public Object getProductQTYInOrderReview() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_REVIEW_PRODUCT_QTY);
		return getElementText(driver, UserCheckoutPageUI.ORDER_REVIEW_PRODUCT_QTY);
	}

	public Object getOrderSubtotalInOrderReview() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_REVIEW_SUBTOTAL);
		return getElementText(driver, UserCheckoutPageUI.ORDER_REVIEW_SUBTOTAL);
	}

	public Object getShippingRateInOrderReview() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_REVIEW_SHIPPING_RATE);
		return getElementText(driver, UserCheckoutPageUI.ORDER_REVIEW_SHIPPING_RATE);
	}

	public Object getGrandTotalInOrderReview() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_REVIEW_GRAND_TOTAL);
		return getElementText(driver, UserCheckoutPageUI.ORDER_REVIEW_GRAND_TOTAL);
	}

	public void clickPlaceOrderButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.PLACE_ORDER_BUTTON);
		clickOnElement(driver, UserCheckoutPageUI.PLACE_ORDER_BUTTON);
		
	}

	public Object getOrderSuccessPageTitleMessage() {
		waitToElementVisible(driver, UserCheckoutPageUI.CHECKOUT_SUCCESS_PAGE_TITLE);
		System.out.println(getElementText(driver, UserCheckoutPageUI.CHECKOUT_SUCCESS_PAGE_TITLE));
		return getElementText(driver, UserCheckoutPageUI.CHECKOUT_SUCCESS_PAGE_TITLE);
	}

	public boolean isOrderIDGenerated() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_ID_LINK);
		return isElementDisplayed(driver, UserCheckoutPageUI.ORDER_ID_LINK);
	}

	public String getOrderID() {
		waitToElementVisible(driver, UserCheckoutPageUI.ORDER_ID_LINK);
		return getElementText(driver, UserCheckoutPageUI.ORDER_ID_LINK);
	}

	public void clickOnOrderID() {
		waitToElementClickable(driver, UserCheckoutPageUI.ORDER_ID_LINK);
		clickOnElement(driver, UserCheckoutPageUI.ORDER_ID_LINK);
	}

	public void clickShippingContinueButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.SHIPPING_CONTINUE_BUTTON);
		clickOnElement(driver, UserCheckoutPageUI.SHIPPING_CONTINUE_BUTTON);
		
	}

	public void clickPaymentContinueButton() {
		waitToElementClickable(driver, UserCheckoutPageUI.PAYMENT_CONTINUE_BUTTON);
		clickOnElement(driver, UserCheckoutPageUI.PAYMENT_CONTINUE_BUTTON);
		
	}

	

}
