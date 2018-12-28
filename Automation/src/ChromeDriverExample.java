
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class ChromeDriverExample {
	
	private static WebDriver webDriver;
	
	public static void main(String[] args) {
		
		try {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jegutierrez\\Downloads\\DevelopStuff\\chromedriver_win32\\chromedriver.exe");
			
			webDriver = new ChromeDriver();
			
			webDriver.manage().window().maximize();

			webDriver.get("https://letskodeit.teachable.com/p/practice");
			
			WebElement bmwRadioInput = webDriver.findElement(By.xpath(".//input[@id='bmwradio']"));

			bmwRadioInput.click();

			WebElement selectModelClass = webDriver.findElement(By.xpath(".//select[@name='cars']/option[@value='benz']"));

			selectModelClass.click();
			
			 List<WebElement> valueModelClass = webDriver.findElements(By.xpath(".//select[@name='cars']"));
			
			 for (int i = 0; i < valueModelClass.size(); i++) {
				
				System.out.println(valueModelClass.get(i).getText().trim()); 
				 
			}

		
			 
		} catch (Exception e) {

			e.printStackTrace();

		}finally {

			//webDriver.quit();

		}
	}

}
