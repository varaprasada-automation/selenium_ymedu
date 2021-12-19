import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class demoCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// By Name selector
		// chromeDriver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
		
		/*
		Thread.sleep(3000);
		// By CSS selector reg-ex]
		System.out.println(chromeDriver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		chromeDriver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).click();
		System.out.println(chromeDriver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		*/
		
		Thread.sleep(3000);
		// By x-path selector reg-ex		
		//System.out.println(chromeDriver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		chromeDriver.findElement(By.xpath("//input[contains(@id,'chk_friendsandfamily')]")).click();
		//System.out.println(chromeDriver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		
		Assert.assertEquals(chromeDriver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected(), true);
		Assert.assertTrue(chromeDriver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		Assert.assertFalse(!chromeDriver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		
		/*
		Thread.sleep(3000);
		// x-path with out reg-ex
		chromeDriver.findElement(By.xpath("//div[contains(@id, 'discount-checkbox')]//input[@type='checkbox']"));
		System.out.println(chromeDriver.findElement(By.xpath("//div[contains(@id, 'discount-checkbox')]//input[@type='checkbox']")).getSize());
		*/
		
		Thread.sleep(3000);
		// css selector with out reg-ex
		chromeDriver.findElement(By.cssSelector("div[id*='discount-checkbox'] input[type*='checkbox']"));
		//System.out.println(chromeDriver.findElement(By.cssSelector("div[id*='discount-checkbox'] input[type*='checkbox']")).getSize());
				
		
		
		Thread.sleep(2000);
		
		
		
		chromeDriver.quit();
	}
}
