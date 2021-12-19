import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *    By.xath("//a[text()='test2 test2]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"))
 *    preceding-sibling   following-sibling::div
 *    forward-sibling
 *    parent
 *    descendant
 */

public class demoOnGoogleSearch {
	public static void main(String[] args) throws InterruptedException {

		String searchString = "testing tools list";

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.google.com/");

		chromeDriver.findElement(By.xpath("//input[@title='Search']")).sendKeys("testing tools");

		Thread.sleep(10000);
		List<WebElement> suggestionList = chromeDriver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));

		System.out.println("Size : " + suggestionList.size());

		for (int i = 0; i < suggestionList.size(); i++) {
			System.out.println(suggestionList.get(i).getText());
			if (searchString.equals(suggestionList.get(i).getText().trim())) {
				System.out.println("Search Found");
				break;
			}
		}
		Thread.sleep(5000);
		chromeDriver.quit();
	}
}
