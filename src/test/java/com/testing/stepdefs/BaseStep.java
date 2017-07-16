package com.testing.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BaseStep {

    private WebDriver driver;

    @Before
    public void setUp(){
        if(driver == null){
            String path = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @After
    public void cleanUp(){
        //driver.close();
        //driver.quit();
        driver = null;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
