package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
    public LoginPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@FindBy(id = "user_email")
    public static WebElement emailInput;

    @FindBy(id = "user_password")
    public static WebElement passwordInput;
	
    @FindBy(name = "commit")
    public static WebElement signInButton;
    
	public static void signInWithEmailAndPassword(String email, String pass) {
		emailInput.clear();
		passwordInput.clear();		
		if(email != "") {
			emailInput.sendKeys(email);	
		}		
		if(pass != "") {
			passwordInput.sendKeys(pass);
		}
		
		signInButton.click();		
	}


}
