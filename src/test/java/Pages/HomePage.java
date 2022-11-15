package Pages;


import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.openqa.selenium.By;

public class HomePage extends StepImplementation {

    @Step("Birinci Skip butonuna tikla")
    public void clickFirstSkip(){
        clickElementById("com.m.qr:id/skip_button");
        logger.info("Skip butonuna tiklandi");
    }

    @Step("İkinci Skip butonuna tikla")
    public void clickSecondSkip(){
        clickElementById("com.m.qr:id/onboarding_skip_button");
        logger.info("Skip butonuna tiklandi");
    }

    @Step("Decline butonuna tikla")
    public void clickDeclineButton()throws InterruptedException {
        if (appiumDriver.findElement(By.id("com.m.qr:id/push_consent_decline")).isDisplayed()){
            appiumDriver.findElement(By.id("com.m.qr:id/push_consent_decline")).click();
            logger.info("Decline butonuna tiklandi");
            waitForSecond(3);
        }else{
            System.out.println("Pop-up gelmedi");
        }
    }


    @Step("Close Popup")
    public void clickClosePopup(){
        clickElementById("com.m.qr:id/secondary_button");
        logger.info("Popup kapatıldı");
    }


    @Step("Anasayfada oldugunu kontrol et")
    public void verifyOnHomePage(){
        assertElementById("com.m.qr:id/rvmp_home_inspiration_title","Travel InspirationTravel Inspiration");
        logger.info("Anasayfada oldugu kontrol edildi");
    }

    @Step("Menuden Book tabini sec")
    public void clickBookMenu(){
        clickElementById("com.m.qr:id/nav_menu_book");
        logger.info("Menuden Book secildi");
    }



}
