import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");

		Thread.sleep(9000);
		driver.findElement(By.cssSelector("input[name='travel_date']")).click();

		while (!driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).getText()
				.equalsIgnoreCase("January 2022")) {
			driver.findElement(By.cssSelector(".datepicker-days .next")).click();
		}
		
		// driver.findElement(By.cssSelector(".datepicker-days
		// .datepicker-switch")).click();

		List<WebElement> days = driver.findElements(By.cssSelector(".day"));

		int i = 0;
		while (!days.get(i).getText().equals("1")) {
			++i;
		}

		for (int j = i; j <= days.size() - i; j++) {
			if (driver.findElements(By.cssSelector(".day")).get(j).getText().equals("26")) {
				driver.findElements(By.cssSelector(".day")).get(j).click();
				break;
			}
		}
	}
}
