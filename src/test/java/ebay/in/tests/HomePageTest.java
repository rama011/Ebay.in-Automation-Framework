package ebay.in.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ebay.in.base.BaseClass;
import ebay.in.pages.HomePage;
import ebay.in.pages.ProductPage;
import ebay.in.pages.SearchPage;

public class HomePageTest extends BaseClass {
	// private HomePage hp;
	private SearchPage sp;
	private ProductPage pp;
	String[] navBarElementsArray = new String[] { "Home", "Saved", "Electronics", "Fashion", "Health & Beauty",
			"Motors", "Collectibles", "Sports", "Home & Garden", "Deals", "Under $10", "" };
	String[] carouselElementsHeadingsArray = new String[] {"Deals Under $10",
			"Your Favourites for Less",
			"Fashion"};

	@BeforeMethod
	public void beforeMethod() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
		if (!actualTitle.equals(expectedTitle)) {
			hp.clickOnEbayLogo();
		}
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test.....");
	}

	@Test(priority = 0)
	public void testTitle() throws WebDriverException, IOException {
		hp.verifyTitle();
	}

	@Test(priority = 1, dependsOnMethods = { "testTitle" })
	public void verifyNavBarElements() {
		for(String element:navBarElementsArray) {
			hp.verifyNavbarElement(element);
		}
	}
	
	@Test(priority = 2, dependsOnMethods = { "testTitle" })
	public void verifyCarouselElements() {
		//hp.verifyCarouselHeadings("Test");
		for(String element:carouselElementsHeadingsArray) {
			hp.verifyCarouselHeadings(element);
		}
	}

	@Test(priority = 4, enabled = false)
	public void testProductSearch() {
		sp = hp.searchProduct("iPhone 7");
		// sp.applyAFilter("AT&T");
		// sp.applyAFilter("iPhone 7");
		pp = sp.selectAResult("Apple iPhone 7 - 128GB - Black (Unlocked)");
		pp.enterQuantity("2");
		pp.clickOnAddToCartButton();
	}

	/*
	 * @Test(priority = 3,dependsOnMethods = {"testSearchProductFromCarousel"})
	 * public void testProductSearhByCategory() {
	 * hp.searchProductByCategory("Protien Powder ", "Health & Beauty"); }
	 * 
	 * @Test(priority=2) public void testSearchProductFromCarousel(){
	 * //driver.findElement(By.id("gh-la")).click(); hp.selectOfferFromCarousel();
	 * hp.searchProduct("Cargo"); }
	 * 
	 * @Test(priority =1) public void testSearchProductByPopularDestinations() {
	 * hp.selectCategoryFromPopularDestinations();
	 * hp.searchProduct("Wireless Mouse"); }
	 * 
	 * @Test(priority = 5) public void testSelectDailyDeal() { hp.selectDailyDeal();
	 * }
	 */

	@AfterTest
	public void afterTest() {
		System.out.println("After Test.....");
		report.endTest(test);
		report.flush();
		// driver.close();
	}

}
