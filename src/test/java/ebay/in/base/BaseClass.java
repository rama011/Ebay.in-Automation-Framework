package ebay.in.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import ebay.in.pages.HomePage;
import ebay.in.pages.SigninPage;

public class BaseClass {
	public static WebDriver driver;
	public static Properties props;
	public static WebDriverWait w ;
	public static JavascriptExecutor js;
	protected HomePage hp;
	SigninPage sp;
	
	
	public static void readPropertiesFile() {
		try {
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\Rama\\eclipse-workspace\\ebay.in.test.automation.framework\\src\\test\\java\\config.properties"));
			props = new Properties();
			props.load(fis);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static HomePage initialization() {
		// TODO Auto-generated method stub
		readPropertiesFile();
		
		System.out.println(props.getProperty("browser"));
		String browser = props.getProperty("browser");
		switch(browser) {
		case "chrome": System.setProperty(props.getProperty("browser_chrome_system_property"), props.getProperty("browser_chrome_path"));
						driver = new ChromeDriver();
						break;
		case "ie": System.setProperty(props.getProperty("browser_ie_system_property"), props.getProperty("browser_ie_path"));
					driver = new InternetExplorerDriver();
					break;
		default: break;
		}
		w = new WebDriverWait(driver,180);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.MINUTES);
		js=(JavascriptExecutor)driver;
		driver.get(props.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return new HomePage();
	}
	
	@BeforeSuite
	public void setUp() {
		System.out.println("Before Suite------>");
		hp=initialization();
		sp = hp.clickOnSigninButton();
		sp.signIn(props.getProperty("username"), props.getProperty("password"));
	}
	
	@AfterSuite
	public void tearDown() {
		System.out.println("After Suite------>");
		driver.quit();
	}
	
}
