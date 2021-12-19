import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoOnScopes {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// To count the number of links in the page
		System.out.println(
				"No. of hyperlinks available in this page : " + chromeDriver.findElements(By.cssSelector("a")).size());

		// To count the number of links available in footer

		WebElement footerDriver = chromeDriver.findElement(By.cssSelector("#gf-BIG"));
		System.out.println("No. of hyperlinks available in footer section of page : "
				+ footerDriver.findElements(By.cssSelector("a")).size());

		// To get the count of hyper links available in first column of footer section
		System.out.println("No. of hyperlinks available in first column of footer section : "
				+ (footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"))).findElements(By.tagName("a"))
						.size());

		System.out.println("No. of hyperlinks available in first column of footer section : "
				+ (footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"))).findElements(By.className("gf-li"))
						.size());

		System.out.println("No. of hyperlinks available in first column of footer section : "
				+ (footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"))).findElements(By.tagName("li"))
						.size());

		// To check links are opening or not...

		WebElement columnDriver = footerDriver.findElement(By.xpath(("//table/tbody/tr/td[1]/ul")));
		String linkClickKeys = Keys.chord(Keys.CONTROL, Keys.ENTER);

		for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(linkClickKeys);
			Thread.sleep(2000);
		}

		Set pageWindowsHandles = chromeDriver.getWindowHandles();
		Iterator<String> pageWindowsIterator = pageWindowsHandles.iterator();
		while (pageWindowsIterator.hasNext()) {
			chromeDriver.switchTo().window(pageWindowsIterator.next());
			chromeDriver.getTitle();
		}
		
		chromeDriver.close();
		//Thread.sleep(2000);
		//chromeDriver.quit();
	}
}