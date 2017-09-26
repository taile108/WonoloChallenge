package pages;

import org.openqa.selenium.WebDriver;


public abstract class BasePage {

	protected WebDriver webDriver;

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public abstract boolean isDisplayed(WebDriver driver);

}
