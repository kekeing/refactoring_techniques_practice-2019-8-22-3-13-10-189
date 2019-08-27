package com.tws.refactoring.extract_variable;

public class BannerRender {
    public boolean isContainsMAC(String platform){
 ;
        return platform.toUpperCase().indexOf("MAC") > -1;
    }
    public boolean isContainsIE( String browser){

        return browser.toUpperCase().indexOf("IE") > -1;
    }
    public boolean isContainsMACTogetherWithIE(String platform, String browser){
        return isContainsIE(browser) && isContainsMAC(platform);
    }
   public String renderBanner(String platform, String browser) {
        if (isContainsMACTogetherWithIE(platform,browser))
            return "IE on Mac?";
        return "banner";

    }
}
