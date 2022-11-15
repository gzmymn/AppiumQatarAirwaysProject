package Base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static AppiumDriver<MobileElement> appiumDriver;
    protected boolean localAndroid = true;
    public static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeScenario
    public void setUp() throws MalformedURLException {

        if (localAndroid){
            System.out.println("Android testi basliyor");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.m.qr.home.onboarding.ui.OnBoardingActivity");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.m.qr");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);
            desiredCapabilities.setCapability("autoAcceptAlerts", true);
            desiredCapabilities.setCapability("autoDismissAlerts", true);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
        }else{
            System.out.println("ios testi basliyor");
        }

    }

    @AfterScenario
    public void afterSenaryo(){

        appiumDriver.quit();
    }

}
