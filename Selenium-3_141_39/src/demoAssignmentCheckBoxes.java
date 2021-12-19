import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class demoAssignmentCheckBoxes {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();

		chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		chromeDriver.findElement(By.name("checkBoxOption1")).click();
		Thread.sleep(2000);

		if (chromeDriver.findElement(By.name("checkBoxOption1")).isSelected()) {
			Assert.assertTrue(chromeDriver.findElement(By.name("checkBoxOption1")).isSelected());
			System.out.println("Check Box 1 is Selected...");
		} else {
			System.out.println("Check Box 1 is not Selected...");
		}

		chromeDriver.findElement(By.name("checkBoxOption1")).click();
		Thread.sleep(2000);

		if (!chromeDriver.findElement(By.name("checkBoxOption1")).isSelected()) {
			System.out.println("Check Box 1 is not Selected...");
		} else {
			System.out.println("Check Box 1 is Selected...");
		}

		Thread.sleep(3000);

		System.out.println("No. of check boxes available : "
				+ chromeDriver.findElements(By.cssSelector("input[type='checkbox']")).size());

		chromeDriver.quit();
	}
}
