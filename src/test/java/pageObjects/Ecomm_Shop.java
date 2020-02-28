package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Ecomm_Shop{	
	
	public Ecomm_Shop(AppiumDriver driver){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

//	POM for Ecomm_TC_4.java
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public List <MobileElement> prodListElement;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public MobileElement cartIconElement;
	
}
