import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelect {
	
	private static WebDriver webDriver;
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jegutierrez\\Downloads\\DevelopStuff\\chromedriver_win32\\chromedriver.exe");
		
		webDriver = new ChromeDriver();
		
		webDriver.manage().window().maximize();

		webDriver.get("https://letskodeit.teachable.com/p/practice");
		
		WebElement multipleSelect = webDriver.findElement(By.id("multiple-select-example"));
		
		Select sel = new Select(multipleSelect);
		
		sel.selectByIndex(1);
		Thread.sleep(2000);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		
		sel.deselectAll();
		
		WebElement option1 = webDriver.findElement(By.xpath("//option[@value='apple']"));
		WebElement option2 = webDriver.findElement(By.xpath("//option[@value='peach']"));
		
		Thread.sleep(2000);
		Actions action = new Actions(webDriver);
		action.keyDown(Keys.LEFT_CONTROL).click(option1).click(option2).build().perform();
		
		sel.deselectAll();
		 
	}

}
