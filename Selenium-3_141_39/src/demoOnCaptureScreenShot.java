import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoOnCaptureScreenShot {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.google.com/?gws_rd=ssl");
		
		File screenShot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("C:\\Users\\Vara\\screenshot.png"));
		
		Thread.sleep(2000);
		chromeDriver.close();
	}
}
