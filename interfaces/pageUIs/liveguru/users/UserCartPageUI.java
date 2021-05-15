package pageUIs.liveguru.users;

public class UserCartPageUI {
	public static final String ADD_TO_CART_SUCCESS_MESSAGE = "//li[@class='success-msg']//span";
	public static final String CART_GRAND_TOTAL = "//strong[text()='Grand Total']/parent::td/following-sibling::td//span";
	public static final String CART_SUB_TOTAL = "//td[contains (text(), 'Subtotal')]/following-sibling::td/span";
	
	public static final String TRASH_CAN_BUTTON_MIX_BY_COLUMN_AND_ROW_INDEX="//table[@id='shopping-cart-table']//tr[%s]//td[%s]/a[@class='btn-remove btn-remove2']";
	public static final String PRODUCT_IMG_ON_CART_TABLE = "//td[@class='product-cart-image']//a[@class='product-image']//img[@alt='%s']";
	public static final String PRODUCT_NAME_ON_CART_TABLE = "//td[@class='product-cart-info']//h2[@class='product-name']/a[text()='%s']";
	public static final String PRODUCT_PRICE_ON_CART_TABLE = "//a[@title='%s']//parent::td/following-sibling::td[@class='product-cart-price']//span[@class='price']";
	public static final String PRODUCT_QTY_ON_CART_TABLE = "//a[@title='%s']//parent::td/following-sibling::td[@data-rwd-label='Qty']/input";
	public static final String PRODUCT_SUBTOTAL_ON_CART_TABLE = "//a[@title='%s']//parent::td/following-sibling::td[@data-rwd-label='Subtotal']//span[@class='price']";
	public static final String QTY_TEXTBOX_ON_CART_TABLE = "//a[@title='%s']/parent::td/following-sibling::td[@class='product-cart-actions']//input[@title='Qty']";
	public static final String UPDATE_BUTTON_ON_CART_TABLE = "//a[@title='%s']/parent::td/following-sibling::td[@class='product-cart-actions']//button[@name='update_cart_action']";
	public static final String QTY_ERROR_MESSAGE_ON_CART_TABLE = "//td[@class='product-cart-info']//a[text()='%s']/parent::h2/following-sibling::p[contains(text(), '* The maximum quantity allowed for purchase is 500.')]";
	
	public static final String DISCOUNT_CODE_TEXTBOX = "//input[@id='coupon_code']";
	public static final String APPLY_DISCOUNT_LINK = "//button[@title='Apply']";
	
	public static final String DISCOUNT_ON_CART_TABLE = "//td[contains(text(), 'Discount (%s)')]";
	public static final String DISCOUNT_AMOUNT_ON_CART_TABLE = "//td[contains(text(), 'Discount (%s)')]/following-sibling::td/span";
	
	public static final String EMPTY_CART_LINK = "//button[@id='empty_cart_button']";
	public static final String EMPTY_CART_PAGE_TITLE = "//div[@class='page-title']/h1";
	public static final String EMPTY_CART_MESSAGE = "//div[@class='cart-empty']/p";
	public static final String CLICK_HERE_TO_CONTINUE_SHOPPING_LINK = "//div[@class='cart-empty']//a[text()='here']";
	
	public static final String SELECT_COUNTRY_DROPDOWN = "//select[@id='country']";
	public static final String SELECT_STATE_DROPDOWN = "//select[@id='region_id']";
	public static final String ZIP_TEXTBOX = "//input[@id='postcode']";
	public static final String PROCEED_TO_CHECKOUT_BUTTON = "//div[@class='cart-totals']//button[@title='Proceed to Checkout']";
}