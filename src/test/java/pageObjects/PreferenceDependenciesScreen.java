package pageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceDependenciesScreen{	
	
	public PreferenceDependenciesScreen(AppiumDriver<AndroidElement> driver){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

//	POM for Basics.java
	@AndroidFindBy(id="android:id/checkbox")
	public MobileElement checkBoxElement;
	

	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public MobileElement textElement;
	
	@AndroidFindBy(className="android.widget.EditText")
	public MobileElement editBoxElement;
	
	@AndroidFindBy(className="android.widget.Button")
	public List <MobileElement> buttons;
	
}
