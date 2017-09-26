package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonActions {


    public static void selectByValue(WebElement element, String value) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

	
	public static void mouseOver(WebDriver webDriver, WebElement element) {
		Actions action = new Actions(webDriver);		 
        action.moveToElement(element).build().perform();		
	}
	
    public static void clearAndSendKeys(WebElement element, String key) {
    	element.clear();
    	element.sendKeys(key);
    }
	
    public static boolean isElementEnabled(WebDriver driver, WebElement element) {
        try {
            if (element.isEnabled()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementExist(WebDriver driver, WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (Exception e) {
            System.out.println("Could not found element: " + element);
            return false;
        }
    }
    

    public static boolean isElementDisplayedBy(WebDriver driver, By by) {
        try {
            WebElement element = driver.findElement(by);
            if (element.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    
}
