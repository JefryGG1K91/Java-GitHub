import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorer {
	
	private static WebDriver webDriver;
	
	public static void main(String[] args) {

		try {
			
			String driverURL ="C:\\Users\\jegutierrez\\Downloads\\DevelopStuff\\IEDriverServer_Win32_2.39.0\\IEDriverServer.exe";
			String appURL= "https://learn.letskodeit.com/p/practice";

			//setting up internet explorer options
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			//set system path for selenium browser driver
			System.setProperty("webdriver.ie.driver", driverURL);
			webDriver = new InternetExplorerDriver();
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			webDriver.manage().window().maximize();
			webDriver.get(appURL);

			webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			webDriver.findElement(By.xpath("//div/fieldset/label/input[@value='honda']")).click();
			WebElement bmwRadio = webDriver.findElement(By.id("bmwradio"));
			bmwRadio.click();
			
			Thread.sleep(5000);

		
			
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		
		}finally {

			webDriver.quit();

		}





	}
}
