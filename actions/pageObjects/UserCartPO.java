package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.users.UserCartPageUI;
import pageUIs.liveguru.users.UsersMobileProductPageUI;

public class UserCartPO extends AbstractPage {
	WebDriver driver;

	public UserCartPO(WebDriver driver) {
		this.driver = driver;
	}

	public Object getAddToCartSuccessMessage() {
		waitToElementVisible(driver, UserCartPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
		return getElementText(driver, UserCartPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
	}

	public boolean isProductImageDisplayedOnCartTable(String productName) {
		waitToElementVisible(driver, UserCartPageUI.PRODUCT_IMG_ON_CART_TABLE, productName);
		return isElementDisplayed(driver, UserCartPageUI.PRODUCT_IMG_ON_CART_TABLE, productName);
	}

	public boolean isProductNameDisplayedOnCartTable(String productName) {
		waitToElementVisible(driver, UserCartPageUI.PRODUCT_NAME_ON_CART_TABLE, productName);
		return isElementDisplayed(driver, UserCartPageUI.PRODUCT_NAME_ON_CART_TABLE, productName);
	}

	public Object getProductPriceOnCartTable(String productName) {
		waitToElementVisible(driver, UserCartPageUI.PRODUCT_PRICE_ON_CART_TABLE, productName);
		return getElementText(driver, UserCartPageUI.PRODUCT_PRICE_ON_CART_TABLE, productName);
	}

	public Object getProductQuantityOnCartTable(String productName) {
		waitToElementVisible(driver, UserCartPageUI.PRODUCT_QTY_ON_CART_TABLE, productName);
		return getElementAttribute(driver, UserCartPageUI.PRODUCT_QTY_ON_CART_TABLE, "value", productName);
	}

	public Object getProductSubtotalOnCartTable(String productName) {
		waitToElementVisible(driver, UserCartPageUI.PRODUCT_SUBTOTAL_ON_CART_TABLE, productName);
		return getElementText(driver, UserCartPageUI.PRODUCT_SUBTOTAL_ON_CART_TABLE, productName);
	}

	public void clickOnContinueShoppingLink() {
		waitToElementClickable(driver, UsersMobileProductPageUI.CONTINUE_SHOPPING_LINK);
		clickOnElement(driver, UsersMobileProductPageUI.CONTINUE_SHOPPING_LINK);
	}

	public Object getCartGrandtotal() {
		waitToElementVisible(driver, UserCartPageUI.CART_GRAND_TOTAL);
		return getElementText(driver, UserCartPageUI.CART_GRAND_TOTAL);
	}

	public Object getCartSubtotal() {
		waitToElementVisible(driver, UserCartPageUI.CART_SUB_TOTAL);
		return getElementText(driver, UserCartPageUI.CART_SUB_TOTAL);

	}

	public void removeProductFromCart(String rowIndex, String columnIndex) {
		waitToElementClickable(driver, UserCartPageUI.TRASH_CAN_BUTTON_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex, columnIndex);
		clickOnElement(driver, UserCartPageUI.TRASH_CAN_BUTTON_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex, columnIndex);

	}

	public void updateProductQTY(String productName, String QTY) {
		waitToElementVisible(driver, UserCartPageUI.QTY_TEXTBOX_ON_CART_TABLE, productName);
		sendkeyToElement(driver, UserCartPageUI.QTY_TEXTBOX_ON_CART_TABLE, QTY, productName);
	}

	public void clickUpdateButtonOnQTYColumn(String productName) {
		waitToElementClickable(driver, UserCartPageUI.UPDATE_BUTTON_ON_CART_TABLE, productName);
		clickOnElement(driver, UserCartPageUI.UPDATE_BUTTON_ON_CART_TABLE, productName);
	}

	public boolean isQTYErrorMessageDisplayed(String productName) {
		waitToElementVisible(driver, UserCartPageUI.QTY_ERROR_MESSAGE_ON_CART_TABLE, productName);
		return isElementDisplayed(driver, UserCartPageUI.QTY_ERROR_MESSAGE_ON_CART_TABLE, productName);
	}

	public void enterDiscountCodeToDiscountTextbox(String discountCode) {
		waitToElementVisible(driver, UserCartPageUI.DISCOUNT_CODE_TEXTBOX);
		sendkeyToElement(driver, UserCartPageUI.DISCOUNT_CODE_TEXTBOX, discountCode);

	}

	public void clickOnApplyLink() {
		waitToElementClickable(driver, UserCartPageUI.APPLY_DISCOUNT_LINK);
		clickOnElement(driver, UserCartPageUI.APPLY_DISCOUNT_LINK);
	}

	public boolean isDiscountDisplayedInCartTotalTable(String discountCode) {
		waitToElementVisible(driver, UserCartPageUI.DISCOUNT_ON_CART_TABLE, discountCode);
		return isElementDisplayed(driver, UserCartPageUI.DISCOUNT_ON_CART_TABLE, discountCode);
	}

	public Object getDiscountedAmount(String discountCode) {
		waitToElementVisible(driver, UserCartPageUI.DISCOUNT_AMOUNT_ON_CART_TABLE, discountCode);
		return getElementText(driver, UserCartPageUI.DISCOUNT_AMOUNT_ON_CART_TABLE, discountCode);
	}

	public void clickOnEmptyCartLink() {
		waitToElementClickable(driver, UserCartPageUI.EMPTY_CART_LINK);
		clickOnElement(driver, UserCartPageUI.EMPTY_CART_LINK);
	}

	public Object getEmptyCartPageHeader() {
		waitToElementVisible(driver, UserCartPageUI.EMPTY_CART_PAGE_TITLE);
		return getElementText(driver, UserCartPageUI.EMPTY_CART_PAGE_TITLE);
	}

	public Object getEmptyCartMessage() {
		waitToElementVisible(driver, UserCartPageUI.EMPTY_CART_MESSAGE);
		return getElementText(driver, UserCartPageUI.EMPTY_CART_MESSAGE);
	}

	public void clickOnHereLink() {
		waitToElementClickable(driver, UserCartPageUI.CLICK_HERE_TO_CONTINUE_SHOPPING_LINK);
		clickOnElement(driver, UserCartPageUI.CLICK_HERE_TO_CONTINUE_SHOPPING_LINK);
	}

	public void clickProceedToCheckoutButton() {
		waitToElementClickable(driver, UserCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		clickOnElement(driver, UserCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
	}

}
