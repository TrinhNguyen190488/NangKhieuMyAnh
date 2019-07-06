package com.nkma.nangkhieumyanh.Untils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

public class LogUtil {
    ExtentReports extent;

    private static LogUtil instance;

    public static LogUtil getInstance() {
        if (instance == null)
            instance = new LogUtil();
        return instance;
    }

    private LogUtil() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Report.html", true);
        extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
    }

    public ExtentTest startTest(String title, String descr) {
        return extent.startTest(title, descr);
    }

    public void endTest(ExtentTest logger){
        extent.endTest(logger);
    }

    public void flush(){
        extent.flush();
        extent.close();
    }
}
