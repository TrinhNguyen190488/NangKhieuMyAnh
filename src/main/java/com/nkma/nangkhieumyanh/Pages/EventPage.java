package com.nkma.nangkhieumyanh.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EventPage extends BasePage{
    //WebDriver driver; bo dong nay vi da extends tu Basepage

    @FindBy(xpath = "//a[contains(@href,'su-kien')]")
    private List<WebElement> eventItems;

    public EventPage(WebDriver driver, ExtentTest logger) {
//        this.driver = webDriver;
//        PageFactory.initElements(webDriver, this); da viet chung trong Basepage
        super(driver, logger);

    }


    public void navigate() {
        String url = "https://www.nangkhieumyanh.edu.vn/";
        this.driver.get(url);
        this.logger.log(LogStatus.INFO, "Navigate to "+ url);
    }

    public void listEvent() {
        this.logger.log(LogStatus.INFO, "List all events and information ");
        for (WebElement element : eventItems) {
            By title = By.xpath(".//h3");
            WebElement eTitle = element.findElement(title);
            String name = getTextOffHiddenElement(driver,eTitle);
            inText(name);

            By locate = By.xpath(".//div[@class='job']");
            WebElement eLocate = element.findElement(locate);
            String location = getTextOffHiddenElement(driver,eLocate);
            inText(location);
        }
    }

    private static String getTextOffHiddenElement(WebDriver driver, WebElement element) {
        JavascriptExecutor JS = (JavascriptExecutor) driver;
        String text = JS.executeScript("return arguments[0].innerHTML", element).toString();
        return text;
    }

    private static void inText(String text){
        System.out.println(text);
    }


    public int getEventSize() {
        return this.eventItems.size();
    }

}
