package pageUIs.liveguru.users;

public class UserCheckoutPageUI {
	public static final String USER_EMAIL_TEXTBOX = "//input[@id='login-email']";
	public static final String USER_PASSWORD_TEXTBOX = "//input[@id='login-password']";
	public static final String LOGIN_BUTTON = "//button[@onclick='onepageLogin(this)']";
	
	public static final String CHECKOUT_STEP_TITLE = "//div[@class='step-title']/span[text() = '1']/following-sibling::h2";
	public static final String BILLING_ADDRESS_DROPDOWN = "//select[@id='billing-address-select']";
	public static final String BILLING_FIRSTNAME_TEXTBOX = "//input[@id='billing:firstname']";
	public static final String BILLING_LASTNAME_TEXTBOX = "//input[@id='billing:lastname']";
	public static final String BILLING_ADDRESS_TEXTBOX = "//input[@id='billing:street1']";
	public static final String BILLING_CITY_TEXTBOX = "//input[@id='billing:city']";
	public static final String BILLING_STATE_DROPDOWN = "//select[@id='billing:region_id']";
	public static final String BILLING_ZIP_TEXTBOX = "//input[@id='billing:postcode']";
	public static final String BILLING_COUNTRY_DROPDOWN = "//select[@id='billing:country_id']";
	public static final String BILLING_TELEPHONE_TEXTBOX = "//input[@id='billing:telephone']";
	public static final String BILLING_CONTINUE_BUTTON = "//div[@id='billing-buttons-container']//button[@title='Continue']";
	public static final String SHIP_TO_THIS_ADDRESS_RADIO_BUTTON = "//input[@id='billing:use_for_shipping_yes']";
	
	public static final String SHIPPING_METHOD = "//div[@id='checkout-shipping-method-load']//dt";
	public static final String FLAT_RATE = "//label[@for='s_method_flatrate_flatrate']/span";
	public static final String SHIPPING_CONTINUE_BUTTON = "//div[@id='shipping-method-buttons-container']/button//span[text()='Continue']";
	
	
	public static final String CHECK_MONEY_ORDER_RADIO_BUTTON = "//input[@title='Check / Money order']";
	public static final String PAYMENT_CONTINUE_BUTTON = "//div[@id='payment-buttons-container']/button//span[text()='Continue']";
	
	public static final String ORDER_REVIEW_PRODUCT_NAME = "//table[@id='checkout-review-table']//h3";
	public static final String ORDER_REVIEW_PRODUCT_PRICE = "//table[@id='checkout-review-table']//td[@data-rwd-label = 'Price']//span[@class='price']";
	public static final String ORDER_REVIEW_PRODUCT_QTY = "//table[@id='checkout-review-table']//td[@data-rwd-label = 'Qty']";
	public static final String ORDER_REVIEW_SUBTOTAL = "//table[@id='checkout-review-table']//td[contains(text(), 'Subtotal')]/following-sibling::td/span[@class='price']";
	public static final String ORDER_REVIEW_SHIPPING_RATE = "//table[@id='checkout-review-table']//td[contains(text(), 'Shipping & Handling (Flat Rate - Fixed)')]/following-sibling::td/span[@class='price']";
	public static final String ORDER_REVIEW_GRAND_TOTAL = "//table[@id='checkout-review-table']//strong[text()='Grand Total']/parent::td/following-sibling::td//span[@class='price']";
	
	public static final String PLACE_ORDER_BUTTON = "//button[@title='Place Order']";
	
	public static final String CHECKOUT_SUCCESS_PAGE_TITLE = "//body[@class=' checkout-onepage-success']//div[@class='page-title']/h1";
	public static final String ORDER_ID_LINK = "//p[text()='Your order # is: ']/a[contains(@href, 'order_id')]";
	
}
