package com.nkma.nangkhieumyanh.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IntroPage extends BasePage {
    //WebDriver driver;

    @FindBy(xpath = "//div[@class='ptitle']")
    private WebElement title;

    public IntroPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);

    }

    public void navigate() {
        String url = "https://www.nangkhieumyanh.edu.vn/";
        this.driver.get(url);
        this.logger.log(LogStatus.INFO, "Step: Navigate to " + url);
    }

    public String getTitle() {
        String title = this.title.getText();
        return title;
    }

    public boolean isDisplay() {
        String title = getTitle();
        boolean kq = false;
        if (title.equals("GIỚI THIỆU"))
            kq = true;
        if (kq) {
            this.logger.log(LogStatus.PASS, "Passed");
        } else {
            this.logger.log(LogStatus.FAIL, "Failed");

        }

        return kq;


    }

    private static void inText(String text) {
        System.out.println(text);
    }


}
