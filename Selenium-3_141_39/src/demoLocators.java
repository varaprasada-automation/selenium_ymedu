import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoLocators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
				
		//chromeDriver.get("https://www.facebook.com/");
		//chromeDriver.get("https://www.udemy.com/");
		chromeDriver.get("http://login.yahoo.com/");
		/*
		 * Locators can be identified in following ways
		 * 			ID
		 * 			Name
		 * 			className
		 * 			name
		 * 			linkText
		 * 			xpath
		 * 			css		 * 
		 * 
		 * 
		 * 
		 * Customized xPath/CSS generation Techniques:
		 * 
		 * 				standard pattern
		 * 				tagName traverse
		 * 				regular expressions
		 */
		
		
		
		// chromeDriver.findElement(By.className("signin")).click();
		// By using x-path
		//chromeDriver.findElement(By.xpath("//*[@id='email']")).sendKeys("varaprasada.kovvuri");
 		//chromeDriver.findElement(By.xpath("//*[@id='pass']")).sendKeys("varaprasada.kovvuri"); 		
		
		/*		  
		 
		// x-path
		chromeDriver.findElement(By.xpath("//*[@id='email']")).sendKeys("987654321");
		
		// cssSelector
		chromeDriver.findElement(By.cssSelector("#pass")).sendKeys("0000000");
		
		
		//chromeDriver.findElement(By.name("login")).click();
		chromeDriver.findElement(By.linkText("Forgotten password?")).click();
 		System.out.println(chromeDriver.getTitle());
	
		*/
		
		
		// chromeDriver.findElement(By.xpath("//*[@id='udemy']/div[2]/div[1]/div[3]/div[6]/a")).click();
		
		chromeDriver.findElement(By.cssSelector("#login-username")).sendKeys("varaprasada.kovvuri");
		chromeDriver.findElement(By.xpath("//*[@id=\'login-signin\']")).click();
		Thread.sleep(2000);
		System.out.println(chromeDriver.findElement(By.xpath("//*[@id='username-error']")).getText());
		
		// chromeDriver.close();
		
		
	}

}
