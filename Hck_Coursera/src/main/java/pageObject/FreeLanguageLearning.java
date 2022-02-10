package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.CommonOperations;

public class FreeLanguageLearning extends CommonOperations{
	
	@FindBy(xpath="//*[@id=\"react-select-2--value\"]/div[1]")
	WebElement language;
	
	@FindBy(xpath="//*[@id=\"react-select-2--option-9\"]/div/button[2]")
	WebElement showAll;
	
	@FindBy(css="a[aria-label='close']")
	WebElement closePopup;
	
	@FindBy(css="img[alt='Coursera']")
	WebElement LandingPageBtn;
	
	public void extractLanguages() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(language));
		language.click();
		showAll.click();
		List<WebElement> listOfLanguage = driver.findElements(By.xpath("//div[@class='checkboxText']"));
        System.out.println("List Of Languages Available:-");
        for (int i = 0; i < listOfLanguage.size(); i++) {
			System.out.println(listOfLanguage.get(i).getText());
		}
        System.out.println("\nNo. of languages Available:"+listOfLanguage.size());
        
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[3]/div/div[3]/div[3]/a"));
        closeBtn.click();
        
        WebElement level = driver.findElement(By.xpath("//*[@id=\"react-select-3--value\"]/div[1]"));
        level.click();
        
        List<WebElement> levels = driver.findElements(By.xpath("//div[@class='checkboxText']"));
        System.out.println("\nList of levels:-");
        for (int i = 0; i < levels.size(); i++) {
			System.out.println(levels.get(i).getText());
		}
        System.out.println("\nNo. of levels Available:"+levels.size());
	}
	
	public LandingPage navigateToHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(LandingPageBtn));
		LandingPageBtn.click();
		driver.navigate().back();
		LandingPageBtn.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}

}
