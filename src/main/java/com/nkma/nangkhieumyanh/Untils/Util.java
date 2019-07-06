package com.nkma.nangkhieumyanh.Untils;

public class Util {

  public static void sleep(long mil) {
      try{
          Thread.currentThread().sleep(mil);
      }catch (Exception ex){}

  }
    public static void inText(String text) {
        System.out.println(text);
    }


}
