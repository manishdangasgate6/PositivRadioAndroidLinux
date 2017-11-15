package sprint5;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class PlayRandomTalkTest {

	Dimension size;
	AndroidDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException, MalformedURLException {
		File appDir = new File("/home/owner/Downloads");
		File app = new File(appDir, "positivradio.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

		capabilities.setCapability("deviceName", "192.168.237.101:5555");

		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("platformName", "Android");

		// Here we mention the app's package name, to find the package name we
		// have to convert .apk file into java class files
		capabilities.setCapability("app-package", "com.positivradio");
		// Here we mention the activity name, which is invoked initially as
		// app's first page.
		capabilities.setCapability("app-activity", "com.positivradio.activity");

		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);

	}

	@Test(priority = 1)
	public void doLogin() {

		MobileElement PlayServiceErrorPopUp = (MobileElement) (driver
				.findElement(By.className("android.widget.Button")));
		PlayServiceErrorPopUp.click();

		MobileElement Email = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/edittext_email")));
		Email.sendKeys("manish.dangas@gate6.com");

		MobileElement Password = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/edittext_password")));
		Password.sendKeys("Gate6@123");

		MobileElement ClickSign = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/btn_signin")));
		ClickSign.click();

		MobileElement mediaPermission1 = (MobileElement) (driver
				.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")));
		mediaPermission1.click();

		MobileElement PlayServiceErrorPopUp1 = (MobileElement) (driver
				.findElement(By.className("android.widget.Button")));
		PlayServiceErrorPopUp1.click();
	}

	@Test(priority = 2)
	public void shufflePlayFromLibraryTalks() {

		driver.findElement(By.id("com.medianet.positivradio:id/img_shuffle_play")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Allow']")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();
	}

	@Test(priority = 3)
	public void shufflePlayFromLibrarySpeakers() {

		TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(707, 172).moveTo(305, 169).release().perform();
		driver.findElement(By.id("com.medianet.positivradio:id/img_shuffle_play")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();
	}

	@Test(priority = 4)
	public void shufflePlayFromLibraryRecentlyAdded() {

		TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(707, 172).moveTo(305, 169).release().perform();
		driver.findElement(By.id("com.medianet.positivradio:id/img_shuffle_play")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();
	}

	@Test(priority = 5)
	public void shufflePlayFromLibraryRecentlyDownloaded() throws InterruptedException {

		TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(707, 172).moveTo(305, 169).release().perform();
		Thread.sleep(2000);
		driver.findElement(By.id("com.medianet.positivradio:id/img_shuffle_play")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();
	}

	@Test(priority = 6)
	public void shufflePlayFromBrowseTopTalks() {

		MobileElement ClickBrowse = (MobileElement) (driver
				.findElement(By.xpath("//android.widget.TextView[@text='Browse']")));
		ClickBrowse.click();
		driver.findElement(By.id("com.medianet.positivradio:id/shufflePlayBtn")).click();

		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();
	}

	@Test(priority = 7)
	public void shufflePlayFromBrowseTopSpeakers() {

		MobileElement ClickBrowse = (MobileElement) (driver
				.findElement(By.xpath("//android.widget.TextView[@text='Browse']")));
		ClickBrowse.click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Top Speakers']")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/shufflePlayBtn")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();

	}

	@Test(priority = 8)
	public void shufflePlayFromSearchSpeakers() {

		MobileElement ClickOnSearch = (MobileElement) (driver
				.findElement(By.xpath("//android.widget.TextView[@text='Search']")));
		ClickOnSearch.click();

		MobileElement SearchTalk = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/search_edittext")));
		SearchTalk.sendKeys("tony robbins");

		driver.findElement(By.xpath("//android.widget.TextView[@text='the Tony Robbins']")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/shufflePlayBtn")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();

	}

	@Test(priority = 9)
	public void shufflePlayFromSearchTalks() {

		MobileElement ClickBack = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/back_imageView")));
		ClickBack.click();

		driver.findElement(By.id("com.medianet.positivradio:id/search_edittext")).clear();

		MobileElement SearchTalk = (MobileElement) (driver
				.findElement(By.id("com.medianet.positivradio:id/search_edittext")));
		SearchTalk.sendKeys("the body");

		driver.findElement(By.xpath("//android.widget.TextView[@text='the body you deserve']")).click();

		driver.findElement(By.id("com.medianet.positivradio:id/img_startPlaying")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();

	}

	@Test(priority = 10)
	public void startPlayingLibraryFromTheSelectedTalks() {

		driver.findElement(By.xpath("//android.widget.TextView[@text='raising positive kids in a neg']")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/img_startPlaying")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();

	}

	@Test(priority = 11)
	public void shufflePlayLibraryFromTheSelectedSpeaker() {

		driver.findElement(By.id("com.medianet.positivradio:id/headerback_imageView")).click();
		TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(707, 172).moveTo(305, 169).release().perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Tony Robbins']")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/shufflePlayBtn")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/back_imageView")).click();

	}

	@Test(priority = 12)
	public void startPlayingSingleTalkLibraryFromTheSelectedSpeaker() {

		driver.findElement(By.xpath("//android.widget.TextView[@text='Tony Robbins']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='the time of your life']")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/img_startPlaying")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/headerback_imageView")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/back_imageView")).click();

	}

	@Test(priority = 13)
	public void PlaySingleTalkOnClickOnSongFromLibraryFromTheSelectedSpekerTalk() {

		driver.findElement(By.xpath("//android.widget.TextView[@text='Tony Robbins']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='the time of your life']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1.']")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/headerback_imageView")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/back_imageView")).click();

	}

	@Test(priority = 11)
	public void PlaySingleTalkOnClickOnSongFromLibraryFromTheSelectedTalk() {
		TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(305, 169).moveTo(707, 172).release().perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Zig Ziglar']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1.']")).click();
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause"));
		driver.findElement(By.id("com.medianet.positivradio:id/btnPause")).click();

	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}
}
