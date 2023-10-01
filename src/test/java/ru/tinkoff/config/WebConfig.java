package ru.tinkoff.config;

import org.aeonbits.owner.Config;


@Config.Sources(
        "classpath:${env}.properties"
)
public interface WebConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.tinkoff.ru")
    String baseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("remoteDriver")
    String remoteDriver();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();
}
