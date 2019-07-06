package com.nkma.nangkhieumyanh.Scripts;

import com.nkma.nangkhieumyanh.Pages.EventPage;
import com.nkma.nangkhieumyanh.Pages.HomePage;
import com.nkma.nangkhieumyanh.Pages.IntroPage;
import com.nkma.nangkhieumyanh.Untils.LogUtil;
import com.nkma.nangkhieumyanh.Untils.WDUntil;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class NKMAScripts {

    @BeforeSuite()
    public void setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
    }

    @Test
    public void listEvent() {

        WebDriver driver = WDUntil.createWebDriver();
        ExtentTest logger = LogUtil.getInstance().startTest("Verify List event Display","Step1: Navigate to homepage" +
                "Step2: " +
                "Step 3: ");
        EventPage eventPage = new EventPage(driver,logger);
        eventPage.navigate();
        eventPage.listEvent();
        if (eventPage.getEventSize() > 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false, "empty size");
        }

        LogUtil.getInstance().endTest(logger);
        driver.quit();
    }

    @Test
    public void verifyIntroPageDisplay() {

        WebDriver driver = WDUntil.createWebDriver();
        ExtentTest logger = LogUtil.getInstance().startTest("Verify Info Page Display","Step1: Navigate to homepage" +
                "Step2: " +
                "Step 3: ");
        HomePage homePage = new HomePage(driver, logger);
        homePage.navigate();
        homePage.clickIntro();
        IntroPage introPage = new IntroPage(driver,logger);
        boolean isDisplay = introPage.isDisplay();
        Assert.assertTrue(isDisplay, "Intro page do not display");

        LogUtil.getInstance().endTest(logger);
        driver.quit();
    }

    @Test
    public void verifyBomonNangKhieuDisplay() {

        WebDriver driver = WDUntil.createWebDriver();
        ExtentTest logger = LogUtil.getInstance().startTest("Verify bo mon nang khieu Display","Step1: Navigate to homepage" +
                "Step2: " +
                "Step 3: ");
        HomePage homePage = new HomePage(driver,logger);
        homePage.navigate();
        homePage.hoverTitle();
        boolean isDisplay = homePage.isMenuDisplay();
        Assert.assertTrue(isDisplay, "Menu does not display");

        LogUtil.getInstance().endTest(logger);
        driver.quit();

    }
    @AfterSuite
    public void afterSuite(){
        LogUtil.getInstance().flush();
    }
}
