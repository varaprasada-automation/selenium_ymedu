 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class demoHandlingSSLCertificates {
	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.merge(capabilities);		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver(chromeOptions);
		chromeDriver.get("https://testsslerror.bytebitebit.com/");
		Thread.sleep(2000);
		chromeDriver.close();
	}
}
