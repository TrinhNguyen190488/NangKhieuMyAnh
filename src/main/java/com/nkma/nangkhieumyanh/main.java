package com.nkma.nangkhieumyanh;

import com.beust.jcommander.internal.Lists;
import org.testng.TestNG;

import java.util.List;

public class main {
    public static void main(String[] args){

        TestNG testNG = new TestNG();

        List<String> suites = Lists.newArrayList();
        suites.add("./testng.xml");
        testNG.setTestSuites(suites);
        testNG.run();

        //test jenkin
        // abc
    }
}
