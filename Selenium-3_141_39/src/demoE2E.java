import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class demoE2E {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// 1. selection of radio button
		Thread.sleep(3000);
		//chromeDriver.findElement(By.cssSelector("input[id=ctl00_mainContent_rbtnl_Trip_1]")).click();
		chromeDriver.findElement(By.cssSelector("input[id=ctl00_mainContent_rbtnl_Trip_0]")).click();
		
		// 2. Handling Dynamic Drop downs
		Thread.sleep(1000);
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("BOM");

		// In case drop down contains multiple values with same values then use index as
		// follows...
		// chromeDriver.findElement(By.xpath("(//input[@id='ctl00_mainContent_ddl_originStation1_CTXT'])[2]")).sendKeys("BOM");
		Thread.sleep(1000);
		// chromeDriver.findElement(By.id("input.ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("BOM");
		chromeDriver.findElement(By.xpath("//input[contains(@id, '_destinationStation1_CTXT')]")).sendKeys("HYD");

		// chromeDriver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).sendKeys("HYD");
		Thread.sleep(1000);

		
		// 4. section of journey date from calendar
		// css way of selecting calendar date
		// chromeDriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		// xpath way of selecting calendar date
		Thread.sleep(1000);
		chromeDriver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();
		Thread.sleep(3000);
		// chromeDriver.findElement(By.xpath("//a[contains(@class, 'ui-state-highlight')]")).click();
		
		// 3. check boxes
				chromeDriver.findElement(By.xpath("//input[contains(@id,'chk_friendsandfamily')]")).click();

		
		// 5. To check return date calendar is enabled or not...
		// return date selection in calendar date
		if (!chromeDriver.findElement(By.className("picker-second")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(false);
			System.out.println("... Round Trip Is Enabled ...");
		}

		// 6. Number of passengers selection drop down
		chromeDriver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int i = 0;

		//System.out.println(" Before Click Operation : " + chromeDriver.findElement(By.id("divpaxinfo")).getText());

		while (i < 4) {
			chromeDriver.findElement(By.id("hrefIncAdt")).click();
			i++;
			Thread.sleep(1000);
		}

		chromeDriver.findElement(By.id("btnclosepaxoption")).click();

		//System.out.println(" After Click Operation : " + chromeDriver.findElement(By.id("divpaxinfo")).getText());
		
		// 7. Select currency
		WebElement selectStaticDropDown = chromeDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));		
		Select selectDropDown = new Select(selectStaticDropDown);
		selectDropDown.selectByVisibleText("USD");
		
		// 8. click the search button
		//chromeDriver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(5000);
		chromeDriver.findElement(By.cssSelector("input[value='Search']")).click();
		
		Thread.sleep(5000);
		chromeDriver.quit();

	}
}
