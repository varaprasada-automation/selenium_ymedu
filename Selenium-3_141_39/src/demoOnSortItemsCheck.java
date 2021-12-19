import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class demoOnSortItemsCheck {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		Thread.sleep(2000);
		try {
			chromeDriver.findElement(By.cssSelector(".sort-icon.sort-ascending")).click();
		}catch(NoSuchElementException nsee) {
			chromeDriver.findElement(By.cssSelector(".sort-icon.sort-descending")).click();
		}
		
		List<WebElement> firstColumnItemsList = chromeDriver.findElements(By.cssSelector("tr td:nth-child(1)"));
		ArrayList<String> sortedList = new ArrayList<String>();
		ArrayList<String> originalList = new ArrayList<String>();

		for (int i = 0; i < firstColumnItemsList.size(); i++) {
			originalList.add(firstColumnItemsList.get(i).getText());
			sortedList.add(firstColumnItemsList.get(i).getText());
			System.out.println(firstColumnItemsList.get(i).getText());
		}

		Collections.sort(sortedList);
		for (String item : sortedList) {
			System.out.println(item);
		}
		Assert.assertEquals(originalList, sortedList);
		// sort-icon sort-descending
		Thread.sleep(2000);
		chromeDriver.close();
	}
}
