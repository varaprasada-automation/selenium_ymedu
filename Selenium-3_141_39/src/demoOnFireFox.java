import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demoOnFireFox {

	public static void main(String[] args) {
		// Step #1. Set the system property
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				
		// Step #2. Driver object has to create.
		
		// Property							browser
		//driver.chrome.driver 				chrome
		//driver.gecko.driver				firefox
		//dirver.ie.driver					ie
		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.get("https://www.selenium.dev/");
		System.out.println(fireFoxDriver.getTitle());
	
	}
}
