package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.CommonOperations;

public class ProductsForEnterprise extends CommonOperations {
	
	@FindBy(xpath="//a[normalize-space()='Products']")
	WebElement product;
	
	@FindBy(xpath="//a[@target='_blank'][normalize-space()='For Campus']")
	WebElement forCampus;
	
	public TransformUniversity clickForCampus() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(product));
		mouseHover(product);
		wait.until(ExpectedConditions.visibilityOf(forCampus));
		forCampus.click();
		return PageFactory.initElements(driver, TransformUniversity.class);
	}

}
