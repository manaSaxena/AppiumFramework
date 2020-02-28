package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomepageScreen{	
	
	public HomepageScreen(AppiumDriver driver){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

//	POM for Basics.java
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement preferencesElement;
	
/*//	POM for DragDropDemo.java
	@AndroidFindBy(uiAutomator="text(\"Views\")")
	public WebElement viewsElement;*/
	
	
	
}
