package ebay.in.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ebay.in.base.BaseClass;
import ebay.in.pages.HomePage;
import ebay.in.pages.ProductPage;
import ebay.in.pages.SearchPage;

public class HomePageTest extends BaseClass {
  private HomePage hp;
  private SearchPage sp;
  private ProductPage pp;
  @Test(priority = 0)
  public void testTitle() {
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test(priority = 4)	
  public void testProductSearch() {
	  sp = hp.searchProduct("iPhone 7");
	 // sp.applyAFilter("AT&T");
	  //sp.applyAFilter("iPhone 7");
	 pp= sp.selectAResult("Apple iPhone 7 - 128GB - Black (Unlocked)");
	 pp.enterQuantity("2");
	 pp.clickOnAddToCartButton();
  }
  
 /* @Test(priority = 3,dependsOnMethods = {"testSearchProductFromCarousel"})
  public void testProductSearhByCategory() {
	  hp.searchProductByCategory("Protien Powder ", "Health & Beauty");
  }
  
  @Test(priority=2)
  public void testSearchProductFromCarousel(){
  	  //driver.findElement(By.id("gh-la")).click();
	  hp.selectOfferFromCarousel();
	  hp.searchProduct("Cargo");
  }
  
  @Test(priority =1)
  public void testSearchProductByPopularDestinations() {
	  hp.selectCategoryFromPopularDestinations();
	  hp.searchProduct("Wireless Mouse");
  }
  
  @Test(priority = 5)
  public void testSelectDailyDeal() {
	  hp.selectDailyDeal();
  }
  */
  @BeforeMethod
  public void beforeMethod() {
	  driver.findElement(By.id("gh-la")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test.....");
	  initialization();
  }
  
  @AfterTest
  public void afterTest() {
	  System.out.println("After Test.....");
	  //driver.close();
  }
  @BeforeClass
  public void beforeClass() {
	  //initialization();
	  hp = new HomePage();
  }

  @AfterClass
  public void afterClass() {
	 // driver.close();
  }

}
