package baseClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LandingPage;
import utilities.ReadPropertiesFile;

public class PageBaseClass {
public static WebDriver driver;
	
	ReadPropertiesFile rf = new ReadPropertiesFile(System.getProperty("user.dir")+"\\configuration.properties");
	public void invokeBrowser() {
			
		
		try {
			 
			if (rf.getBrowser().equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
	    		ChromeOptions options = new ChromeOptions();
	    		options.addArguments("start-maximized");
	    		options.addArguments("--disable-blink-features=AutomationControlled");
	    		options.addArguments("--disable-notifications");
	    		driver = new ChromeDriver(options);	
			} else if (rf.getBrowser().equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
	    		FirefoxOptions options = new FirefoxOptions();
	    		options.addArguments("start-maximized");
	    		options.addArguments("--disable-blink-features=AutomationControlled");
	    		options.addArguments("--disable-notifications");
	    		driver = new FirefoxDriver(options);
			} else {
				WebDriverManager.operadriver().setup();
				OperaOptions options = new OperaOptions();
				options.addArguments("start-maximized");
	    		options.addArguments("--disable-blink-features=AutomationControlled");
	    		options.addArguments("--disable-notifications");
				driver = new OperaDriver();
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public LandingPage loadPage() {
		driver.get(rf.getUrl());
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	

}
