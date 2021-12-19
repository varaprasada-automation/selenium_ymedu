import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demoFrames {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://jqueryui.com/droppable/");

		Actions action = new Actions(chromeDriver);

		chromeDriver.switchTo().frame(chromeDriver.findElement(By.cssSelector("iframe[class='demo-frame']")));

		// To find number of frames available in page
		System.out.println(chromeDriver.findElements(By.cssSelector("iframe")));

		WebElement source = chromeDriver.findElement(By.cssSelector("#draggable"));
		WebElement destination = chromeDriver.findElement(By.cssSelector("#droppable"));

		action.dragAndDrop(source, destination).build().perform();
		
		chromeDriver.switchTo().parentFrame();
		chromeDriver.findElement(By.xpath("//a[contains(text(),'Accept')]")).click();
		
		Thread.sleep(5000);
		chromeDriver.quit();
	}
}