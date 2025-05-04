package com.akakce.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:platformName", params.getPlatformName());
            // caps.setCapability("appium:udid", params.getUDID());
            // caps.setCapability("appium:deviceName", params.getDeviceName());

            switch(params.getPlatformName()){
                case "Android":
                    caps.setCapability("appium:automationName", props.getProperty("androidAutomationName"));
                    caps.setCapability("appium:appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appium:appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("appium:systemPort", params.getSystemPort());
                    caps.setCapability("appium:chromeDriverPort", params.getChromeDriverPort());
                    break;
                case "iOS":
                    caps.setCapability("appium:platformVersion", "18.3.2");
                    caps.setCapability("appium:automationName", props.getProperty("iOSAutomationName"));
                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "Akakce.app";
                    utils.log().info("appUrl is" + iOSAppUrl);
                    caps.setCapability("appium:bundleId", props.getProperty("iOSBundleId"));
                    caps.setCapability("appium:wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("appium:webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                    caps.setCapability("appium:udid", params.getUDID());
                    // caps.setCapability("appium:app", iOSAppUrl);
                    break;
            }
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
