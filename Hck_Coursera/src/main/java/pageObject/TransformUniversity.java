package pageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ReadExcelData;
import baseClasses.CommonOperations;

public class TransformUniversity extends CommonOperations {
	
	
	String arr[]=null;
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(id="LastName")
	WebElement lastName;
	
	@FindBy(id="C4C_Job_Title__c")
	WebElement jobFn;
	
	@FindBy(id="Title")
	WebElement jobTittle;
	
	@FindBy(id="Email")
	WebElement workEmailAddress;
	
	@FindBy(id="Phone")
	WebElement phoneNumber;
	
	@FindBy(id="Company")
	WebElement institutionName;
	
	@FindBy(id="Institution_Type__c")
	WebElement institutionType;
	
	@FindBy(id="Primary_Discipline__c")
	WebElement primaryDiscipline;
	
	@FindBy(id="Country")
	WebElement countryName; 
	
	@FindBy(className="mktoButton")
	WebElement submitBtn;
	
	@FindBy(id="ValidMsgEmail")
	WebElement errorMsg;
	
	public void clickgetStarted() {
		
		ReadExcelData dataReader = new ReadExcelData(System.getProperty("user.dir") + "\\testData\\coursera_testData.xlsx");
		arr=dataReader.getDataFromRow("TestSheet", 1);
		
		Set<String> handles = driver.getWindowHandles();
        Iterator<String> iter = handles.iterator();
        String mainPage = iter.next();
        String formPage = iter.next();
        driver.switchTo().window(formPage);
         System.out.println(mainPage);
		scrollTo(firstName);
		firstName.sendKeys(arr[0]);
		lastName.sendKeys(arr[1]);
		DropDown(jobFn, arr[2]);
		jobTittle.sendKeys(arr[3]);
		workEmailAddress.sendKeys(arr[4]);
		phoneNumber.sendKeys(arr[5]);
		institutionName.sendKeys(arr[6]);
		DropDown(institutionType,arr[7]);
		DropDown(primaryDiscipline,arr[8]);
		DropDown(countryName,arr[9]);
//		firstName.sendKeys("sibasis");
//		lastName.sendKeys("pradhan");
//		DropDown(jobFn, "Chancellor");
//		jobTittle.sendKeys("NA");
//		workEmailAddress.sendKeys("xyz");
//		phoneNumber.sendKeys("+917766881199");
//		institutionName.sendKeys("NA");
//		DropDown(institutionType,"Public University");
//		DropDown(primaryDiscipline,"Accounting");
//		DropDown(countryName,"Afghanistan");
		submitBtn.click();
		
		String msgError = errorMsg.getText();
		System.out.println("Error is :" +msgError);
	
		
	}

	public void closeBrowser() {
		driver.quit();
	}
}
