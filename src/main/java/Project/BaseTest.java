package Project;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

//         appPackage and appActivity
        caps.setCapability("appPackage", "com.linkedin.android"); // Linkedin package
        caps.setCapability("appActivity", "com.linkedin.android.infra.navigation.MainActivity"); // Main activity
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.FULL_RESET, false); // Keep app data

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }
/*
    @AfterClass
    public void teardown() {
        if(driver != null){
            driver.quit();
        }
    }*/
}
