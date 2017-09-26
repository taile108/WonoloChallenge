package config;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebDriverFactory {
	public static WebDriver webDriver;
	public static String baseURL = Constants.BASE_URL;
	public static String browserType = Constants.BROWSER_TYPE;
	
	private String fileExtentReports= Constants.EXTENT_REPOSTS_FILE;

	@BeforeClass
	public static void initWebDriver() throws MalformedURLException {

		if (Constants.BROWSER_TYPE.equalsIgnoreCase("firefox")) {
			System.out.println("Executing on FireFox");
			webDriver = new FirefoxDriver();
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

			webDriver.get(Constants.BASE_URL);
		} else if (Constants.BROWSER_TYPE.equalsIgnoreCase("chrome")) {
			System.out.println("Executing on CHROME");

		} else if (Constants.BROWSER_TYPE.equalsIgnoreCase("ie")) {
			System.out.println("Executing on IE");

		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@AfterClass
	public static void teardown() {
		if (webDriver != null) {
			webDriver.manage().deleteAllCookies();
			webDriver.quit();
		}
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	@Rule
	public final TestRule testRule = new TestWatcher() {
		
		@Override
		protected void failed(Throwable e, Description description) {
			ExtentReports exReport = createReport();
			ExtentTest exTest = exReport.startTest(description.getDisplayName());
			// step log
			exTest.log(LogStatus.FAIL, "Test FAILED");
			flushReports(exReport, exTest);
		}

		// When passed only write to the log.
		@Override
		protected void succeeded(Description description) {
			ExtentReports exReport = createReport();
			ExtentTest exTest = exReport.startTest(description.getDisplayName(), "-");
			// step log
			exTest.log(LogStatus.PASS, "Test PASSED");
			flushReports(exReport, exTest);
		}

		private ExtentReports createReport() {
			ExtentReports exReport = new ExtentReports(fileExtentReports, false);
			return exReport;
		}

		private void flushReports(ExtentReports exReport, ExtentTest exTest) {
			exReport.endTest(exTest);
			exReport.flush();
		}

		
		
	};


}