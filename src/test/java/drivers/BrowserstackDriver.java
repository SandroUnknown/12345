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
import java.util.HashMap;

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        //caps.setCapability("browserstack.user", "alex_qN6X0H");
        //caps.setCapability("browserstack.key", "r9siN8SFjHzuw37LHuDc");
          caps.setCapability("browserstack.user", "maxcong_Gl8qwK");
          caps.setCapability("browserstack.key", "6BbFx2UPgpeBxozc3esf");

// bs://9fg0rt302be241e6524ebc67253ecdee266343
// wiki - bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c

        
        // Set URL of the application under test
        caps.setCapability("app", "bs://sample.app");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        
        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    //new URL("https://alex_qN6X0H:r9siN8SFjHzuw37LHuDc@hub-cloud.browserstack.com/wd/hub"), caps);
                      new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
