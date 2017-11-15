
package sprint5;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

//Story point: https://gatesix.atlassian.net/browse/PADP-399

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class SettingTest {

	Dimension size;
	AndroidDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException, MalformedURLException {
		File appDir = new File("/home/owner/Downloads");
		File app = new File(appDir, "positivradio.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		// capabilities.setCapability("deviceName", "S6");
		capabilities.setCapability("deviceName", "192.168.237.101:5555");
		// capabilities.setCapability(CapabilityType.VERSION, "5.1.0");
		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("platformName", "Android");

		// Here we mention the app's package name, to find the package name we
		// have to convert .apk file into java class files
		capabilities.setCapability("app-package", "com.positivradio");
		// Here we mention the activity name, which is invoked initially as
		// app's first page.
		capabilities.setCapability("app-activity", "com.positivradio.activity");
		// capabilities.setCapability("fullReset", false);
		// driver.startActivity("com.medianet.positivradio",
		// "com.medianet.positivradio.activity.SplashActivity");
		// capabilities.setCapability("app-wait-activity","LoginActivity,NewAccountActivity");
		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		// driver.quit();

	}

	@Test(priority = 1)
	public void CheckSettingPageFromLibrary() {

		MobileElement PlayServiceErrorPopUp = (MobileElement) (driver
				.findElement(By.className("android.widget.Button")));
		PlayServiceErrorPopUp.click();

		MobileElement Email = (MobileElement) (driver.findElement(By.id("com.medianet.positivradio:id/edittext_email")));
		Email.sendKeys("manish.dangas@gate6.com");

		MobileElement Password = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/edittext_password")));
		Password.sendKeys("Gate6@123");

		MobileElement ClickSign = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/btn_signin")));
		ClickSign.click();

		MobileElement mediaPermission1 = (MobileElement) (driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")));
		mediaPermission1.click();

		MobileElement PlayServiceErrorPopUp1 = (MobileElement) (driver
				.findElement(By.className("android.widget.Button")));
		PlayServiceErrorPopUp1.click();

		MobileElement ClickSetting = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/imageView")));
		ClickSetting.click();

		MobileElement toggleButton = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/on_offButton")));
		// toggleButton.click();

	}

	@Test(priority = 2)
	public void CheckSettingPageFromBrowse() {

		MobileElement ClickBrowse = (MobileElement) (driver.findElement(By.xpath("//android.widget.TextView[@text='Browse']")));
		ClickBrowse.click();

		MobileElement ClickSetting = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/settingBtn")));
		ClickSetting.click();

		MobileElement toggleButton = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/on_offButton")));
		// toggleButton.click();

	}

	@Test(priority = 3)
	public void CheckMembershipType() {

		MobileElement PlanType = (MobileElement) (driver.findElement(By.id("com.medianet.positivradio:id/txt_membership_plan")));
		String text = PlanType.getText();
		System.out.println(text);
		AssertJUnit.assertEquals("Yearly Plan", text);

	}

	@Test(priority = 4)
	public void toggle_on_Library() {

		MobileElement toggleButton = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/on_offButton")));
		toggleButton.click();

	}

	@Test(priority = 5)
	public void toggle_off_Library() {

		MobileElement toggleButton = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/on_offButton")));
		toggleButton.click();

	}

	@Test(priority = 6)
	public void toggle_on_Browse() {

		MobileElement ClickBrowse = (MobileElement) (driver.findElement(By.xpath("//android.widget.TextView[@text='Browse']")));
		ClickBrowse.click();

		MobileElement ClickSetting = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/settingBtn")));
		ClickSetting.click();

		MobileElement toggleButton = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/on_offButton")));
		toggleButton.click();

	}

	@Test(priority = 7)
	public void toggle_off_Browse() {

		MobileElement toggleButton = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/on_offButton")));
		toggleButton.click();

	}

	@Test(priority = 8)
	public void Terms_Conditions() {

		MobileElement termsandCondi = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/termsCondition_txt")));
		termsandCondi.click();

		MobileElement Terms_of_Use = (MobileElement) (driver.findElement(By.id("com.medianet.positivradio:id/titleText")));
		String text = Terms_of_Use.getText();

		System.out.print(text);

		AssertJUnit.assertEquals("Terms of Use", text);

		MobileElement click_Ok = (MobileElement) (driver.findElement(By.xpath("//android.widget.Button[@text='OK']")));
		click_Ok.click();

	}

	@Test(priority = 9)
	public void Privacy_Policy() {

		MobileElement termsandCondi = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/termsCondition_txt")));
		termsandCondi.click();

		MobileElement Terms_of_Use = (MobileElement) (driver.findElement(By.id("com.medianet.positivradio:id/titleText")));
		String text = Terms_of_Use.getText();

		System.out.print(text);

		AssertJUnit.assertEquals("Terms of Use", text);

		MobileElement click_Ok = (MobileElement) (driver.findElement(By.xpath("//android.widget.Button[@text='OK']")));
		click_Ok.click();

	}

	@Test(priority = 10)
	public void Check_DownloadAndRemove_Talk() {
		
		MobileElement Back = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/header_back")));
		Back.click();
		
//		MobileElement ClickLib = (MobileElement) (driver.findElement(By.xpath("//android.widget.TextView[@text='Library']")));
//		ClickLib.click();

//		MobileElement ClickBrowse = (MobileElement) (driver
//				.findElement(By.id("com.medianet.positivradio:id/tab_Browse")));
//		ClickBrowse.click();

		MobileElement SelectTopSpeakers = (MobileElement) (driver.findElement(By.xpath("//android.widget.TextView[@text='Top Speakers']")));
		SelectTopSpeakers.click();

		MobileElement SelectTalk = (MobileElement) (driver.findElement(By.xpath("//android.widget.TextView[@text='the Grant Cardone']")));
		SelectTopSpeakers.click();
		SelectTalk.click();

		MobileElement ClickThreeDot = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_threedot")));
		ClickThreeDot.click();

		MobileElement Download = (MobileElement) (driver.findElement(By.xpath("//android.widget.TextView[@text='Download']")));
		Download.click();

		MobileElement ClickThreeDot1 = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_threedot")));
		ClickThreeDot1.click();

		MobileElement GetStatus = (MobileElement) (driver.findElement(By.xpath("//android.widget.TextView[@text='Remove from Downloads']")));
		String test = GetStatus.getText();

		// System.out.println(GetStatus);

		AssertJUnit.assertEquals("Remove from Downloads", test);

		MobileElement ClickRemoveDownload = (MobileElement) (driver.findElement(By.xpath("//android.widget.TextView[@text='Remove from Downloads']")));
		ClickRemoveDownload.click();

		MobileElement ClickThreeDot2 = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/img_threedot")));
		ClickThreeDot2.click();

		MobileElement GetStatus1 = (MobileElement) (driver.findElement(By.xpath("//android.widget.TextView[@text='Download']")));
		String Assert1 = GetStatus1.getText();

		// System.out.println(GetStatus1);

		AssertJUnit.assertEquals("Download", Assert1);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
