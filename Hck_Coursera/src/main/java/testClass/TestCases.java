package testClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import pageObject.FreeLanguageLearning;
import pageObject.LandingPage;
import pageObject.ProductsForEnterprise;
import pageObject.SearchResultPage;
import pageObject.TransformUniversity;
import utilities.ExtentReportManager;




public class TestCases {
	
	ExtentReports rt = ExtentReportManager.getReport();
	ExtentTest logger;
	
	PageBaseClass pc;
	LandingPage lp;
	FreeLanguageLearning flgp;
	ProductsForEnterprise pfe;
	TransformUniversity tu;

	@BeforeSuite
	public void openBrowser() {
		pc= new PageBaseClass();
		pc.invokeBrowser();
		lp = pc.loadPage();
	}
		
		@Test(priority=0 , groups = { "Sanity", "Reggression" })
	public void extractCourseDetails() {
	    logger = rt.createTest("Capturing and Displaying all the information of Top 2 Courses");
		SearchResultPage srp = lp.searchCourse();
		logger.log(Status.PASS, "Course is searched in searc bar successfully");
		srp.extractCourse();
		logger.log(Status.PASS, "Course details are captured ");
		lp=srp.goToHomePage();	
		logger.log(Status.PASS, "Test passed");
	}
	
		@Test(priority =1, groups = { "Sanity", "Reggression" })
		public void extractAllLanguages() {
			logger = rt.createTest("Capturing and Displaying all the languages with count ");
			flgp=lp.clickFreeCourses();
			logger.log(Status.PASS, "Selecting free courses");
			flgp.extractLanguages();
			logger.log(Status.PASS, "Extracting all the languages");
			lp=flgp.navigateToHomePage();
			logger.log(Status.PASS, "Test is passed ");
		}
	
		@Test(priority = 2, groups = { "Sanity", "Reggression" })
		public void captureErrorEnterprise() {
			logger = rt.createTest("Capturing and Displaying Errors");
			pfe = lp.clickForEnterprise();
			logger.log(Status.PASS, "Clicking on Enterprise ");
			tu= pfe.clickForCampus();
			logger.log(Status.PASS, "Selecting for Campus from product dropdown ");
			tu.clickgetStarted();
			logger.log(Status.PASS, "Test is passed ");
			
		}

		@AfterSuite
		public void closeBrowser() {
			tu.closeBrowser();
			rt.flush();
		}
}
