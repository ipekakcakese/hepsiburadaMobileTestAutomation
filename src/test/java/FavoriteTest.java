import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import static java.util.concurrent.TimeUnit.SECONDS;

public class FavoriteTest {
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
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @Test(description = "Verify that a user can login to the application with valid credentials")
    public void testFavorite() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSuperPriceButton();
        SuperPriceAndSuperOfferPage superPriceAndSuperOfferPage = new SuperPriceAndSuperOfferPage(driver);
        String selectedProductTitle = superPriceAndSuperOfferPage.selectProductAndGetProductTitle();
        ProductDetail productDetail = new ProductDetail(driver);
        productDetail.addFavorite();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("appipek@gmail.com","Ia123456");
        productDetail.afterAddFavoriteLoginCheck();
        homePage.clickFavoritesButton();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        String favoriteProductTitle = favoritesPage.getLastProductTitle();
        Assert.assertEquals(selectedProductTitle, favoriteProductTitle);
    }


    @AfterMethod
    public void stopAndroidDriver() {
        driver.quit();
    }

}
