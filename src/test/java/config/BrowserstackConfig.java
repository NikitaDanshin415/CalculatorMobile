package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
//    "system:properties",
//    "system:env",
    "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Config.Key("login")
    String getLogin();

    @Config.Key("password")
    String getPassword();

    @Config.Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Config.Key("appId")
    String getAppId();
}
