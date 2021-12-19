import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Have bug in the code... Single Window

public class demoOnCalendar {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("http://www.phptravels.net/");
		
		String monthAndYear =   "October 2022";
		String date 		=	"25";
		
		//chromeDriver.findElement(By.name("checkin"));
		chromeDriver.findElement(By.xpath("//input[@id='checkin']")).click();
		// To grab required month and year from date picker
		
		while(true) {		
			String calendarPickerMonthAndYear = chromeDriver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]")).getText();
			if (calendarPickerMonthAndYear.trim().equalsIgnoreCase(monthAndYear)) {
				break;
			} else {
				chromeDriver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[3]/i")).click();
			}
		}
		

		chromeDriver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr/td[contains(text(),"+date+")]")).click();
		Thread.sleep(5000);
		chromeDriver.quit();
	}
}
