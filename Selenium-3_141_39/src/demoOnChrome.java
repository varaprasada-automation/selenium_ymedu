import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoOnChrome {

	public static void main(String[] args) throws InterruptedException {
		// Step #1. Set the system property
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				
		// Step #2. Driver object has to create.
		
		// Property							browser
		//driver.chrome.driver 				chrome
		//driver.gecko.driver				firefox
		//dirver.ie.driver					ie
		
		WebDriver chromeDriver = new ChromeDriver();
		
		
		 
		 
		// chromeDriver.get("https://www.google.com/");
		// System.out.println(chromeDriver.getTitle());
			
		/*
		 
		// To validate are we landed on correct URL...		
		System.out.println(chromeDriver.getCurrentUrl());
		// To print the landing page source
		System.out.println(chromeDriver.getPageSource());
		
		chromeDriver.get("https://rediff.com");
		chromeDriver.navigate().back();	
		chromeDriver.navigate().forward();
		
		// To close the browser
		chromeDriver.close();   // closes current browser
		chromeDriver.quit();	// closes all browser windows opened by selenium script
	
		 */
		
		
		 
		chromeDriver.get("http://facebook.com");
		chromeDriver.findElement(By.id("email")).sendKeys("varaprasada.kovvuri@gmail.com");
		chromeDriver.findElement(By.name("pass")).sendKeys("varaprasada");
		Thread.sleep(2000);
		chromeDriver.findElement(By.linkText("Forgotten password?")).click();
		 
		
		/* if class name contains spaces then selenium doesn't recognize it ... you will get compound classes are not recognized in selenium */
		
		/*
		chromeDriver.findElement(By.className("")).sendKeys("");
		*/
		chromeDriver.close();
	}
	
}
