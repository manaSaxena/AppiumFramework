package pageObjects;

import java.util.List;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Ecomm_CheckOut{	
	
	public Ecomm_CheckOut(AppiumDriver<AndroidElement> driver){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}


	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List <MobileElement> prodPriceElement;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public MobileElement totalPriceElement;
	
}
