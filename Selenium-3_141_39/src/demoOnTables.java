import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoOnTables {

	public static void main(String[] args) throws InterruptedException {

		// *[@id="innings_1"]/div[1]/div[8]/div[3]

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/32057/eng-vs-ind-3rd-test-india-tour-of-england-2021");

		WebElement rootOfTableWE = chromeDriver
				.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));

		int rowCount = rootOfTableWE.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();

		int count = rootOfTableWE
				.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']  div:nth-child(3)")).size();

		int totalScore = 0;		
		for (int i = 3; i <= count; i++) {
			
			/*
			System.out.println(rootOfTableWE
					.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i)
					.getText());
			*/
			
			System.out.println(
					rootOfTableWE.findElement(By.xpath("//*[@id='innings_1']/div[1]/div[" + i + "]/div[3]")).getText());
			
			totalScore = totalScore + Integer.parseInt(rootOfTableWE.findElement(By.xpath("//*[@id='innings_1']/div[1]/div[" + i + "]/div[3]")).getText());

			/*
			 
			  //*[@id='innings_1']/div[1]/div[0]/div[3]
			  .//div[@class="cb-col cb-col-100 cb-scrd-itms"]//div[position()=3]
			
			
			  .//div[@class="cb-col cb-col-100 cb-scrd-itms"]//div[(count(preceding-sibling::*)+1) = 3]
			  //*[@id="innings_1"]/div[1]/div[3]/div[3]
			  
		    */
		}
		
		
		
		totalScore += Integer.parseInt(chromeDriver.findElement(By.xpath("//div[text()='Extras']//following-sibling::div")).getText());
		
		//*[@id="innings_1"]/div[1]/div[14]/div[1]
		
		System.out.println("Total Score : " + totalScore);
		Thread.sleep(3000);
		chromeDriver.close();

	}
}
