package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver launchBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.err.println("Invalid Browser name");
			throw new WebDriverException();
		}
		return driver;
	}
	
	 public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	  }
	
     public static void implicitWait(long sec) {
 		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
      }
     
     public static void sendKeys(WebElement e, String val) {
    	 e.sendKeys(val);
     }
     
     public static void click(WebElement e) {
    	 e.click();
     }
     
     public static void quitBrowser() {
    	 driver.quit();
     }
     
     public static String getCurrentUrl() {
    	 return driver.getCurrentUrl();
     }
     
     public static String getTitle() {
    	 return driver.getTitle();
     }
     
     public static String getText(WebElement e) {
    	 return e.getText();
     }
     
     public static String getAttribute(WebElement e) {
    	 return e.getAttribute("value");
     }
     
     public static void moveToElement(WebElement target) {
    	 Actions a = new Actions(driver);
    	 a.moveToElement(target).perform();
     }
     
     public static void draANdDrop(WebElement source, WebElement target) {
    	 Actions a = new Actions(driver);
    	 a.dragAndDrop(source, target).perform();
     }
     
     public static void selectByIndex(WebElement element, int index) {
    	 Select s = new Select(element);
    	 s.selectByIndex(index);
     }
     
     public static WebElement findElement(String locator, String locValue) {
    	 WebElement e= null;
    	 if(locator.equals("id")) {
    		  e = driver.findElement(By.id(locValue));
    		 }
    	 if(locator.equals("name")) {
    		  e = driver.findElement(By.name(locValue));
    		 }
    	 if(locator.equals("Xpath")) {
    		  e = driver.findElement(By.xpath(locValue));
    		 }
		return e;
     }
     
     
     
     
}
