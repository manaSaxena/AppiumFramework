package mob.AppiumFramework;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Ecomm_Formpage;
import pageObjects.Ecomm_Shop;


/*
 * This code fills the form and navigates to the home page successfully
 * selects 2 products 
 * then verify the sum of prices of both the products is equal to the total amount - Lecture 58
 */
public class Ecomm_TC_4 extends Base 
{

	@Test
	public static void validateSum() throws InterruptedException, IOException 
	{
		
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElementById("android:id/text1").click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
		Ecomm_Formpage fp = new Ecomm_Formpage(driver);
		fp.dropDownElement.click();
		fp.scrollElement.click();
		
 /*      
  *     driver.findElement(MobileBy.AndroidUIAutomator
  *     ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
  */
//		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Manas");		
//		driver.hideKeyboard();
//		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
//		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		fp.nameElement.sendKeys("Manas");
		driver.hideKeyboard();
		fp.genderElement.click();
		fp.buttonElement.click();
		
//		capturing all the elements from the product list and adding first 2 item to the cart
//		List<AndroidElement> prodList = driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']");
		Ecomm_Shop sp = new Ecomm_Shop(driver);
		
		int count = sp.prodListElement.size();
			for(int i = 0; i<count; i++)		
			{
				sp.prodListElement.get(i).click();

			}		
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		sp.cartIconElement.click();
		System.out.println("check out screen");
		Thread.sleep(4000);
		
/*//      capturing the price of both selected products on the check out screen
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

		double sum=0;
	        for(int i=0;i<count;i++)
	        {
	            	String strAmount= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
					double dblAmount=getAmount(strAmount);
					sum = sum + dblAmount;//280.97+116.97
	        }
		System.out.println(sum+" Sum of products");
		
//      capturing the total price
		String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

		total = total.substring(1);
		double totalValue=Double.parseDouble(total);

		double totalValue=getAmount(totalAmount);	
		System.out.println(totalValue+" Total value of products");
				 
	}

	public static double getAmount(String value)
	{

		value= value.substring(1);	
		double dblAmount=Double.parseDouble(value);		
		return dblAmount;*/
	}
}