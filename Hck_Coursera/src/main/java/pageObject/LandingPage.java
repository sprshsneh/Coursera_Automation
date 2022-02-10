package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import baseClasses.CommonOperations;


public class LandingPage extends CommonOperations {

	@FindBy(className = "react-autosuggest__input")
	WebElement searchBar;

	@FindBy(xpath = "//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']")
	WebElement searchBtn;

	@FindBy(className = "_r3zeoj")
	WebElement explore;

	@FindBy(id = "language-learning~menu-item")
	WebElement languageLearning;

	@FindBy(xpath = "//div[@class='_etry8c active']//a[@class='_1j0zwhtj rc-SimpleGoalItem'][normalize-space()='Free courses']")
	WebElement freeCourses;

	@FindBy(xpath = "//a[@id='enterprise-link']")
	WebElement forEnterpriseBtn;

	public SearchResultPage searchCourse() {
		searchBar.sendKeys("web development courses");
		searchBtn.click();
		return PageFactory.initElements(driver, SearchResultPage.class);
	}

	public FreeLanguageLearning clickFreeCourses() {
		mouseHover(explore);
		scrollTo(languageLearning);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(languageLearning));
		//mouseHover(languageLearning);
		languageLearning.click();
		wait.until(ExpectedConditions.elementToBeClickable(freeCourses));
		freeCourses.click();
		return PageFactory.initElements(driver, FreeLanguageLearning.class);
	}
	
	public ProductsForEnterprise clickForEnterprise() {
		forEnterpriseBtn.click();
		return PageFactory.initElements(driver, ProductsForEnterprise.class);
		
	}

}
