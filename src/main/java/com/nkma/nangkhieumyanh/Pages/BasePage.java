package com.nkma.nangkhieumyanh.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected ExtentTest logger;

    public BasePage(){

    }

    public BasePage(WebDriver driver, ExtentTest logger){
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }

}
