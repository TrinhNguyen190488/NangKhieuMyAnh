package com.nkma.nangkhieumyanh.Untils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WDUntil {
    private  static final int TIME_OUT = 10;
    //bien final phai viet hoa

    public static WebDriver createWebDriver() {
        //de sai duoc ham nay phai de chu static, khong can goi o cac lop

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

}
