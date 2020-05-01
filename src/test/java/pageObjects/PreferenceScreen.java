package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceScreen{	
	
	public PreferenceScreen(AppiumDriver<AndroidElement> driver){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

//	POM for Basics.java
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement dependenciesElement;
	
	
}
