package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "alex_qN6X0H");
        caps.setCapability("browserstack.key", "r9siN8SFjHzuw37LHuDc");


/*DesiredCapabilities capabilities = new DesiredCapabilities();
HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
bstackOptions.put("userName", "alex_qN6X0H");
bstackOptions.put("accessKey", "r9siN8SFjHzuw37LHuDc");
capabilities.setCapability("platformName", "android");
capabilities.setCapability("appium:platformVersion", "15.0");
capabilities.setCapability("appium:deviceName", "Google Pixel 9");
capabilities.setCapability("appium:app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
capabilities.setCapability("bstack:options", bstackOptions);*/



        
        // Set URL of the application under test
        caps.setCapability("appium:app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
/*
        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");*/

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    //new URL("https://alex_qN6X0H:r9siN8SFjHzuw37LHuDc@hub-cloud.browserstack.com/wd/hub"), caps);
                      new URL("https://hub-cloud.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
