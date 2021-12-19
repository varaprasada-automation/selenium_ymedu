
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demoExplicitWaitAssignment {	
	
	// This demo achieving explicit wait through Web Driver Wait	
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
		WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, 5);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")));
		chromeDriver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));		
		System.out.println(chromeDriver.findElement(By.xpath("//div[@id='results']")).getText());
	}
}