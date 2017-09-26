package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.CommonActions;

public class MenuItemsPage extends BasePage{
	
    public MenuItemsPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@FindBy(id = "nav-new-job")
    public static WebElement newJob;
	
	@FindBy(xpath = "//div/a[@href='/job_requests/active']")
    public static WebElement jobs;
	
	@FindBy(xpath= ".//*[@id='menu_jobs']//a[contains(text(),'All Jobs')]")
    public static WebElement allJobs;
	
	@FindBy(xpath = ".//*[@id='menu_jobs']//a[contains(text(),'Draft')]")
    public static WebElement draft;



    public static void waitForMenuItemsPage(WebDriver driver) {
//        WaitAction.waitForElementIsClickable(newJobLink);
    }
	
	
	public static void selectJobs() {		
		jobs.click();		
	}
    
	public static void selectNewJobs() {		
		newJob.click();		
	}
	
	public static void selectAllJobs(WebDriver driver) throws InterruptedException {	
		CommonActions.mouseOver(driver, jobs);
		Thread.sleep(2000);
		allJobs.click();		
	}

	
	public static void selectDraft(WebDriver driver) throws InterruptedException {	
		CommonActions.mouseOver(driver, jobs);
		Thread.sleep(2000);
		draft.click();		
	}
	
}
