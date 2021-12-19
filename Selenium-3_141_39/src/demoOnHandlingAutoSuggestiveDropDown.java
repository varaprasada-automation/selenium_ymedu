import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class demoOnHandlingAutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.makemytrip.com/");
		
		// Thread.sleep(5000);
		/*
		WebElement we = chromeDriver.findElement(By.id("fromCity"));
		JavascriptExecutor jse = (JavascriptExecutor)chromeDriver;
		jse.executeScript("arguments[0].click()", we);
		*/
		
		// Thread.sleep(1000);
		// chromeDriver.findElement(By.id("fromCity")).click();
		// Thread.sleep(1000);
		chromeDriver.findElement(By.id("fromCity")).sendKeys("HYDERABAD");
		Thread.sleep(1000);
		chromeDriver.findElement(By.cssSelector("input.react-autosuggest__input.react-autosuggest__input--open")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		chromeDriver.findElement(By.cssSelector("input.react-autosuggest__input.react-autosuggest__input--open")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		chromeDriver.findElement(By.cssSelector("#toCity")).sendKeys("MUMBAI");
		Thread.sleep(1000);
		// input.react-autosuggest__input.react-autosuggest__input--open
		// input.react-autosuggest__input.react-autosuggest__input--open
		
		chromeDriver.findElement(By.cssSelector("input.react-autosuggest__input.react-autosuggest__input--open")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		chromeDriver.findElement(By.cssSelector("input.react-autosuggest__input.react-autosuggest__input--open")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
	}
}