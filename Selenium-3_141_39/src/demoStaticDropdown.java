import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class demoStaticDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();		
		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// #1. Static Drop Downs		
		
		/*
		WebElement selectStaticDropDown = chromeDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				
		Select selectDropDown = new Select(selectStaticDropDown);
		selectDropDown.selectByIndex(3);
		Thread.sleep(3000);
		System.out.println("First Selected Option : " + selectDropDown.getFirstSelectedOption().getText());
		selectDropDown.selectByValue("INR");
		Thread.sleep(3000);
		System.out.println("Second Selected Option : " + selectDropDown.getFirstSelectedOption().getText());
		selectDropDown.selectByVisibleText("AED");
		Thread.sleep(3000);
		System.out.println("Third Selected Option : " + selectDropDown.getFirstSelectedOption().getText());
		
		chromeDriver.quit();
		
		*/
		// #2. Another type of Static Drop Downs
		
		/*
		
		chromeDriver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		int i=0;
		
		System.out.println(" Before Click Operation : " + chromeDriver.findElement(By.id("divpaxinfo")).getText());
		
		while(i<4) {
			chromeDriver.findElement(By.id("hrefIncAdt")).click();
			i++;
			Thread.sleep(1000);
		}
		
		chromeDriver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(" After Click Operation : " + chromeDriver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(2000);
		chromeDriver.quit();
		
		*/
		
		// #3. Handling Dynamic Drop downs
		Thread.sleep(3000);
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("BOM");
		
		// In case drop down contains multiple values with same values then use index as follows...
		// chromeDriver.findElement(By.xpath("(//input[@id='ctl00_mainContent_ddl_originStation1_CTXT'])[2]")).sendKeys("BOM");
		Thread.sleep(3000);
		//chromeDriver.findElement(By.id("input.ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("BOM");		
		chromeDriver.findElement(By.xpath("//input[contains(@id, '_destinationStation1_CTXT')]")).sendKeys("HYD");
		
		//chromeDriver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).sendKeys("HYD");
		Thread.sleep(1000);
		
		chromeDriver.quit();
	}
}