package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {
    private AndroidDriver<MobileElement> driver;

    public CategoriesPage() {
    }

    public CategoriesPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Anne Bebek']")
    private MobileElement momAndBaby;


    public void clickMomAndBaby() {
        momAndBaby.click();
    }

    public void selectCategories () {
        clickMomAndBaby();
    }

}
