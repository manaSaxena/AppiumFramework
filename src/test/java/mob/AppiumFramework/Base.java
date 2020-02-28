package mob.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
		
		
		FileInputStream fis = new FileInputStream(".//config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		File f_appFolder = new File("App");		
//		File fs = new File(f,"General-Store.apk");
		File f_appName = new File(f_appFolder,(String) prop.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		
//		Lenovo K4 NOTE - SSWS4DNR4SZPQWRW
		String device = (String) prop.get("Device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		cap.setCapability(MobileCapabilityType.APP, f_appName.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		
		return driver;
	}

}
