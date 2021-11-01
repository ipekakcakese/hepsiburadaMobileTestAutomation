import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.HomePage;
import pages.MomAndBabyPage;

import java.net.MalformedURLException;
import java.net.URL;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LocationTest {
    private final DesiredCapabilities caps = new DesiredCapabilities();
    private AndroidDriver<MobileElement> driver;

    @BeforeSuite
    public void setupDeviceCapabilities() {
        caps.setCapability("deviceName", "Samsung Galaxy s7");
        caps.setCapability("udid", "988627513742563236");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("appPackage", "com.pozitron.hepsiburada");
        caps.setCapability("appActivity","com.hepsiburada.ui.startup.SplashActivity");
        caps.setCapability("noReset","false");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
    }

    @BeforeMethod
    public void spinUpAndroidDriver() {
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(40, SECONDS);
    }

    @Test(description = "Verify that a user can login to the application with valid credentials")
    public void testLocation() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLocationParametersAndSave();
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.selectCategories();
        MomAndBabyPage momAndBabyPage = new MomAndBabyPage(driver);
        Assert.assertEquals(momAndBabyPage.getCityName(), "İstanbul");
    }


    @AfterMethod
    public void stopAndroidDriver() {
        driver.quit();
    }

}
