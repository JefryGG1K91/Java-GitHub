import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

public class HowTakeScreenShot {

	private static WebDriver webDriver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub  

		String driverURL ="C:\\Users\\jegutierrez\\Downloads\\DevelopStuff\\IEDriverServer_Win32_2.39.0\\IEDriverServer.exe";
		String appURL= "https://www.expedia.com/";

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
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String fileName = "123258" + ".png";
		String directory = "C:\\Users\\jegutierrez\\Downloads\\";
		
		File sourceFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File(directory+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		webDriver.quit();

	}
}
