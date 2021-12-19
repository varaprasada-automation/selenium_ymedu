import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoWindowAlerts {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String Name = "Vara";
		chromeDriver.findElement(By.id("name")).sendKeys(Name);		
		chromeDriver.findElement(By.cssSelector("input[value='Alert']")).click();
		System.out.println(chromeDriver.switchTo().alert().getText());
		Thread.sleep(2000);
		chromeDriver.switchTo().alert().accept();
		
		chromeDriver.findElement(By.id("name")).sendKeys(Name);
		chromeDriver.findElement(By.id("confirmbtn")).click();
		System.out.println(chromeDriver.switchTo().alert().getText());
		Thread.sleep(2000);
		chromeDriver.switchTo().alert().dismiss();
		
		
		chromeDriver.quit();
	}
}
