package pageUIs.liveguru.users;

public class UsersMobileProductPageUI {
	public static final String DYNAMIC_PRODUCT_COST_BY_PRODUCT_NAME = "//a[@title='%s']/parent::h2[@class='product-name']//following-sibling::div//span[@class='price']";
	
	public static final String DYNAMIC_ADD_TO_CART_BUTTON = "//a[@title='%s']/parent::h2//following-sibling::div[@class='actions']/button[@title='Add to Cart']";
	public static final String CONTINUE_SHOPPING_LINK = "//button[@title='Continue Shopping']";
}
