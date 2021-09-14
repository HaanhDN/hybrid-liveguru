package com.liveguru.users;

import org.testng.annotations.Test;

import com.liveguru.usersdata.PurchaseData;
import com.liveguru.usersdata.UserData;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserCartPO;
import pageObjects.UserCheckoutPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMobileProductPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_04_Purchase extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);

		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Add_Product_To_Cart() {
		log.info("Add To Cart - Step 01: Click on 'Mobile' menu link");
		homePage.clickOnMobileMenu();
		mobileProductPage = PageGeneratorManager.getUserMobileProductPage(driver);

		log.info("Add To Cart - Step 02: Add 'Sony Xperia' to cart");
		mobileProductPage.addProductToCart("Sony Xperia");
		cartPage = PageGeneratorManager.getUserCartPage(driver);

		log.info("Add To Cart - Step 03: Verify add to cart success message");
		verifyEquals(cartPage.getAddToCartSuccessMessage(), "Sony Xperia was added to your shopping cart.");

		log.info("Add To Cart - Step 04: Verify Sony Xperia details displayed in cart");
		verifyTrue(cartPage.isProductImageDisplayedOnCartTable("Sony Xperia"));
		verifyTrue(cartPage.isProductNameDisplayedOnCartTable("Sony Xperia"));
		verifyEquals(cartPage.getProductPriceOnCartTable("Sony Xperia"), "$100.00");
		verifyEquals(cartPage.getProductQuantityOnCartTable("Sony Xperia"), "1");
		verifyEquals(cartPage.getProductSubtotalOnCartTable("Sony Xperia"), "$100.00");

		log.info("Add To Cart - Step 05: Verify SubTotal and Grand total");
		verifyEquals(cartPage.getCartSubtotal(), "$100.00");
		verifyEquals(cartPage.getCartGrandtotal(), "$100.00");

		log.info("Add To Cart - Step 06: Click on 'Continue Shopping' link");
		cartPage.clickOnContinueShoppingLink();
		mobileProductPage = PageGeneratorManager.getUserMobileProductPage(driver);

		log.info("Add To Cart - Step 07: Add 'iPhone' to cart");
		mobileProductPage.addProductToCart("IPhone");
		cartPage = PageGeneratorManager.getUserCartPage(driver);

		log.info("Add To Cart - Step 09: Verify add to cart success message");
		verifyEquals(cartPage.getAddToCartSuccessMessage(), "IPhone was added to your shopping cart.");

		log.info("Add To Cart - Step 10: Verify Iphone details in cart");
		verifyTrue(cartPage.isProductImageDisplayedOnCartTable("IPhone"));
		verifyTrue(cartPage.isProductNameDisplayedOnCartTable("IPhone"));
		verifyEquals(cartPage.getProductPriceOnCartTable("IPhone"), "$500.00");
		verifyEquals(cartPage.getProductQuantityOnCartTable("IPhone"), "1");
		verifyEquals(cartPage.getProductSubtotalOnCartTable("IPhone"), "$500.00");

		log.info("Add To Cart - Step 11: Verify Total and Grand total");
		verifyEquals(cartPage.getCartSubtotal(), "$600.00");
		verifyEquals(cartPage.getCartGrandtotal(), "$600.00");

		log.info("Add To Cart - Step 12: Remove 'iPhone' from cart");
		cartPage.removeProductFromCart("2", "6");

		log.info("Add To Cart - Step 13: Verify Subtotal and Grand total");
		verifyEquals(cartPage.getCartSubtotal(), "$100.00");
		verifyEquals(cartPage.getCartGrandtotal(), "$100.00");

	}

	@Test
	public void TC_02_Update_Product_Quantity() {
		log.info("Update Cart - Step 01: Update 'Sony Xperia' QTY to 100");
		cartPage.updateProductQTY("Sony Xperia", "100");

		log.info("Update Cart - Step 02: Click 'Update' button on QTY column'");
		cartPage.clickUpdateButtonOnQTYColumn("Sony Xperia");

		log.info("Update Cart - Step 03: Verify Subtotal column displays '$10,000.00'");
		verifyEquals(cartPage.getProductSubtotalOnCartTable("Sony Xperia"), "$10,000.00");

		log.info("Update Cart - Step 04: Verify Cart Subtotal and Grand total");
		verifyEquals(cartPage.getCartSubtotal(), "$10,000.00");
		verifyEquals(cartPage.getCartGrandtotal(), "$10,000.00");

		log.info("Update Cart - Step 05: Update 'Sony Xperia' QTY to 501");
		cartPage.updateProductQTY("Sony Xperia", "501");

		log.info("Update Cart - Step 06: Click 'Update' button on QTY column'");
		cartPage.clickUpdateButtonOnQTYColumn("Sony Xperia");

		log.info("Update Cart - Step 07: Verify error message displays '* The maximum quantity allowed for purchase is 500.'");
		verifyTrue(cartPage.isQTYErrorMessageDisplayed("Sony Xperia"));

		log.info("Update Cart - Step 08: Verify Cart Subtotal and Grand total didn't change");
		verifyEquals(cartPage.getCartSubtotal(), "$10,000.00");
		verifyEquals(cartPage.getCartGrandtotal(), "$0.00");

	}

	@Test
	public void TC_03_Add_Discount_Code() {
		log.info("Add Discount Code - Step 01: Update 'Sony Xperia' QTY to 1");
		cartPage.updateProductQTY("Sony Xperia", "1");

		log.info("Add Discount Code - Step 02: Click 'Update' button on QTY column'");
		cartPage.clickUpdateButtonOnQTYColumn("Sony Xperia");

		log.info("Add Discount Code - Step 03: Verify Subtotal column displays '$100.00'");
		verifyEquals(cartPage.getProductSubtotalOnCartTable("Sony Xperia"), "$100.00");

		log.info("Add Discount Code - Step 04: Verify Cart Subtotal and Grand total");
		verifyEquals(cartPage.getCartSubtotal(), "$100.00");
		verifyEquals(cartPage.getCartGrandtotal(), "$100.00");

		log.info("Add Discount Code - Step 05: Add discount code 'GURU50'");
		cartPage.enterDiscountCodeToDiscountTextbox("GURU50");

		log.info("Add Discount Code - Step 06: Click 'APPLY'");
		cartPage.clickOnApplyLink();

		log.info("Add Discount Code - Step 07: Verify discount added to cart");
		verifyTrue(cartPage.isDiscountDisplayedInCartTotalTable("GURU50"));
		verifyEquals(cartPage.getDiscountedAmount("GURU50"), "-$5.00");

		log.info("Add Discount Code - Step 08: Verify Cart Subtotal and Grand total");
		verifyEquals(cartPage.getCartSubtotal(), "$100.00");
		// verifyEquals(cartPage.getCartGrandtotal(), "$95.00");

		log.info("Add Discount Code - Step 09: Empty cart");
		cartPage.clickOnEmptyCartLink();

		log.info("Add Discount Code - Step 10: Verify Cart is empty");
		verifyEquals(cartPage.getEmptyCartPageHeader(), "SHOPPING CART IS EMPTY");
		verifyEquals(cartPage.getEmptyCartMessage(), "You have no items in your shopping cart.");

		log.info("Add Discount Code - Step 11: Click 'here' to continue shopping");
		cartPage.clickOnHereLink();
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_04_Purchase() {
		log.info("Purchase - Step 01: Click on Mobile menu link");
		homePage.clickOnMobileMenu();
		mobileProductPage = PageGeneratorManager.getUserMobileProductPage(driver);

		log.info("Purchase - Step 02: Add 'Sony Xperia' to cart");
		mobileProductPage.addProductToCart(PurchaseData.Product.PRODUCT_NAME);
		cartPage = PageGeneratorManager.getUserCartPage(driver);

		log.info("Purchase - Step 03: Verify add to cart success message");
		verifyEquals(cartPage.getAddToCartSuccessMessage(), "Sony Xperia was added to your shopping cart.");

		log.info("Purchase - Step 04: Verify Sony Xperia details displayed in cart");
		verifyTrue(cartPage.isProductImageDisplayedOnCartTable("Sony Xperia"));
		verifyTrue(cartPage.isProductNameDisplayedOnCartTable("Sony Xperia"));
		verifyEquals(cartPage.getProductPriceOnCartTable("Sony Xperia"), PurchaseData.Product.PRODUCT_PRICE);
		verifyEquals(cartPage.getProductQuantityOnCartTable("Sony Xperia"), PurchaseData.Product.PRODUCT_QTY);
		verifyEquals(cartPage.getProductSubtotalOnCartTable("Sony Xperia"), PurchaseData.Order.ORDER_SUBTOTAL);

		log.info("Purchase - Step 05: Verify SubTotal and Grand total");
		verifyEquals(cartPage.getCartSubtotal(), PurchaseData.Order.ORDER_SUBTOTAL);
		verifyEquals(cartPage.getCartGrandtotal(), PurchaseData.Order.ORDER_SUBTOTAL);

		log.info("Purchase - Step 06: Click 'Proceed to checkout' button");
		cartPage.clickProceedToCheckoutButton();
		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);

		log.info("Purchase - Step 07: Login");
		checkoutPage.inputEmailTextbox(UserData.Login.USER_EMAIL);
		checkoutPage.inputPasswordTextbox(UserData.Login.USER_PASSWORD);
		checkoutPage.clickLoginButton();

		log.info("Purchase - Step 08:Verify 'Billing Information' displayed as checkout step title");
		verifyEquals(checkoutPage.getCheckoutStepTitle(), "BILLING INFORMATION");

		log.info("Purchase - Step 09: Select 'New Address' on Billing address dropdown");
		checkoutPage.selectBillingAddress("New Address");

		log.info("Purchase - Step 09: Verify User firstname & last name");
		verifyEquals(checkoutPage.getUserFirstName("value"), UserData.Account_Info.USER_FIRSTNAME);
		verifyEquals(checkoutPage.getUserLastName("value"), UserData.Account_Info.USER_LASTNAME);

		log.info("Purchase - Step 10: Enter user address with value '" + PurchaseData.BillingAddress.ADDRESS + "'");
		checkoutPage.inputUserAddress(PurchaseData.BillingAddress.ADDRESS);

		log.info("Purchase - Step 11: Enter City with value '" + PurchaseData.BillingAddress.CITY + "'");
		checkoutPage.inputCity(PurchaseData.BillingAddress.CITY);

		log.info("Purchase - Step 12: Select State dropdown with value '" + PurchaseData.BillingAddress.STATE + "'");
		checkoutPage.selectStateDropdown(PurchaseData.BillingAddress.STATE);

		log.info("Purchase - Step 13: Enter ZIP textbox with value '" + PurchaseData.BillingAddress.ZIP + "'");
		checkoutPage.inputZIP(PurchaseData.BillingAddress.ZIP);

		log.info("Purchase - Step 14: Select Country dropdown with value '" + PurchaseData.BillingAddress.COUNTRY + "'");
		checkoutPage.selectCountryDropdown(PurchaseData.BillingAddress.COUNTRY);

		log.info("Purchase - Step 15: Enter Telephone textbox with value '" + PurchaseData.BillingAddress.TELEPHONE + "'");
		checkoutPage.inputTelephone(PurchaseData.BillingAddress.TELEPHONE);

		log.info("Purchase - Step 16: Click on 'Ship to this address' radio button");
		checkoutPage.clickShipToThisAddressRadio();

		log.info("Purchase - Step 17: Click 'Continue' button");
		checkoutPage.clickBillingContinueButton();
		

		log.info("Purchase - Step 18: Verify Shipping method & Flat rate equals '" + PurchaseData.Order.FLAT_RATE + "'");
		verifyEquals(checkoutPage.getShippingMethod(), "Flat Rate");
		verifyEquals(checkoutPage.getFlatRate(), PurchaseData.Order.FLAT_RATE);

		log.info("Purchase - Step 19: Click 'Continue' button");
		checkoutPage.clickShippingContinueButton();

		log.info("Purchase - Step 20: Select 'Check/Money order' radio button");
		checkoutPage.selectCheckMoneyOrderRadio();

		log.info("Purchase - Step 21: Click 'Continue' button");
		checkoutPage.clickPaymentContinueButton();

		log.info("Purchase - Step 22: Verify product details under Order review");
		verifyEquals(checkoutPage.getProductNameInOrderReview(), PurchaseData.Product.PRODUCT_NAME.toUpperCase());
		verifyEquals(checkoutPage.getProductPriceInOrderReview(), PurchaseData.Product.PRODUCT_PRICE);
		verifyEquals(checkoutPage.getProductQTYInOrderReview(), PurchaseData.Product.PRODUCT_QTY);

		log.info("Purchase - Step 23: Verify Subtotal, Flat rate, Grand total under Order review");
		verifyEquals(checkoutPage.getOrderSubtotalInOrderReview(), PurchaseData.Order.ORDER_SUBTOTAL);
		verifyEquals(checkoutPage.getShippingRateInOrderReview(), PurchaseData.Order.FLAT_RATE);
		verifyEquals(checkoutPage.getGrandTotalInOrderReview(), PurchaseData.Order.GRAND_TOTAL);

		log.info("Purchase - Step 24: Click 'Place Order' button");
		checkoutPage.clickPlaceOrderButton();

		log.info("Purchase - Step 25: Verify order received message displayed on page tittle");
		verifyEquals(checkoutPage.getOrderSuccessPageTitleMessage(), "YOUR ORDER HAS BEEN RECEIVED.");

		log.info("Purchase - Step 26: Verify order ID was generated");
		verifyTrue(checkoutPage.isOrderIDGenerated());

	}

	UserLoginPO loginPage;
	UserHomePO homePage;
	UserMobileProductPO mobileProductPage;
	UserCartPO cartPage;
	UserCheckoutPO checkoutPage;

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
