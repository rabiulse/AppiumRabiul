package rabiulMobileAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseAppium {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeMethod
	public void lunchURL() throws MalformedURLException, URISyntaxException {

		System.out.println("Appium Test");

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C://Users//rabiu//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("RabiulEmalutor");
		options.setApp("C://Users//rabiu//Appium//Appium//src//test//java//Resource//ApiDemos-debug.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
	}

	@AfterMethod
	public void Teardown() {
		driver.quit();
		System.out.println("driver is now closed:");
		service.stop();
		System.out.println("Service is now stopped:");
	}

}
