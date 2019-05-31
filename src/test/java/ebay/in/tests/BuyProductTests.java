package ebay.in.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ebay.in.base.BaseClass;
import ebay.in.pages.HomePage;
import ebay.in.pages.ProductPage;
import ebay.in.pages.SearchPage;
import ebay.in.pages.SigninPage;

public class BuyProductTests extends BaseClass {
	//HomePage hp;
	SearchPage sp;
	ProductPage pp;
	SigninPage sip;

	public BuyProductTests() {
		System.out.println("Inside BuyProductsTests constructor....");
	}

	@BeforeTest
	public void returnToHomePage() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
		if (!actualTitle.equals(expectedTitle)) {
			hp.clickOnEbayLogo();
		}
		hp = new HomePage();
	}

	@BeforeMethod
	public void returnToHome() {
		 String actualTitle = driver.getTitle();
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
		if (!actualTitle.equals(expectedTitle)) {
			hp.clickOnEbayLogo();
		}

	}

	@Test(priority = 1)
	public void buyProductAfterSimpleSearch() {
		sp=new SearchPage();
		hp.searchProduct("iPhone 7");
		// sp.applyAFilter("AT&T");
		// sp.applyAFilter("iPhone 7");
		pp = sp.selectAResult("Apple iPhone 7 128GB Unlocked");
		//pp.enterQuantity("2");
		pp.clickOnAddToCartButton();
	}

	@Test(enabled = true, priority = 2)
	public void buyProductAfterCategoryBasedSearch() {
		sp = hp.searchProductByCategory("Guitar", "Musical Instruments & Gear");
		//hp.searchProduct("Guitar");
		sp.applyAFilter("Gibson");
		sp.applyAFilter("Mahogany");
		pp = sp.selectAResult("Gibson Hummingbird Artist Acoustic/Electric Guitar");
		//pp.enterQuantity("1");
		pp.clickOnAddToCartButton();
	}

}
