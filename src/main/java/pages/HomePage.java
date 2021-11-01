package pages;

import generic.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;
    protected Utils utils;
    public HomePage() {
    }

    public HomePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        utils = new Utils(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/textViewLocation")
    private MobileElement selectLocation;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"İl seçin\"]")
    private MobileElement selectCity;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"İlçe seçin\"]")
    private MobileElement selectCountry;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Mahalle seçin\"]")
    private MobileElement selectDistrict;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='İstanbul']")
    private MobileElement selectFirstCity;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Adalar']")
    private MobileElement selectFirstCountry;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Burgazada']")
    private MobileElement selectFirstDistrict;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Kaydet']")
    private MobileElement locationSaveButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Konumunuz kaydedildi.']")
    private MobileElement submitSuccessNotification;
    @AndroidFindBy(id = "com_appboy_inappmessage_modal_close_button")
    private MobileElement closeModalButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]")
    private MobileElement categoriesButton;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/dod_all")
    private MobileElement superPriceButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Listelerim\"]/android.widget.ImageView")
    private MobileElement favoritesButton;


    public void clickLocation() {
        selectLocation.click();
    }

    public void clickCity() {
        selectCity.click();
    }

    public void clickCountry() {
        selectCountry.click();
    }

    public void clickDistrict() {
        selectDistrict.click();
    }

    public void clickFirstCity() {
        selectFirstCity.click();
    }

    public void clickFirstCountry() {
        selectFirstCountry.click();
    }

    public void clickFirstDistrict() {
        selectFirstDistrict.click();
    }

    public void clickLocationSaveButton() {
        locationSaveButton.click();
    }

    public void closeModal() {
      closeModalButton.click();
    }
    public void clickCategoriesButton() {
        categoriesButton.click();
    }
    public void clickSuperPriceButton() {
        if (utils.isElementDisplayed(closeModalButton)) {
            closeModal();
        }
        utils.scrollDown();
        superPriceButton.click();
    }
    public void clickFavoritesButton() {
        favoritesButton.click();
    }
    public void selectLocationParametersAndSave () {
        if (utils.isElementDisplayed(closeModalButton)) {
            closeModal();
        }
        clickLocation();
        clickCity();
        clickFirstCity();
        clickCountry();
        clickFirstCountry();
        clickDistrict();
        clickFirstDistrict();
        clickLocationSaveButton();
        if(utils.isElementDisplayed(submitSuccessNotification)){
            clickCategoriesButton();
        }
    }

}
