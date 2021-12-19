import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoFramesAssignment {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://the-internet.herokuapp.com/nested_frames");
		chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//frame[@name='frame-top']")));
		// chromeDriver.switchTo().frame(chromeDriver.findElement(By.cssSelector("frame[name='frame-top']")));
		// To find number of frames available in page
		chromeDriver.switchTo().frame(chromeDriver.findElement(By.cssSelector("frame[name='frame-middle']")));
		System.out.println(chromeDriver.findElement(By.xpath("//div[@id='content']")).getText());
		// Thread.sleep(5000);
		// chromeDriver.switchTo().parentFrame();
		// System.out.println(" === " + chromeDriver.getCurrentUrl());
		chromeDriver.quit();
	}
}