package ebay.in.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ebay.in.base.BaseClass;

public class ProductPage extends BaseClass {
	
	private Select select;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="msku-sel-1")
	private WebElement colorSelectDropdown;
	
	@FindBy(id="msku-sel-2")
	private WebElement storageSelectDropdown;
	
	@FindBy(id="msku-sel-3")
	private WebElement conditionSelectDropdown;
	
	@FindBy(id="qtyTextBox")
	private WebElement quantityTextBox;
	
	@FindBy(id="binBtn_btn")
	private WebElement buyProductButton;
	
	@FindBy(id="isCartBtn_btn")
	private WebElement addToCartButton;
	
	public void selectColorFromDropdown(String color) {
		select = new Select(colorSelectDropdown);
		select.selectByVisibleText(color);
	}
	
	public void selectStorageFromDropdown(String storage) {
		select = new Select(storageSelectDropdown);
		select.selectByVisibleText(storage);
	}
	
	public void selectConditionFromDropdown(String condition) {
		select = new Select(conditionSelectDropdown);
		select.selectByVisibleText(condition);
	}
	
	public void enterQuantity(String qty) {
		
		if(quantityTextBox.isDisplayed()) {
			quantityTextBox.clear();
			quantityTextBox.sendKeys(qty);
		}
		
	}
	
	public void clickOnBuyNowButton() {
		buyProductButton.click();
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

}
