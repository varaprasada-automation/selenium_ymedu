import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Difference between implicit & explicit wait
 * 
 * 
 * 			  	Implicit :
 * 							Pros 	: 	Readable Code
 * 							Cons	:	Performance issues may occur
 * 
 * 				Explicit :
 * 							Pros	:	Wait is applied only at targeted elements. So no performance issues.
 * 							Cons	:	More Code
 * 
 */

public class demoExplicitWaitWebDriverWait {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] requiredProducts = { "Cucumber", "Brocolli", "Beetroot" };

		// Explicit wait is used to target specific element...
		WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, 5);
		addProducts(chromeDriver, requiredProducts);
		chromeDriver.findElement(By.xpath("//img[@alt='Cart']")).click();
		chromeDriver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		chromeDriver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		chromeDriver.findElement(By.cssSelector("button.promoBtn")).click();
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(chromeDriver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public static void addProducts(WebDriver chromeDriver, String[] requiredProducts) {
		List<WebElement> availableProducts = chromeDriver.findElements(By.cssSelector("h4.product-name"));
		List requiredProductsList = Arrays.asList(requiredProducts);
		int j = 0;
		for (int i = 0; i < availableProducts.size(); i++) {
			String availableProduct = availableProducts.get(i).getText();
			availableProduct = availableProduct.split("-")[0].trim();
			if (requiredProductsList.contains(availableProduct)) {
				chromeDriver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == requiredProducts.length) {
					break;
				}
			}
		}
	}
}