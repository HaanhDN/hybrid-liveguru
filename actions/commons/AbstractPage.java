package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.liveguru.users.UsersAbstractPageUI;

public class AbstractPage {
	
	public void openPageURL(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getCurrentPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	} 
	
	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	public void waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if(!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
		
	}
	
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentPageTitle = driver.getTitle();
			if(currentPageTitle.equals(title)) {
				break;
			}
		}
	}
	
	public void closeAllWindowExceptParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow : allWindows) {
			if(!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	} 
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	public void clickOnElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.click();
	}
	
	public void clickOnElement(WebDriver driver, String locator, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		element.click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element =  getElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value, String...values) {
		element =  getElement(driver, getDynamicLocator(locator, values));
		element.clear();
		element.sendKeys(value);
	}
	
	public void selectItemInDropdown (WebDriver driver, String locator, String itemValue) {
		element =  getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}
	
	public String getFirstSelectedTextInDropdown(WebDriver driver, String locator) {
		element =  getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple (WebDriver driver, String locator) {
		WebElement element =  getElement(driver, locator);
		Select select = new Select(element);
		return select.isMultiple();
	}
	
	public void  selectItemInCustomDropdown (WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
		
		List<WebElement> allItems = getElements(driver, childItemLocator);
		
		for(WebElement item:allItems) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
			sleepInSecond(1);
			
			item.click();
			sleepInSecond(1);
			break;		
			}
		}

	public String getElementAttribute (WebDriver driver, String locator, String attributeName) {
		WebElement element =  getElement(driver, locator);
		return element.getAttribute(attributeName);
	}
	
	public String getElementAttribute (WebDriver driver, String locator, String attributeName, String...values) {
		WebElement element =  getElement(driver, getDynamicLocator(locator, values));
		return element.getAttribute(attributeName);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		WebElement element =  getElement(driver, locator);
		return element.getText();
	}
	
	public String getElementText(WebDriver driver, String locator, String... values) {
		WebElement element =  getElement(driver, getDynamicLocator(locator, values));
		return element.getText();
	}
	
	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public void checkCheckbox(WebDriver driver, String locator) {
		WebElement element =  getElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckCheckbox(WebDriver driver, String locator) {
		element =  getElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver,locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...values) {
		return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator, String... values) {
		overrideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
		elements = getElements(driver, getDynamicLocator(locator, values));
		overrideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}
	public void overrideImplicitWait(WebDriver driver, long timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver,locator).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver,locator).isEnabled();
		}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void doubleClickElement(WebDriver driver, String locator) {
		action.doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickElement(WebDriver driver, String locator) {
		action.contextClick(getElement(driver, locator)).perform();
	}
	
	public void hoverMouseOnElement(WebDriver driver, String locator) {
		action.moveToElement(getElement(driver, locator)).perform();
	}
	
	public void clickAndHoldElement(WebDriver driver, String locator) {
		action.clickAndHold(getElement(driver, locator)).perform();
	}
	
	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}
	
	public void sendKeyBoardToElement (WebDriver driver, String locator, Keys key) {
		action.sendKeys(getElement(driver, locator), key).perform();
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentEleemnt.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String locator, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");

	}

	public void highlightElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeAsyncScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border:2px solid red");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		element = getElement(driver, locator);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		element = getElement(driver, locator);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth>0", element);
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitToElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitToElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitToElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		overrideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		overrideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);
	}

	public void waitToElementInvisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitToElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitToElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitToElementsPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitToElementNumberToBe(WebDriver driver, String locator, int number) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.numberOfElementsToBe(getByXpath(locator), number));
	}

	public String getDynamicLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public boolean waitForJQueryAndJSLoadedSuccess(WebDriver driver) {

		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	private void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//LiveGuru
	}
	
	public void openMenuPageByTitle(WebDriver driver, String itemValue) {
		waitToElementClickable(driver, UsersAbstractPageUI.DYNAMIC_ACCOUNT_MENU_LINK, itemValue);
		clickOnElement(driver, UsersAbstractPageUI.DYNAMIC_ACCOUNT_MENU_LINK, itemValue);
	}
	
	public void clickOnAccountMenu(WebDriver driver) {
		waitToElementClickable(driver, UsersAbstractPageUI.ACCOUNT_MENU);
		clickOnElement(driver, UsersAbstractPageUI.ACCOUNT_MENU);
	}
	
	public Object getUserAccountPageTitle(WebDriver driver) {
		waitToElementVisible(driver, UsersAbstractPageUI.MY_ACCOUNT_PAGE_TITLE);
		return getElementText(driver, UsersAbstractPageUI.MY_ACCOUNT_PAGE_TITLE);
	}
	public void openMyAccountMenuPageByName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, UsersAbstractPageUI.DYNAMIC_MY_ACCOUNT_MENU_PAGE, pageName);
		clickOnElement(driver, UsersAbstractPageUI.DYNAMIC_MY_ACCOUNT_MENU_PAGE, pageName);
	}
	public void openProductPageByTitle(WebDriver driver, String productTitle) {
		waitToElementVisible(driver, UsersAbstractPageUI.PRODUCT_TITLE, productTitle);
		clickOnElement(driver, UsersAbstractPageUI.PRODUCT_TITLE, productTitle);
	}
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private WebElement element;
	private List<WebElement> elements;
	private Actions action;
	private Select select;
	}


