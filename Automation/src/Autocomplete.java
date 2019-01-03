import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.security.auth.x500.X500Principal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Autocomplete {

	private static WebDriver webDriver;

	public static void main(String[] args) {

		String driverURL ="C:\\Users\\jegutierrez\\Downloads\\DevelopStuff\\IEDriverServer_Win32_2.39.0\\IEDriverServer.exe";
		String appURL= "https://www.southwest.com/";

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

		WebDriverWait wait = new WebDriverWait(webDriver, 1000);
		WebElement originAirport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/input[@name='originAirport'][@id='air-city-departure']")));
		originAirport.sendKeys("New York");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='js-overlay-container overlay--container ']/ul[@id='air-city-departure-menu']"))).findElements(By.tagName("li")).stream().filter(x -> 
			x.getText().equals("Albany, NY - ALB")).findFirst().get().click();
		
	}

}
