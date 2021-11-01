package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FavoritesPage {
    private AndroidDriver<MobileElement> driver;

    public FavoritesPage() {
    }

    public FavoritesPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[4]/android.view.View/android.view.View[1]/android.view.View")
    private MobileElement myFavoritesCard;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[5]")
    private MobileElement myFavoritesLastProductTitle;


    public void clickMyFavorites() {
        myFavoritesCard.click();
    }

    public String getLastProductTitle () {
        clickMyFavorites();
        return myFavoritesLastProductTitle.getText();
    }
}
