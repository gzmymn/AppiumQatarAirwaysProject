package org.example;

import Base.BaseTest;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;


public class StepImplementation extends BaseTest {


    public String timeValue;

    /*Bekleme*/
    @Step("<second> saniye bekle")
    public void waitForSecond(int second) throws InterruptedException {
        Thread.sleep(1000*second);
    }

    /*xpath ile tiklama*/
    public void clickElementByXpath(String xpath){
        MobileElement mobileElement = appiumDriver.findElement(By.xpath(xpath));
        mobileElement.click();
        logger.info(xpath + " xpath'li elemente tiklandi");
    }

    /*id ile tiklama*/
    public void clickElementById(String id){
        MobileElement mobileElement = appiumDriver.findElement(By.id(id));
        mobileElement.click();
        logger.info(id + " id'li elemente tiklandi");
    }

    /*accesibilityId ile tiklama*/
    public void clickElementByAccesibilityId(String accesibilityId){
        MobileElement mobileElement = appiumDriver.findElementByAccessibilityId(accesibilityId);
        mobileElement.click();
        logger.info(accesibilityId + " accesibilityId'li elemente tiklandi");
    }

    /*xpath ile anahtar kelime gönderme*/
    public void sendKeyElementByXpath(String xpath, String key){
        MobileElement mobileElement = appiumDriver.findElement(By.xpath(xpath));
        mobileElement.sendKeys(key);
        logger.info(xpath + " xpath'li elemente" + key + " degeri gonderildi");
    }

    /*id ile anahtar kelime gönderme*/
    public void sendKeyElementById(String id, String key){
        MobileElement mobileElement = appiumDriver.findElement(By.id(id));
        mobileElement.sendKeys(key);
        logger.info(id + " id'li elemente" + key + " degeri gonderildi");
    }

    /*xpath ile dogrulama*/
    public void assertElementByXpath(String xpath, String key){
        MobileElement mobileElement = appiumDriver.findElement(By.xpath(xpath));
        logger.info("Alınan text değeri ===== " + mobileElement.getText());
        Assert.assertTrue("Element bulunamadi.", mobileElement.getText().equals(key));
    }

    /*id ile dogrulama*/
    public void assertElementById(String id, String key){
        MobileElement mobileElement = appiumDriver.findElement(By.id(id));
        logger.info("Alınan text değeri ===== " + mobileElement.getText());
        Assert.assertTrue("Element bulunamadı.", mobileElement.getText().equals(key));
    }

    /*Rastgele ucus secimi*/
    public void randomSelectionOfElement(String xpath){
        Random random = new Random();
        List<MobileElement> times = appiumDriver.findElements(By.xpath(xpath));
        int ucusSayisi = random.nextInt(times.size());
        timeValue = times.get(ucusSayisi).getText();
        times.get(ucusSayisi).click();
        logger.info("Rastgele ucus secildi");
    }


}
