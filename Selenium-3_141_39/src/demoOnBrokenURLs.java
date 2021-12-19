import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

// Demo on Broken links and soft assertions

public class demoOnBrokenURLs {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> webElementLinks = chromeDriver.findElements(By.xpath("//li[@class='gf-li']/a"));
		int responseCode = 0;
		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < webElementLinks.size(); i++) {
			WebElement webElement = webElementLinks.get(i);
			String url = webElement.getAttribute("href");

			HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
			httpConnection.setRequestMethod("HEAD");
			httpConnection.connect();
			responseCode = httpConnection.getResponseCode();
			System.out.println(responseCode);
			softAssert.assertTrue(responseCode<400,  " " + url  + " link has been broken.");
		}
		softAssert.assertAll();
		chromeDriver.close();
	}
}