import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class demoAutoSelectDropDown {

	public static void main(String[] args) throws InterruptedException {

		// If you want to convert id to css use # in-front of id
		// If you want to convert class to css use . in-front of class and replace
		// spaces with dots...

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		Thread.sleep(3000);
		chromeDriver.findElement(By.cssSelector("input[id=ctl00_mainContent_rbtnl_Trip_1]")).click();

		// #3. Handling Dynamic Drop downs
		Thread.sleep(3000);
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("BOM");

		// In case drop down contains multiple values with same values then use index as
		// follows...
		// chromeDriver.findElement(By.xpath("(//input[@id='ctl00_mainContent_ddl_originStation1_CTXT'])[2]")).sendKeys("BOM");
		Thread.sleep(3000);
		// chromeDriver.findElement(By.id("input.ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("BOM");
		chromeDriver.findElement(By.xpath("//input[contains(@id, '_destinationStation1_CTXT')]")).sendKeys("HYD");

		// chromeDriver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).sendKeys("HYD");
		Thread.sleep(1000);

		// css way of selecting calendar date
		// chromeDriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		// xpath way of selecting calendar date
		chromeDriver.findElement(By.xpath("//a[contains(@class, 'ui-state-highlight')]")).click();
		
		
		
		// return date selection in calendar date
		if(!chromeDriver.findElement(By.className("picker-second")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
			System.out.println("... Round Trip Is Enabled ...");
		}
	}
}
