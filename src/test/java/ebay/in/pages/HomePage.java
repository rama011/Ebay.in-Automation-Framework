package ebay.in.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import ebay.in.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(id = "gh-la")
	private WebElement ebayLogo;

	@FindBy(linkText = "Sign in")
	private WebElement signinButton;

	@FindBy(id = "gh-cart-i")
	private WebElement viewCartIcon;

	@FindBy(id = "gh-shp-a")
	private WebElement shopCategoriesButton;

	@FindBy(id = "gh-ac")
	private WebElement searchBox;

	@FindBy(id = "gh-cat")
	private WebElement searchCategoriesDropdown;

	@FindBy(id = "gh-btn")
	private WebElement searchButton;

	@FindBy(xpath = "//ul[@class='hl-cat-nav__container']/li")
	List<WebElement> navbarOptions;
	
	@FindBy(xpath = "//ul[@class='carousel__list']/li[contains(@class,'hl-carousel__item') and contains(@class,'carousel__snap-point')]//h2")
	List<WebElement> carouselElementHeadings;
	
	@FindBy(xpath="//button[@aria-label='Go to next banner']")
	WebElement carouselNextButton;

	@FindBy(xpath = "//div[@id='destinations_list1']//ul[@class='hl-popular-destinations-elements']/descendant::li//h3[@class='hl-popular-destinations-name']")
	List<WebElement> popularDestinationsOptionsList;

	@FindBy(xpath = "//div[@id='items_list1']//ul[@class='carousel__list']/li[position()=1]")
	WebElement dailyDealsList;

	public void clickOnEbayLogo() {
		ebayLogo.click();
	}

	public SigninPage clickOnSigninButton() {
		signinButton.click();
		return new SigninPage();
	}

	public void clickOnViewCartIcon() {
		viewCartIcon.click();
	}

	public void verifyTitle() throws WebDriverException, IOException {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
		if (expectedTitle.equals(actualTitle)) {
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "Expected Title same as Actual Title");
		} else {
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "Expected Title not same as Actual Title");
			getScreenshot();
		}
	}

	public void verifyNavbarElement(String navbarOption) {
		List<String> navbarTextList = new ArrayList();
		for (WebElement navbarElement : navbarOptions) {
			navbarTextList.add(navbarElement.getText());
		}
		if (navbarTextList.contains(navbarOption)) {
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "Navbar heading " + navbarOption + " present on navbar");
		} else {
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "Navbar heading " + navbarOption + " not present on navbar");
		}
	}
	
	public void verifyCarouselHeadings(String carouselHeading) {
		List<String> carouselTextList = new ArrayList();
		Actions a = new Actions(driver);
		//System.out.println(carouselElementHeadings.size());
		for (WebElement carouselElement: carouselElementHeadings) {
			carouselTextList.add(carouselElement.getText());
			a.moveToElement(carouselElement).build().perform();
			System.out.println(this.carouselNextButton.isEnabled());
			this.carouselNextButton.click();
		}
		if (carouselTextList.contains(carouselHeading)) {
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "Carousel heading " + carouselHeading + " present on navbar");
		} else {
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "Carousel heading " + carouselHeading + " not present on navbar");
		}
	}
	public SearchPage searchProduct(String product) {
		ebayLogo.click();
		System.out.println(searchBox.isDisplayed());
		searchBox.clear();
		searchBox.sendKeys(product);
		searchButton.click();
		return new SearchPage();
	}

	public SearchPage searchProductByCategory(String product, String category) {
		searchBox.clear();
		searchBox.sendKeys(product);
		Select s = new Select(searchCategoriesDropdown);
		s.selectByVisibleText(category);
		searchButton.click();
		return new SearchPage();
	}

	public OfferPage selectOfferFromCarousel() {
		// WebElement carouselOffers =
		// driver.findElement(By.className("ul.carousel__list"));
		List<WebElement> carouselOffers = driver.findElements(
				By.xpath("//ul[@class='carousel__list']/li[@class='carousel__snap-point hl-carousel__item']//h2"));
		System.out.println("Carousel Offers Count: " + carouselOffers.size());
		for (WebElement carouselOffer : carouselOffers) {
			w.until(ExpectedConditions
					.visibilityOf(carouselOffer.findElement(By.xpath("//span[contains(text(),'Fashion')]")))).click();
			break;
		}
		return new OfferPage();
	}

	public CategoryPage selectCategoryFromPopularDestinations(String category) {
		for (WebElement popularDestinationOption : popularDestinationsOptionsList) {
			String optionHeading = popularDestinationOption.getText();
			System.out.println("Option Name: " + optionHeading);
			if (optionHeading.contains(category)) {
				popularDestinationOption.click();
				break;
			}
		}
		return new CategoryPage();
	}

	public void selectDailyDeal() {
		js.executeScript("window.scrollBy(0,700)");
		// w.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[position()=1]"))).click();
		dailyDealsList.click();
	}

	public HomePage() {
		System.out.println("Inside Home Page Constructor....");
		PageFactory.initElements(driver, this);
	}

}
