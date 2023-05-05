package com.epam.training.ekaterina_sycheva.hardcore.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;


public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("src/test/resources/" + System.getProperty("environment"));
    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
