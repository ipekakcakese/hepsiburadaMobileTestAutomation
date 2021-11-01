package pages;

import generic.Utils;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MomAndBabyPage {
    private AndroidDriver<MobileElement> driver;
    protected Utils utils;
    WebDriverWait wait;

    public MomAndBabyPage() {
    }

    public MomAndBabyPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        utils = new Utils(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/textViewLocation")
    private MobileElement cityArea;

    public void swipeToLocationArea() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.Button[@text='Bebek Beslenme']")));
        utils.scrollDown();
    }

    public String getCityName() {
        swipeToLocationArea();
        return cityArea.getText();
    }

}

