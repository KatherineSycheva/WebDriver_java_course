package com.epam.training.ekaterina_sycheva.hardcore.service;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestDataReader {

    private Properties properties;
    private String propertiesPath;
    protected static final Logger logger = LogManager.getLogger(TestDataReader.class);

    public TestDataReader() {
        properties = new Properties();
        try {
            propertiesPath = "src/test/resources/" + System.getProperty("environment");
            properties.load(new FileReader(propertiesPath));
        } catch (FileNotFoundException ex) {
            logger.error("FileNotFoundException Occured while loading properties file::::" +ex.getMessage());
        } catch (IOException ioex) {
            logger.error("IOException Occured while loading properties file::::" + ioex.getMessage());
        }
    }

    public String readProperty(String keyName) {
        return properties.getProperty(keyName, "There is no key in the properties file");
    }
}