package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	
 
	static AndroidDriver<AndroidElement> driver;
	public Utilities(AndroidDriver<AndroidElement> driver) 
	{		
		this.driver = driver;
	}
		
//	scroll method
	public void scrollToText(String text)
	{		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))").click();
	}


	@BeforeTest
	public void killAllNodes() throws IOException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	}
}
