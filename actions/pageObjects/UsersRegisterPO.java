package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.users.UsersRegisterPageUI;

public class UsersRegisterPO extends AbstractPage {
	WebDriver driver;
	
	public UsersRegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRegisterButton() {
		waitToElementClickable(driver, UsersRegisterPageUI.REGISTER_BUTTON);
		clickOnElement(driver, UsersRegisterPageUI.REGISTER_BUTTON);
	}
	
	public Object getRequiredErrorMessageAtFirstNameField(String firstNameField) {
		waitToElementVisible(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, firstNameField);
		return getElementText(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, firstNameField);
	}

	public Object getRequiredErrorMessageAtLastNameField(String lastNameField) {
		waitToElementVisible(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, lastNameField);
		return getElementText(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, lastNameField);
	}

	public Object getRequiredErrorMessageAtEmailAddressField(String emailField) {
		waitToElementVisible(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, emailField);
		return getElementText(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, emailField);
	}

	public Object getRequiredErrorMessageAtPasswordField(String passwordField) {
		waitToElementVisible(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, passwordField);
		return getElementText(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, passwordField);
	}

	public Object getRequiredErrorMessageAtConfirmPasswordField(String confirmPasswordField) {
		waitToElementVisible(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, confirmPasswordField);
		return getElementText(driver, UsersRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE, confirmPasswordField);
	}

	public void inputFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, UsersRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UsersRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void inputLastNameTextbox(String lastName) {
		waitToElementVisible(driver, UsersRegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UsersRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void inputEmailTextbox(String email) {
		waitToElementVisible(driver, UsersRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UsersRegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPasswordTextbox(String password) {
		waitToElementVisible(driver, UsersRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UsersRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputConfirmPasswordTextbox(String password) {
		waitToElementVisible(driver, UsersRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UsersRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void selectSignupNewsletterCheckbox() {
		waitToElementClickable(driver, UsersRegisterPageUI.SIGNUP_NEWSLETTER_CHECKBOX);
		checkCheckbox(driver, UsersRegisterPageUI.SIGNUP_NEWSLETTER_CHECKBOX);
		
	}

	public Object getValidationErrorMessageAtEmailAddressField(String emailField) {
		waitToElementVisible(driver, UsersRegisterPageUI.DYNAMIC_VALIDATION_ERROR_MESSAGE, emailField);
		return getElementText(driver, UsersRegisterPageUI.DYNAMIC_VALIDATION_ERROR_MESSAGE, emailField);
	}

	public Object getValidationErrorMessageAtPasswordField(String passwordField) {
		waitToElementVisible(driver, UsersRegisterPageUI.DYNAMIC_VALIDATION_ERROR_MESSAGE, passwordField);
		return getElementText(driver, UsersRegisterPageUI.DYNAMIC_VALIDATION_ERROR_MESSAGE, passwordField);
	}

	public Object getValidationErrorMessageAtConfirmPasswordField(String confirmPasswordField) {
		waitToElementVisible(driver, UsersRegisterPageUI.DYNAMIC_VALIDATION_ERROR_MESSAGE, confirmPasswordField);
		return getElementText(driver, UsersRegisterPageUI.DYNAMIC_VALIDATION_ERROR_MESSAGE, confirmPasswordField);
	}
	
}
