import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoOnMinimizeAndMaximizeWindowAndDeleteCookies {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		
		chromeDriver.get("https://www.airindia.in/index.htm");
	}
}
