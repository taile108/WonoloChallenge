package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.CommonActions;

public class NewJobPage extends BasePage {

	public NewJobPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@FindBy(id = "job_request_template_id")
	public static WebElement template;

	// WHAT
	@FindBy(id = "job_request_request_name")
	public static WebElement jobNameInput;

	@FindBy(id = "job_request_category")
	public static WebElement categorySelectBox;

	@FindBy(id = "job_request_description_tasks")
	public static WebElement taskToBePerformTextArea;

	@FindBy(xpath = ".//*[@id='what_section']//div[@class='jr_requirement']/input")
	public static WebElement requirement1Input;

	@FindBy(id = "job_request_description_company")
	public static WebElement companyDescriptionTextArea;

	@FindBy(id = "job_request_description_travel")
	public static WebElement travelTipsInput;

	@FindBy(id = "job_request_description_arrival")
	public static WebElement arrivalInstructionsInput;

	@FindBy(id = "job_request_slots")
	public static WebElement numberOfWonolersNeededInput;

	// WHERE
	@FindBy(id = "job_request_venue")
	public static WebElement venueInput;

	@FindBy(id = "job_request_address")
	public static WebElement addressInput;

	@FindBy(id = "job_request_city")
	public static WebElement cityInput;

	@FindBy(id = "job_request_zip")
	public static WebElement zipInput;

	// WHEN
	@FindBy(xpath = ".//*[@id='jri_job_form_start_time']/input")
	public static WebElement startTimeInput;

	@FindBy(id = "job_request_duration_hours")
	public static WebElement esHoursSelectBox;

	@FindBy(id = "job_request_duration_minutes")
	public static WebElement esMinsSelectBox;

	// PAY
	@FindBy(id = "job_request_wage")
	public static WebElement payInput;
	
	@FindBy(id = "post_job_button")
	public static WebElement postJobButton_1;
	
	@FindBy(id = "showing_fill_advisor_button")
	public static WebElement postJobButton_2;


	@FindBy(xpath = ".//a[@class='btn default_button'][contains(text(),'Cancel')]")
	public static WebElement cancelButton;

	@FindBy(xpath = ".//input[@value='Save as Draft']")
	public static WebElement saveAsDraftButton;

	// PLEASE CONFIRM
	@FindBy(id = "title-confirm-message")
	public static WebElement pleaseConfirmTitle;
	
	@FindBy(id = "accepted_advisor_button")
	public static WebElement postButton;
	
	@FindBy(id = "cancel_advisor_button")
	public static WebElement editJobButton;

	public static void fillWhatValues(String jobName, String category, String tasks, String requirement,
			String comDescription, String travelTips, String arrInstructions, String numWonolers) {

		if (!jobName.equals("")) {
			jobNameInput.sendKeys(jobName);
		}

		if (!category.equals("")) {
			CommonActions.selectByValue(categorySelectBox, category);
		}

		if (!tasks.equals("")) {
			taskToBePerformTextArea.sendKeys(tasks);
		}

		if (!requirement.equals("")) {
			requirement1Input.sendKeys(requirement);
		}

		if (!comDescription.equals("")) {
			companyDescriptionTextArea.sendKeys(comDescription);
		}

		if (!travelTips.equals("")) {
			travelTipsInput.sendKeys(travelTips);
		}

		if (!arrInstructions.equals("")) {
			arrivalInstructionsInput.sendKeys(arrInstructions);
		}

		if (!numWonolers.equals("")) {
			numberOfWonolersNeededInput.clear();
			numberOfWonolersNeededInput.sendKeys(numWonolers);
		}

	}

	public static void fillWhereValues(String venue, String address, String city, String zip) {

		if (!venue.equals("")) {
			venueInput.clear();
			venueInput.sendKeys(venue);
		}

		if (!address.equals("")) {
			addressInput.clear();
			addressInput.sendKeys(address);
		}

		if (!city.equals("")) {
			cityInput.clear();
			cityInput.sendKeys(city);
		}

		if (!zip.equals("")) {
			zipInput.clear();
			zipInput.sendKeys(zip);
		}

	}

	public static void fillWhenValues(String startTime, String esHour, String esMin) {

		if (!startTime.equals("")) {
			CommonActions.clearAndSendKeys(startTimeInput, startTime);
		}

		if (!esHour.equals("")) {
			CommonActions.selectByValue(esHoursSelectBox, esHour);
		}

		if (!esMin.equals("")) {
			CommonActions.selectByValue(esMinsSelectBox, esMin);
		}

	}

	public static void fillPayValues(String pay) {
		if (!pay.equals("")) {
			CommonActions.clearAndSendKeys(payInput, pay);
		}
	}

	public static void clickOnPostJob(WebDriver webDriver) {
		if (CommonActions.isElementEnabled(webDriver, postJobButton_1)) {
			postJobButton_1.click();
		} else {
			postJobButton_2.click();	
		}		
	}

	public static void clickOnCancel() {
		cancelButton.click();
	}

	public static void clickOnSaveAsDraft() {
		saveAsDraftButton.click();
	}
	

	public static void makePleaseConfirm(String confirm) {
		if (pleaseConfirmTitle.isEnabled()) {
			if (confirm == "YES") {
					postButton.click();
			}else
				editJobButton.click();			
		}
		

	}
	
}
