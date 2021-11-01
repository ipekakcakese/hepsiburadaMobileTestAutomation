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

public class LoginPage {
    private AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    Utils utils;
    public LoginPage() {
    }
    public LoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        utils = new Utils(driver);
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "account_icon")
    private MobileElement accountIcon;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"account_menu_button_1\"]/android.view.ViewGroup/android.widget.Button")
    private MobileElement mainLoginButton;
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.EditText")
    private MobileElement emailElement;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.EditText")
    private MobileElement passwordElement;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Giriş yap']")
    private MobileElement loginButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Şifre']")
    private MobileElement twoStageLoginPassword;

    public void typeEmail(String email) {
        emailElement.sendKeys(email);
    }
    public void typePassword(String password) {
        passwordElement.sendKeys(password);
    }
    public void typeTwoStageLoginPassword(String password) {
        twoStageLoginPassword.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public void clickMainLoginButton() {
        mainLoginButton.click();
    }

    public void login (String email, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.view.View[1]/android.widget.EditText")));
        typeEmail(email);
        if(utils.isElementDisplayed(passwordElement)){
            typePassword(password);
        }else {
            clickLoginButton();
            wait.until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//android.widget.EditText[@text='Şifre']")));
            typeTwoStageLoginPassword(password);
        }
        clickLoginButton();
    }
}
