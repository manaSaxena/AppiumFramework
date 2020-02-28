package mob.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomepageScreen;


public class DemoBasicsTest extends Base {

	@Test
	public  void basicTest() throws IOException {
		
		AndroidDriver<AndroidElement> driver = capabilities("DemoAPIApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();		
		HomepageScreen h = new HomepageScreen(driver);
		h.preferencesElement.click();
		System.out.println("preferences clicked");
		
/*		
//		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		PreferenceScreen p = new PreferenceScreen(driver);
		p.dependenciesElement.click();
		
		
		PreferenceDependenciesScreen pd = new PreferenceDependenciesScreen(driver);
		pd.checkBoxElement.click();
		pd.textElement.click();
		pd.editBoxElement.sendKeys("Hello");
		pd.buttons.get(1).click();
//		driver.findElementById("android:id/checkbox").click();
//		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
//		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
//		driver.findElementsByClassName("android.widget.Button").get(1).click();
*/		
	}

}
