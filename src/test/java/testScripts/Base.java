package testScripts;
import generic.IAutoConstant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class Base implements IAutoConstant{
	
    public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	
	public static AppiumDriverLocalService startServer() {
	
	boolean flag = checkIfServerIsRunning(4723);
		if(!flag)
	    {	
		    service = AppiumDriverLocalService.buildDefaultService();
		    service.start();
		}
	    return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		}
		catch(IOException e) {
//			If control comes here, it means server is already in use
			isServerRunning = true;
		}
		finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	
	public static AndroidDriver<AndroidElement> capabilities(String appName)  throws IOException {
		FileInputStream fis = new FileInputStream(CONFIG_PATH);
		Properties prop = new Properties();
		prop.load(fis);
		
		File f_appFolder = new File(APP);		
//		File fs = new File(f,"General-Store.apk");
		File f_appName = new File(f_appFolder,(String) prop.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		
//		Lenovo K4 NOTE - SSWS4DNR4SZPQWRW
		String device = (String) prop.get("Device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		cap.setCapability(MobileCapabilityType.APP, f_appName.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		
		return driver;
	}

//	Capture screenshot for failed TC
	public static  void captureScreenshot(String testname){
		Date d = new Date();
		String currentdate = d.toString().replaceAll(":", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(".\\Screenshot\\" + currentdate +"_" + testname + "_screenshot.png");
		//File destFile = new File("."+File.pathSeparator+"screenshot"+File.pathSeparator+ currentdate +"_" + testname + "_screenshot.png");
		
		
		try {
			Files.copy(srcFile, destFile);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
