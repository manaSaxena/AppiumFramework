package testScripts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Ecomm_CheckOut;
import pageObjects.Ecomm_Formpage;
import pageObjects.Ecomm_Shop;
import generic.Utilities;;

/*
 * This code fills the form and navigates to the home page successfully
 * selects 2 products 
 * then verify the sum of prices of both the products is equal to the total amount - Lecture 58
 */
public class Ecomm_TC_4 extends Base {

	@Test
	public static void validateSum() throws InterruptedException, IOException {

		
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		driver.findElementById("android:id/text1").click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
		Ecomm_Formpage fp = new Ecomm_Formpage(driver);
		fp.dropDownElement.click();
		Utilities u = new Utilities(driver);
		u.scrollToText("Argentina");
		fp.nameElement.sendKeys("Manas");
		driver.hideKeyboard();
		fp.genderElement.click();
		fp.buttonElement.click();

//		capturing all the elements from the product list and adding first 2 item to the cart
//		List<AndroidElement> prodList = driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']");

		Ecomm_Shop sp = new Ecomm_Shop(driver);
		//int count = sp.prodListElement.size();
		//System.out.println(count);
		List<MobileElement> itr=sp.prodListElement;
	    int count=itr.size();
	    int arr[]=new int[count];
		
		  for(int i : arr) 
		  { 
			  sp.prodListElement.get(i).click();
		  }
		  
		

		sp.cartIconElement.click();
		System.out.println("check out screen");
		Thread.sleep(4000);

//      capturing the price of both selected products on the check out screen

		Ecomm_CheckOut co = new Ecomm_CheckOut(driver);
		int checkOutCount = co.prodPriceElement.size();
		double sum = 0;
		for (int i = 0; i < checkOutCount; i++) {
			String strAmount = co.prodPriceElement.get(i).getText();
			double dblAmount = getAmount(strAmount);
			sum = sum + dblAmount;// 280.97+116.97
		}
		System.out.println(sum + " Sum of products");

//      capturing the total price
		String total = co.totalPriceElement.getText();

		total = total.substring(1);
		double totalValue = Double.parseDouble(total);
		System.out.println(totalValue + " Total value of products");
		
		service.stop();

	}

	public static double getAmount(String value) {

		value = value.substring(1);
		double dblAmount = Double.parseDouble(value);
		return dblAmount;
	}
}