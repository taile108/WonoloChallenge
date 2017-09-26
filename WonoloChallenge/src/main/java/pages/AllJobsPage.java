package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.CommonActions;

public class AllJobsPage extends BasePage{
	
    public AllJobsPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@FindBy(xpath = ".//*[@id='list_view']//a[contains(text(),'Last')]")
    public static WebElement lastButton;

	public static void goToLastPage(WebDriver driver) {
		if (CommonActions.isElementEnabled(driver, lastButton)) {
			lastButton.click();			
		}
	}
	
	public static void viewJobDetails(WebDriver webDriver, String jobName) {
		String xpath = ".//table/tbody/tr[td[contains(text(), '" + jobName + "')]]//span[@class='request_action_new_icon icon icon-list']";
			WebElement e = webDriver.findElement(By.xpath(xpath));
			e.click();
	}


}
