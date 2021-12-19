import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class demoAssignmentClearTrip {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.cleartrip.com/");

		chromeDriver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/label[2]/div[1]/span[1]"))
				.click();
		
		Thread.sleep(2000);
		

		WebElement selectStaticAdultDropDown = chromeDriver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/select[1]"));
		Select selectAdultDropDown = new Select(selectStaticAdultDropDown);
		selectAdultDropDown.selectByVisibleText("2");
		
		Thread.sleep(5000);
		
		
		WebElement selectStaticChildrenAdultDropDown = chromeDriver.findElement(By.xpath(
				"//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/select[1]"));
		Select selectChildrenDropDown = new Select(selectStaticChildrenAdultDropDown);
		selectChildrenDropDown.selectByVisibleText("1");
		
		Thread.sleep(5000);		
		chromeDriver.findElement(By.partialLinkText("Class of travel, Airline preference")).click();
		Thread.sleep(3000);
		chromeDriver.findElement(By.cssSelector("input[placeholder='Airline name']")).sendKeys("Finnair (AY)");
		Thread.sleep(3000);
		
		
		chromeDriver
				.findElement(By.xpath(
						"//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[2]/button[1]"))
				.click();

		String errMessage = chromeDriver
				.findElement(By.xpath("//span[contains(text(),'Select Departure and Arrival airports/cities.')]"))
				.getText();
		System.out.println(errMessage);
		
	}

}
