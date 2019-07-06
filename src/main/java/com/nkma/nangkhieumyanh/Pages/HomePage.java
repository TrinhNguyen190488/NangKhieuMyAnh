package com.nkma.nangkhieumyanh.Pages;

import com.nkma.nangkhieumyanh.Untils.Util;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
   // WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Giới thiệu')]")
    private WebElement gioithieu;

    @FindBy(xpath = "//a[@title='Môn Năng Khiếu']")
    private WebElement bomonkhieu;

    @FindBy(xpath = "//a[contains(text(), 'Toán Tư Duy')]")
    private WebElement toantuduy;

    @FindBy(xpath = "//a[contains(text(), 'Anh Văn')]")
    private WebElement anhvan;

    @FindBy(xpath = "//a[contains(text(), 'Mỹ Thuật')]")
    private WebElement mythuat;

    @FindBy(xpath = "//a[contains(text(), 'Thể Dục Aerobic')]")
    private WebElement theducaerobic;

    @FindBy(xpath = "//a[contains(text(), 'Luyện Chữ Đẹp')]")
    private WebElement luyenchudep;


    public HomePage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);

    }


    public void navigate() {
        String url = "https://www.nangkhieumyanh.edu.vn/";
        this.driver.get(url);
        this.logger.log(LogStatus.INFO, "Step: Navigate to " + url);
    }

    public void clickIntro() {
        this.gioithieu.click();
        this.logger.log(LogStatus.INFO,"Step: Click gioi thieu");

    }
    public void hoverTitle(){
        Actions actions = new Actions(driver);
        actions.moveToElement(bomonkhieu).perform();
        Util.sleep(1000);
        this.logger.log(LogStatus.INFO,"Step: Hover on Bo Mon Nang Khieu");
    }

    public boolean isMenuDisplay(){
        boolean isToanTuDuyDisplay = this.toantuduy.isDisplayed();
        if( isToanTuDuyDisplay)
            Util.inText(this.toantuduy.getText());
        boolean isAnhVanDisplay = this.anhvan.isDisplayed();
        boolean isMyThuatDisplay = this.mythuat.isDisplayed();
        boolean isTheDucAerobicDisplay = this.theducaerobic.isDisplayed();
        boolean isLuyenChuDepDisplay = this.luyenchudep.isDisplayed();

        boolean kq = false;
        if (isToanTuDuyDisplay == true
                && isAnhVanDisplay == true
                && isMyThuatDisplay == true
                && isTheDucAerobicDisplay == true
                && isLuyenChuDepDisplay == true
        )
            kq = true;
            if (kq){
                this.logger.log(LogStatus.PASS, "Passed");
            }else {
                this.logger.log(LogStatus.FAIL, "Failed");

            }
        return kq;
    }

//    private static void inText(String text) {
//        System.out.println(text);
//    }viet trong util


}
