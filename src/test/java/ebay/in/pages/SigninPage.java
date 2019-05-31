package ebay.in.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ebay.in.base.BaseClass;

public class SigninPage extends BaseClass {
	public SigninPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userid")
	private WebElement signInId;
	
	@FindBy(id="pass")
	private WebElement signInPassword;
	
	@FindBy(id="sgnBt")
	private WebElement signInButton;
	
	public HomePage signIn(String username,String password) {
		signInId.sendKeys(username);
		signInPassword.sendKeys(password);
		signInButton.click();
		return new HomePage();
	}
}
