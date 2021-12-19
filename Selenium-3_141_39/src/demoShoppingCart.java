import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoShoppingCart {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] requiredProducts = { "Cucumber", "Brocolli", "Beetroot" };
		Thread.sleep(4000);
		List<WebElement> availableProducts = chromeDriver.findElements(By.cssSelector("h4.product-name"));
		List requiredProductsList = Arrays.asList(requiredProducts);
		// int k = 3;
		int j = 0;
		for (int i = 0; i < availableProducts.size(); i++) {
			String availableProduct = availableProducts.get(i).getText();
			availableProduct = availableProduct.split("-")[0].trim();
			// System.out.println(availableProduct);
			if (requiredProductsList.contains(availableProduct)) {
				/*
				 * logic to select the item more than once ... if
				 * (availableProduct.equals("Cucumber")) { for (int l = 0; l < 1; l++) { String
				 * o = "//div[@class='products']/div[" + k +
				 * "]/div[@class='stepper-input']/a[2]";
				 * chromeDriver.findElement(By.xpath(o)).click(); } }
				 * 
				 */
				chromeDriver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == requiredProducts.length) {
					break;
				}
			}
		}
	}
}
