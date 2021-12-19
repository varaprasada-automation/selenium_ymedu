import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoRegExCustomLocators {

	public static void main(String[] args) throws InterruptedException {
		
		
		/*
		 * Regular expressions:
		 * 
		 * 								x-path:
		 * 										//tagname[contains(@attribute, 'value')]
		 *								css	  :
		 *										  tagname[attribute*='value']
		 */
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("https://www.rediff.com/");
		
		Thread.sleep(5000);		
		//chromeDriver.findElement(By.xpath("//a[contains(@title, 'Sign in')]")).click();
		chromeDriver.findElement(By.cssSelector("a[title*='Sign in']")).click();	
		Thread.sleep(2000);
		
		/*
		chromeDriver.findElement(By.xpath("//input[contains(@id, 'login')]")).sendKeys("varaprasadsa.kovvuri");
		chromeDriver.findElement(By.xpath("//input[contains(@name, 'passwd')]")).sendKeys("12345678");
		chromeDriver.findElement(By.xpath("//input[contains(@value, 'Sign in')]")).click();
		*/
		
		chromeDriver.findElement(By.cssSelector("input[id*='login']")).sendKeys("varaprasadsa.kovvuri");
		chromeDriver.findElement(By.cssSelector("input[name*='passwd']")).sendKeys("12345678");
		chromeDriver.findElement(By.cssSelector("input[value*='Sign in']")).click();
			
	}

}
