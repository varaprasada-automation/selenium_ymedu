
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demoExplicitWaitFluentWait {

	// This demo achieving explicit wait through Fluent Wait

	/*
	 * 
	 * There is another explicit wait mechanism type called Flent wait
	 * 
	 * Explicit wait can be achieved 2 ways
	 * 
	 * 1. WebDriverWait 2. Fluentwait
	 * 
	 * Fluent wait finds the web element repeatedly at regular intervals of time
	 * until the timeout or till the object gets found. Unlike WebDriver wait, we
	 * need to build customized wait methods based on condition.
	 * 
	 * 
	 * Both WebDriverWait and FluentWait classes implement wait interface.
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		// div[@id='start']/button

		chromeDriver.findElement(By.cssSelector("[id='start'] button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(chromeDriver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			
		     public WebElement apply(WebDriver driver) {
		    	 if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
		    		 return driver.findElement(By.cssSelector("[id='finish'] h4"));
		    	 } else {
		    		return null;
		    	 }
		     }
		     
		   });		
		System.out.println(chromeDriver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
	}
}