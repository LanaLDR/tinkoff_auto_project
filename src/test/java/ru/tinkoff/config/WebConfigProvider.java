package ru.tinkoff.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebConfigProvider {
    WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    public void setUp() {
        Configuration.browserSize = webConfig.browserSize();
        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.pageLoadStrategy = "eager";

        if(webConfig.isRemote()){
            Configuration.remote = webConfig.remoteDriver();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
