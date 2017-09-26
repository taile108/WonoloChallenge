package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActiveJobsPage extends BasePage{
	
    public ActiveJobsPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@FindBy(id = "new_request_button")
    public static WebElement newJob;
	

	public static void clickOnNewJob() {		
		newJob.click();		
	}
    
	
}
