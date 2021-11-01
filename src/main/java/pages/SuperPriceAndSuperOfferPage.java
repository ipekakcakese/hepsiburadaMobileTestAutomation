package pages;

import generic.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SuperPriceAndSuperOfferPage {
    private AndroidDriver<MobileElement> driver;
    protected Utils utils;
    public SuperPriceAndSuperOfferPage() {
    }

    public SuperPriceAndSuperOfferPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        utils = new Utils(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tv_product_list_item_name")
    private MobileElement productTitle;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/pi_product_list_item_image")
    private MobileElement carouselIcon;


    public void clickProductTitle() {
        productTitle.click();
    }

    public String selectProductAndGetProductTitle () {
        while(!utils.isElementDisplayed(carouselIcon)){
            utils.scrollDown();
        }
        String selectedProductTitle = productTitle.getText();
        clickProductTitle();

        return selectedProductTitle;
    }
}
