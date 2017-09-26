package NewJob;

import static org.junit.Assert.*;
import static util.ReadFileData.getTestData;

import java.net.MalformedURLException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import config.WebDriverFactory;
import pages.ActiveJobsPage;
import pages.AllJobsPage;
import pages.JobDetailsPage;
import pages.LoginPage;
import pages.MenuItemsPage;
import pages.NewJobPage;
import util.CommonFunctions;

public class NewJobTests extends WebDriverFactory {
	Properties dataFactory;

	String currentTime = CommonFunctions.getCurrentTime();

	String emailValid, passWordValid;
	String jobName, category, tasks, requirement, comDescription, travelTips, arrInstructions, numWonolers;
	String venue, address, city, zip;
	String startTime, esHour, esMin;
	String pay;
	String confirmPost;

	private void getTestDataOfNewJob() {
		dataFactory = getTestData("CreateJobTests/CreateJobTests.properties");

		emailValid = dataFactory.getProperty("emailValid");
		passWordValid = dataFactory.getProperty("passWordValid");

		jobName = dataFactory.getProperty("jobName") + " " + currentTime;
		category = dataFactory.getProperty("category");
		tasks = dataFactory.getProperty("tasks");
		requirement = dataFactory.getProperty("requirement");
		comDescription = dataFactory.getProperty("comDescription");
		travelTips = dataFactory.getProperty("travelTips");
		arrInstructions = dataFactory.getProperty("arrInstructions");
		numWonolers = dataFactory.getProperty("numWonolers");

		venue = dataFactory.getProperty("venue");
		address = dataFactory.getProperty("address");
		city = dataFactory.getProperty("city");
		zip = dataFactory.getProperty("zip");

		startTime = dataFactory.getProperty("startTime");
		esHour = dataFactory.getProperty("esHour");
		esMin = dataFactory.getProperty("esMin");

		pay = dataFactory.getProperty("pay");

		confirmPost = dataFactory.getProperty("confirmPost");

	}

	@BeforeClass
	public static void setup() throws MalformedURLException {
		PageFactory.initElements(webDriver, LoginPage.class);
		PageFactory.initElements(webDriver, ActiveJobsPage.class);
		PageFactory.initElements(webDriver, MenuItemsPage.class);
		PageFactory.initElements(webDriver, NewJobPage.class);
		PageFactory.initElements(webDriver, AllJobsPage.class);

	}

	@Test()
	public void verifyUserPostJobWithFullValidInformations() throws InterruptedException {

		getTestDataOfNewJob();

		LoginPage.signInWithEmailAndPassword(emailValid, passWordValid);
		Thread.sleep(10000);
		MenuItemsPage.selectJobs();
		ActiveJobsPage.clickOnNewJob();

		NewJobPage.fillWhatValues(jobName, category, tasks, requirement, comDescription, travelTips, arrInstructions,
				numWonolers);
		NewJobPage.fillWhereValues(venue, address, city, zip);
		NewJobPage.fillWhenValues(startTime, esHour, esMin);
		NewJobPage.fillPayValues(pay);

		NewJobPage.clickOnPostJob(webDriver);

		MenuItemsPage.selectAllJobs(webDriver);
		AllJobsPage.goToLastPage(webDriver);
		AllJobsPage.viewJobDetails(webDriver, jobName);
		
		Assert.assertTrue(JobDetailsPage.verifyJobDetails(webDriver, jobName, category, pay));

	}

	@Test() public void test_02() throws InterruptedException {
		System.out.println("Example for a test PASSED");
		assertTrue(true);
	}

	@Test() public void test_03() throws InterruptedException {
		System.out.println("Example for a test FAILED");
		assertTrue(false);
	}
	

	@Test() public void test_04() throws InterruptedException {
		System.out.println("Example for a test PASSED");
		assertTrue(true);
	}
	
	

}
