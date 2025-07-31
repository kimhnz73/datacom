package com.datacom.qaexam.configloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    public static final String APP_CONFIG_PROPERTIES = "appConfig.properties";
    public static final String HOME_PAGE_URL = "homePageUrl";
    public static final String HEADLESS = "headless";
    public static final String BROWSER = "browser";
    public static final String TIMEOUT_IN_MILL_SECONDS = "timeoutInMillSeconds";
    private static AppConfig appConfig;
    private String homePageUrl;
    private boolean headless;
    private String browser;
    private int timeoutInMillSeconds;

    private AppConfig(){
        // private default constructor to support a singleton pattern
    }

    public static AppConfig getInstance() {
        if (appConfig == null) {
            // Load configuration file only once
            Properties properties = new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream(APP_CONFIG_PROPERTIES);
                properties.load(fileInputStream);
                appConfig = new AppConfig();
                appConfig.homePageUrl = properties.getProperty(HOME_PAGE_URL);
                appConfig.headless = Boolean.parseBoolean(properties.getProperty(HEADLESS, "true"));
                appConfig.browser = properties.getProperty(BROWSER);
                appConfig.timeoutInMillSeconds = Integer.parseInt(properties.getProperty(TIMEOUT_IN_MILL_SECONDS, "30000"));
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config file " + APP_CONFIG_PROPERTIES + ". Make sure to place the file in the root directory", e);
            }
        }
        return appConfig;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public boolean isHeadless() {
        return headless;
    }

    public String getBrowser() {
        return browser;
    }

    public int getTimeoutInMillSeconds() {
        return timeoutInMillSeconds;
    }
}
