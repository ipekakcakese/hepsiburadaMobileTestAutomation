package generic;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Utils {
    private AndroidDriver<MobileElement> driver;

    public Utils (AndroidDriver driver) {
        this.driver = driver;
    }

    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int startY = (int) (size.height * 0.8);
        int endX = (int) (size.width * 0.5);
        int endY = (int) (size.height * 0.3);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(point(startX,startY))
                .waitAction(waitOptions(Duration.ofSeconds(1)))
                .moveTo(point(endX,endY)).release().perform();
    }
    public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        new TouchAction(driver)
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(Duration.ofSeconds(1)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }

    public boolean isElementDisplayed(MobileElement element){
        try{
            return element.isDisplayed();

        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
