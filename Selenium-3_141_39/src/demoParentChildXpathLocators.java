import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoParentChildXpathLocators {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("https://www.google.com/");		
		
		// Parent child relation ship on google home page search
		// Note: it can be achieved with x-path
		// //div[@class='RNNXgb']/div/div[2]/input		
		
		
		/*
		chromeDriver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).sendKeys("vara prasada reddy");
		Thread.sleep(5000);
		chromeDriver.findElement(By.cssSelector("input[value='Google Search'")).click();
		
		Thread.sleep(10000);
		chromeDriver.quit();
		*/
		
		// Sibling relation ship scenario's
		/*
		identifying the sibling from another sibling :

			.//*[@attribute='value']/following-sibling::<sibling element tag along with index>

			.//*[@id='tablist1-tab1']/following-sibling::li[2]


			identifying the parent from child element :

			.//*[@attribute='value']/parent::<parent element tag>
			.//*[@id='tablist1-tab1']/parent::ul


			identifying the element using text attribute :
			.//*[text()]='Text Value']
			.//*[text()]=' Home ']   

			Note: In text if you find any spaces keep those spaces in the text value attribute.		
		*/
		
		//***// What is the difference between X-Path & CSS
		// The main difference between x-path and CSS selector is that by using CSS selector we cann't achieve the parent - child relationship...
		// Only through X-Path we can achieve parent - child relationship...
	
		// CSS is ten times faster than x-path...		
		
		// Sibling Example:
		
		/*		  
		 
		Identify of the xpath from the html code for the second element of the unordered list (<li name="item2">Css</li>, assuming that the parent (div tag) is having a dyname value for locator Id.


				<div id ="name_12">
				<ul>
				<li name="item1">Xpath</li>
				<li name="item2">Css</li>
				<li name="item3">Partial Text</li>
				</ul>
				</div>

				Ans:

					//li[@name='item1']/following-sibling::li
		*/
	}
}
