package ebay.in.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ebay.in.base.BaseClass;

public class SearchPage extends BaseClass {
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='srp-river-results']//li[@class='s-item   ']//h3[@class='s-item__title']")
	private List<WebElement> searchResultsListElements;
	
	//Side Panel Elements for 
	@FindBy(xpath="//ul[contains(@class,'x-refine__left__nav')]/child::li//div[@class='x-refine__multi-select ']")
	private List<WebElement> filterOptions;
	
	public ProductPage selectAResult(String searchResult) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(WebElement searchResultsListElement : searchResultsListElements ) {
			if(searchResultsListElement.getText().equals(searchResult)) {
				searchResultsListElement.click();
				break;
			}else {
				js.executeScript("window.scrollBy(0,200)");
			}
		}
		return new ProductPage();
	}
	
	public void applyAFilter(String filterBy) {
		System.out.println("Filter Apply...."+filterBy);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(WebElement filterOption: filterOptions) {
			System.out.println("Text: "+ filterOption.getText());
			if(filterOption.getText().contains(filterBy)) {
				filterOption.click();
				break;
			}else {
				js.executeScript("window.scrollBy(0,200)");
			}
		}
	}
	
	
}
