import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoCustomLocators {

	public static void main(String[] args) throws InterruptedException {
		
		
		/*
		 * Syntax for writing custom x-path : 	//tagname[@attribute='value']
		 * 											  (or)
		 * 										//*[@attribute='value']        --  Make sure the uniqueness of tag along with the combination of attribute...
		 * 											Eg: $x("//*[@title='Already a user? Sign in']");		 * 					
		 * 
		 * Syntax for writing custom css	:	  
		 * 											
		 * 										  [attribute='value']
		 * 											  (or)
		 * 										  tagname[attribute='value']   
		 * 											  (or) 
		 * 										  tagname#id value  (or)  #idname
		 *                                            (or) 
		 *                                        tagname.classnamevalue	(or)  .classname 
		 *                                        Note that in case class name value contains spaces then replace spaces with .  
		 *											  (or)
		 * Regular expressions:
		 * 
		 * 								x-path:
		 * 										//tagname[@contains(@attribute, 'value')]
		 *								css	  :
		 *										  tagname[attribute*='value']
		 *	
		 *	Dynamic X-Path:

							//input[@name='']

							//input[@type='submit' and @value='Login']

							//a[text()='']

							//a[contains(text(),'')]
		 *
		 *
		 *
		 *
		 */
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("https://www.amazon.com");
		
		chromeDriver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		
		/*		
		chromeDriver.findElement(By.xpath("//input[@type='email']")).sendKeys("varaprasada.kovvuri@gmail.com");
		chromeDriver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(2000);
		chromeDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
		chromeDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();	
		*/
		
		/*		
		chromeDriver.findElement(By.cssSelector("input[type='email']")).sendKeys("varaprasada.kovvuri@gmail.com");
		chromeDriver.findElement(By.cssSelector("input[id='continue']")).click();
		Thread.sleep(2000);
		chromeDriver.findElement(By.cssSelector("input[type='password']")).sendKeys("password");
		chromeDriver.findElement(By.cssSelector("input[id='signInSubmit']")).click();
		 */
		
		
		/*
		chromeDriver.findElement(By.cssSelector("input#ap_email")).sendKeys("varaprasada.kovvuri@gmail.com");
		chromeDriver.findElement(By.cssSelector("input#continue")).click();
		Thread.sleep(2000);
		chromeDriver.findElement(By.cssSelector("input#ap_password")).sendKeys("password");  	
		chromeDriver.findElement(By.cssSelector("input#signInSubmit")).click();
		*/
		
		/*
		chromeDriver.findElement(By.cssSelector("input.a-input-text.a-span12.auth-autofocus.auth-required-field")).sendKeys("varaprasada.kovvuri@gmail.com");
		chromeDriver.findElement(By.cssSelector("input.a-button-input")).click();
		Thread.sleep(2000);
		chromeDriver.findElement(By.cssSelector("input.a-input-text.a-span12.auth-autofocus.auth-required-field")).sendKeys("password");  	
		chromeDriver.findElement(By.cssSelector("input.a-button-input")).click();
		*/
		
		chromeDriver.findElement(By.cssSelector("#ap_email")).sendKeys("varaprasada.kovvuri@gmail.com");
		chromeDriver.findElement(By.cssSelector("#continue")).click();
		Thread.sleep(2000);
		chromeDriver.findElement(By.cssSelector("#ap_password")).sendKeys("password");  	
		chromeDriver.findElement(By.cssSelector("#signInSubmit")).click();
				
		chromeDriver.quit();
		// chromeDriver.close();
		
		
	}

}
