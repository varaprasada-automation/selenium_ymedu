import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoParentChildXPathScopeLocator {

	public static void main(String[] args) throws InterruptedException {

		// In this example will restrict the search scope in the parent child relation ship to eliminate the use of indexes...
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();		
		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		Thread.sleep(3000);
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		Thread.sleep(1000);
		// With following statement it will try to search inside the source cities drop down scope only...
		chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		
		Thread.sleep(1000);
		// With following statement it will try to search inside the destination cities drop down scope only...
		chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
		
		Thread.sleep(1000);
		chromeDriver.quit();		
	}
}
