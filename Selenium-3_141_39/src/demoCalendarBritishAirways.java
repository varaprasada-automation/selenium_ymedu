import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoCalendarBritishAirways {
	
	// Single window calendar

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.britishairways.com/travel/home/public/en_in/");

		String inputDate = "31-November-2021";
		String[] inputDateArr = inputDate.split("-");
		String date = inputDateArr[0];
		String month = inputDateArr[1];
		String year = inputDateArr[2];

		String tempInput = month + " " + year;

		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();

		chromeDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		chromeDriver.findElement(By.xpath("//*[@id='flight-outbound-date-selector']")).click();
		Thread.sleep(1000);

		WebElement monthYear = chromeDriver
				.findElement(By.xpath("//div[@class='datepicker-month']/span[contains(@class, 'month-name')]"));

		while (true) {
			System.out.println(monthYear.getText() + " " + tempInput);
			if (monthYear.getText().trim().equals(tempInput)) {
				Thread.sleep(1000);
				break;
			}
			Thread.sleep(1000);
			chromeDriver.findElement(By.xpath("//span[@class='move-month next-month']")).click();
			Thread.sleep(1000);
			monthYear = chromeDriver
					.findElement(By.xpath("//div[@class='datepicker-month']/span[contains(@class, 'month-name')]"));
		}

		String beforeXpath = "//*[@id='datepicker-pop-up-modal ba-datepicker']/div/div[2]/div[2]/div[3]/table/tbody/tr[";
		String afterXpath = "]/td[";
		String endXpath = "]";

		boolean flag = false;
		for (int rowNum = 1; rowNum <= 6; rowNum++) {
			for (int colNum = 1; colNum <= 7; colNum++) {
				String day;
				/*
				 * To handle disabled days more than 7 in first row...
				 * 
				if (rowNum==1) {
				   day = chromeDriver
					.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + endXpath)).getText();
				   if (Integer.parseInt(day) > 7) {
					   continue;
				   }
				}
				*/
				
				try {
					day = chromeDriver
							.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + endXpath)).getText();
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

		Thread.sleep(1000);
		chromeDriver.quit();
	}
}
