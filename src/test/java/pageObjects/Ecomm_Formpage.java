package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Ecomm_Formpage{	
	
	public Ecomm_Formpage(AppiumDriver driver){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

//	POM for Ecomm_TC_4.java
	@AndroidFindBy(id="android:id/text1")
	public WebElement dropDownElement;
	
	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))")
	public WebElement scrollElement;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameElement;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	public WebElement genderElement;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement buttonElement;
	
}
