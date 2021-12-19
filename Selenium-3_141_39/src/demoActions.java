import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demoActions {

	// To Handle Mouse & Key board interactions ... Actions class will be useful...

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.amazon.in/");

		Actions action = new Actions(chromeDriver);

		WebElement webElement = chromeDriver.findElement(By.cssSelector("a#nav-link-accountList"));

		// To move mouse to specific element
		action.moveToElement(webElement).build().perform();
		
		webElement = chromeDriver.findElement(By.cssSelector("form[name='site-search']"));
		// To type in Capital letters in search box and double click the search string ...
		action.moveToElement(webElement).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		
		Thread.sleep(3000);
		
		webElement = chromeDriver.findElement(By.cssSelector("a#nav-link-accountList"));
		// To right click on Sign-In window...
		action.moveToElement(webElement).contextClick().build().perform();
		
		
		Thread.sleep(3000);
		chromeDriver.quit();
	}
}
