import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoAutoSuggestiveDropDowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		chromeDriver.findElement(By.id("autosuggest")).sendKeys("Fi");
		Thread.sleep(5000);

		/*
		 * By using CSS Selector
		 * 
		 * List<WebElement> countryNames = chromeDriver
		 * .findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		 *
		 */
		
		// By using X-Path

		List<WebElement> countryNames = chromeDriver
				.findElements(By.xpath("//li[@class='ui-menu-item']/a[@class='ui-corner-all']"));

		for (WebElement countryName : countryNames) {
			if (countryName.getText().equalsIgnoreCase("Finland")) {
				System.out.println(countryName);
				countryName.click();
				Thread.sleep(1000);
				chromeDriver.quit();
				break;
			}
		}
	}
}