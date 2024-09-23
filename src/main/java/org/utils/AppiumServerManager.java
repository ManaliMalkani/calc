package org.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServerManager {

    private static AppiumDriverLocalService service;

    public static void startAppiumServer() {
        // Set the path to the Node.js executable and the Appium main JS file if needed
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))  // Path to appium's main.js file
                .usingAnyFreePort()  // Automatically selects any available port
                .withArgument(() -> "--base-path", "/wd/hub")  // Optional base path configuration
                .withLogFile(new File("AppiumServerLogs.txt")); // Optional log file

        // Start the Appium server
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        // Log to console
        System.out.println("Appium server started on: " + service.getUrl());
    }

    public static void stopAppiumServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium server stopped.");
        }
    }

    public static boolean isAppiumServerRunning() {
        return service != null && service.isRunning();
    }

}

