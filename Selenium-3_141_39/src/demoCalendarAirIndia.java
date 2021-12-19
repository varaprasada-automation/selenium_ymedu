import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoCalendarAirIndia {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.airindia.in/index.htm");

		// chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().window().maximize();
		String inputDate = "20-October-2021";
		String[] inputDateArr = inputDate.split("-");
		String date = inputDateArr[0];
		String month = inputDateArr[1];
		String year = inputDateArr[2];

		String tempInput = month + " " + year;

		chromeDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Thread.sleep(3000);
		chromeDriver.findElement(By.cssSelector("#_depdateeu1")).click();
		Thread.sleep(1000);
		System.out.println(chromeDriver.findElement(By.cssSelector(".ui-datepicker-title")).getText());

		WebElement monthYear = chromeDriver.findElement(By.cssSelector(".ui-datepicker-title"));
		
		JavascriptExecutor JSE = (JavascriptExecutor) chromeDriver;
		//JSE.executeScript("arguments[0].scrollIntoView();", By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
		JSE.executeScript("window.scrollBy(0,1000)");

		while (true) {
			System.out.println(monthYear.getText() + " " + tempInput);
			if (monthYear.getText().trim().equals(tempInput)) {
				Thread.sleep(1000);
				break;
			}
			Thread.sleep(2000);
			// chromeDriver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
			
			
			chromeDriver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			Thread.sleep(2000);
			monthYear = chromeDriver.findElement(By.cssSelector(".ui-datepicker-title"));

			String beforeXpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[";
			String afterXpath = "]/td[";
			String endXpath = "]";

			boolean flag = false;
			for (int rowNum = 1; rowNum <= 6; rowNum++) {
				for (int colNum = 1; colNum <= 7; colNum++) {
					String day;
					try {
						day = chromeDriver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + endXpath))
								.getText();
						if (day.equals(date)) {
							chromeDriver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + endXpath))
									.click();
							flag = true;
							break;
						}
					} catch (NoSuchElementException NSEE) {
						System.out.println("Please, provide correct input date to the script");
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			//Thread.sleep(1000);
		}
		Thread.sleep(5000);
		chromeDriver.quit();
	}
}