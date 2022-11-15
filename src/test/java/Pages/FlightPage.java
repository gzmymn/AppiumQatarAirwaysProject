package Pages;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.example.StepImplementation;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FlightPage extends StepImplementation {


    @Step("Ucus Secim ekrani geldi mi kontrol et")
    public void checkFlightPage(){
        assertElementById("com.m.qr:id/booking_activity_conversational_message","Select your departure");
        logger.info("Ucus secim ekraninin geldigi kontrol edildi");
    }

    @Step("Rastgele ucusu sec")
    public void chooseRandomFlight() throws InterruptedException {
        randomSelectionOfElement("//*[@resource-id='com.m.qr:id/rvmp_departure_time']");
        waitForSecond(3);
        clickElementById("com.m.qr:id/rvmp_activity_flight_details_select_button");
        logger.info("Rastgele ucus secildi");
    }

    @Step("Saat degerini kontrol et")
    public void verifyFlightTimes(){
        MobileElement mobileElement = appiumDriver.findElement(By.id("com.m.qr:id/from_time"));
        Assert.assertEquals("Saat degerleri ayni degil.", mobileElement.getText(), timeValue);
        logger.info("Ucus saati karsilastirildi ve ayni oldugu dogrulandi");
    }

}
