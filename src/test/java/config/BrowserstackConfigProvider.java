package config;

import org.aeonbits.owner.ConfigFactory;

public class BrowserstackConfigProvider {
    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
}
