package pages;

import generic.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ProductDetail {
    private AndroidDriver<MobileElement> driver;
    protected Utils utils;
    WebDriverWait wait;

    public ProductDetail() {
    }

    public ProductDetail(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        utils = new Utils(driver);
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Anne Bebek']")
    private MobileElement momAndBaby;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/productImage")
    private MobileElement productImage;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/recycler")
    private MobileElement imagePreviews;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/leftIcon")
    private MobileElement imageCloseButton;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/product_detail_favourites")
    private MobileElement favoriteButton;
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement loginSuccessModalOkButton;

    public void clickProductImage() {
        productImage.click();
    }

    public void clickBackButton() {
        imageCloseButton.click();
    }
    public void clickFavoriteButton() {
        favoriteButton.click();
    }
    public void clickLoginSuccessModalOkButton() {
        loginSuccessModalOkButton.click();
    }


    public void addFavorite () {
        clickProductImage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.pozitron.hepsiburada:id/recycler")));
        utils.horizontalSwipeByPercentage(0.6, 0.3, 0.5);
        clickBackButton();
        clickFavoriteButton();
    }
    public void afterAddFavoriteLoginCheck () {
        if(utils.isElementDisplayed(loginSuccessModalOkButton)){
            clickLoginSuccessModalOkButton();
        }else {
            Assert.assertTrue(false,"Login Failed");
        }
        clickBackButton();
    }
}

