import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demoWindowHandlesAssignment {

	public static void main(String[] args) {

		// Handling multiple windows...

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://the-internet.herokuapp.com/windows");

		Actions action = new Actions(chromeDriver);

		chromeDriver.findElement(By.cssSelector("div[class='example'] a")).click();

		Set handles = chromeDriver.getWindowHandles(); // Parent, Child

		Iterator handlesIterator = handles.iterator();
		String parentHandleId = (String) handlesIterator.next();
		String childHandleId = (String) handlesIterator.next();

		chromeDriver.switchTo().window(childHandleId);
		System.out.println(chromeDriver.findElement(By.cssSelector(".example")).getText());
		
		
		// To switch back to parent window
		chromeDriver.switchTo().window(parentHandleId);
		
		
		// System.out.println(chromeDriver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		// System.out.println(chromeDriver.findElement(By.cssSelector(".example h3")).getText());
		   System.out.println(chromeDriver.findElement(By.cssSelector("div[id='content'] div h3")).getText());
		
		//System.out.println("Current Window Title : " + chromeDriver.getTitle());
		
	}
}
