import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoImplicitWait {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] requiredProducts = { "Cucumber", "Brocolli", "Beetroot" };
		Thread.sleep(4000);
		
		// Implicit wait achieved with following statement ...
		// Implicit wait is global wait ... driver will wait for 5 sec's before failing ...
		chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		addProducts(chromeDriver, requiredProducts);
		
		chromeDriver.findElement(By.xpath("//img[@alt='Cart']")).click();		
		chromeDriver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Thread.sleep(5000);
		chromeDriver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");		
		chromeDriver.findElement(By.cssSelector("button.promoBtn")).click();		
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