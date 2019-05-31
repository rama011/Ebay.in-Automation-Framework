package ebay.in.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ebay.in.base.BaseClass;
import ebay.in.pages.HomePage;
import ebay.in.pages.SigninPage;
public class SearchProductTests extends BaseClass {
	
	HomePage hp;
	
	public SearchProductTests() {
		//hp=new HomePage();
	}
	
	@BeforeTest
	public void setUpTest() {
		hp= new HomePage();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		hp.clickOnEbayLogo();
	}
	
	
	@Test(priority=0)
	public void simpleSearchProduct() {
		hp.searchProduct("iPhone 7");
	}
	
	@Test(priority=1)
	public void searchProductByCategory() {
		 hp.searchProductByCategory("Protien Powder ", "Health & Beauty");
	}
	
	@Test(priority=2)
	public void searchProductFromPopularDestinationsSection() {
		 hp.selectCategoryFromPopularDestinations("Computer");
		 hp.searchProduct("Wireless Mouse");
	}
	
	
}
