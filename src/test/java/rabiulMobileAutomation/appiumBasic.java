package rabiulMobileAutomation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class appiumBasic extends BaseAppium {

	@Test
	public void WifiSettingTest() throws MalformedURLException, URISyntaxException {
		System.out.println("Appium Test");
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println("alertTitle is: " + alertTitle);
		Assert.assertEquals(alertTitle, "WiFi settings");

	}

}
