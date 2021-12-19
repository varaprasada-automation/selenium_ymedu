import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class demoPracticeAssignment {

	public static void main(String[] args) throws InterruptedException {
		// div[@id='checkbox-example']/fieldset/label/input[@type='checkbox']

		String text = "";
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		Thread.sleep(5000);

		chromeDriver.findElement(By.cssSelector("#checkBoxOption1")).click();
		List<WebElement> we = chromeDriver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));

		Thread.sleep(2000);
		int index = 0;
		for (int i = 0; i <= we.size(); i++) {
			if (we.get(i).isSelected()) {
				index = i;
				System.out.println("index : " + index);
				break;
			}
		}
		chromeDriver.findElement(By.id("dropdown-class-example")).click();
		WebElement selectStaticDropDownElement = chromeDriver.findElement(By.id("dropdown-class-example"));
		Select selectStaticDropDown = new Select(selectStaticDropDownElement);
		if (index >= 0) {
			selectStaticDropDown.selectByIndex(index + 1);
			index = index + 2;
			text = chromeDriver
					.findElement(
							By.xpath("//select[@id='dropdown-class-example']/option[" + Integer.toString(index) + "]"))
					.getText();
		}
		Thread.sleep(3000);
		chromeDriver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(text);
		chromeDriver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		System.out.println(chromeDriver.switchTo().alert().getText());

		/*
		 * if(chromeDriver.switchTo().alert().getText().contains(text)){
		 * System.out.println("name found"); } else {
		 * System.out.println("name didn't found"); }
		 */
		// chromeDriver.switchTo().alert().accept();
		// Thread.sleep(2000);
		// chromeDriver.quit();
	}
}
