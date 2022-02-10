package baseClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonOperations extends PageBaseClass{

	public void scrollTo(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void mouseHover(WebElement hoverOnElement) {
		Actions action = new Actions(driver);
		action.moveToElement(hoverOnElement).build().perform();
	}
	
	public static void DropDown(WebElement dropdown, String valueToBeSeleceted) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(valueToBeSeleceted);
	
	}
	
	public static WebDriverWait waitSetup() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		return wait;
	}


	}

