package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.CommonActions;

public class JobDetailsPage extends BasePage {

	public JobDetailsPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}


	public static boolean verifyJobDetails(WebDriver webDriver, String jobName, String category, String pay) {
		int countFalse = 0;
		String strFailedCases = "";

		if (!jobName.equals("") && jobName != null) {
			String xpath = "//td[contains(text(), 'Job name')]/following-sibling::td[contains(text(),'" + jobName + "')]";
			if (!CommonActions.isElementDisplayedBy(webDriver, By.xpath(xpath))) {
				countFalse = countFalse + 1;
				strFailedCases = strFailedCases + "Job Name; ";
			}
		}		

		if (!category.equals("") && category != null) {
			String xpath = "//td[contains(text(), 'Category')]/following-sibling::td[contains(text(),'" + category + "')]";
			if (!CommonActions.isElementDisplayedBy(webDriver, By.xpath(xpath))) {
				countFalse = countFalse + 1;
				strFailedCases = strFailedCases + "Category; ";
			}
		}

		if (!pay.equals("") && pay != null) {
			String xpath = "//td[contains(text(), 'Pay')]/following-sibling::td[contains(text(),'" + pay + "')]";
			if (!CommonActions.isElementDisplayedBy(webDriver, By.xpath(xpath))) {
				countFalse = countFalse + 1;
				strFailedCases = strFailedCases + "Pay; ";
			}
		}		
		
        if (countFalse > 0) {
            return false;
        } else {
            return true;
        }
	}

}
