import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// input date validation is not handled by this logic ...

public class demoOnCalendarJS {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.spicejet.com/");
		String fromDate = "20-10-2021";
		// Thread.sleep(10000);

		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();

		chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement fromDateField = chromeDriver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
		CalenderUtil(chromeDriver, fromDateField, fromDate);
	}

	public static void CalenderUtil(WebDriver driver, WebElement element, String date) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
	}
}
