package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.CommonOperations;

public class SearchResultPage extends CommonOperations {
	
	@FindBy(xpath="//img[@alt='Coursera']")
	WebElement LandingPageIcon;
	
	@FindBy(css="div[id='react-select-2--value'] div[class='Select-placeholder']")
	WebElement expandLanguage;
	
	@FindBy(xpath="//input[@value='English']")
	WebElement selectEnglish;
	
	@FindBy(xpath="//div[contains(text(),'Level')]")
	WebElement expandLevel;
	
	@FindBy(xpath="//input[@value='Beginner']")
	WebElement selectLevel;
	
	@FindBy(xpath="//h2[normalize-space()='Introduction to Web Development']")
	WebElement courseOnename;
	
	@FindBy(xpath="//div[@aria-label='Introduction to Web Development']//div//span[@class='ratings-text'][normalize-space()='4.7']")
	WebElement courseOneRating;
	
	@FindBy(xpath="//h2[normalize-space()='Create a Resume and Cover Letter with Google Docs']")
	WebElement courseTwoname;
	
	@FindBy(xpath="//div[@aria-label='Create a Resume and Cover Letter with Google Docs']//div//span[@class='ratings-text'][normalize-space()='4.7']")
	WebElement courseTwoRating;
	
	
	
	public void extractCourse() {
		
		WebDriverWait wait = new WebDriverWait(driver , 30);
		wait.until(ExpectedConditions.visibilityOf(expandLanguage));
		expandLanguage.click();
		selectEnglish.click();
		
		wait.until(ExpectedConditions.visibilityOf(expandLanguage));
		expandLevel.click();
		selectLevel.click();
	
		
		String nameCourseOne= courseOnename.getText();
		System.out.println("Name of first course is : "+nameCourseOne);
		
		String ratingCourseOne=courseOneRating.getText();
		System.out.println("Rating of first course is "+ratingCourseOne);
		
		String nameCourseTwo = courseTwoname.getText();
		System.out.println("Name of Second course is : "+nameCourseTwo);
		
		String ratingeCourseTwo = courseTwoRating.getText();
		System.out.println("Rating of Second course is "+ratingeCourseTwo);
	}
	
	
	
	public LandingPage goToHomePage() {
		LandingPageIcon.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	

}
