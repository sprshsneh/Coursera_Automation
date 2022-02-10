package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	public static ExtentReports rt;

	public static ExtentReports getReport() {
		if (rt == null) {
			String reportName = DateUtil.getTimeStamp();
			ExtentSparkReporter reporter = new ExtentSparkReporter(
					System.getProperty("user.dir") + "\\ExtentReports\\" + reportName + ".html");
			rt = new ExtentReports();
			rt.attachReporter(reporter);
			reporter.config().setReportName("Test Report");
		}
		return rt;

	}
}
