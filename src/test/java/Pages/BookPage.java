package Pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;

public class BookPage extends StepImplementation {


    @Step("Seyahat tipini one way olarak sec")
    public void chooseFlightType(){
        clickElementByAccesibilityId("One-way");
        logger.info("Ucus tipi one way olarak secildi");
    }

    @Step("Kalkis havaalanini Berlin olarak sec")
    public void chooseDepartureAirportOne() throws InterruptedException {
        clickElementById("com.m.qr:id/rvmp_fragment_rtow_flight_selection_origin_holder" );
        logger.info("Kalkis alani tiklandi");
        waitForSecond(3);
        sendKeyElementById("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext","berlin");
        logger.info("Berlin bilgisi yazildi");
        waitForSecond(3);
        clickElementByXpath("//*[@text='BER - Berlin Brandenburg Airport']");
        logger.info("Berlin havaalani tiklandi");
    }


    @Step("İnis havaalanini Istanbul olarak sec")
    public void chooseDeclineAirportOne(){
        clickElementById("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_select_destination_text_view" );
        logger.info("İnis alani tiklandi");
        sendKeyElementById("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext","istanbul");
        logger.info("Istanbul bilgisi yazildi");
        clickElementByXpath("//*[@text='IST - Istanbul Airport']");
        logger.info("Istanbul havaalani tiklandi");
    }


    @Step("Yedi gun sonrasi icin tarih degerini sec")
    public void chooseFlightDate() throws InterruptedException {
        clickElementById("com.m.qr:id/rvmp_fragment_rtow_flight_selection_departure_date_holder");
        waitForSecond(3);
        clickElementByXpath("//*[@text='21']");
        waitForSecond(3);
        clickElementById("com.m.qr:id/fragment_calendar_confirm_button");
        logger.info("Tarih secildi");
    }

    @Step("Ekonomi class sec")
    public void chooseEconomyClass() throws InterruptedException {
        clickElementById("com.m.qr:id/fragment_rtow_flight_cabin_class_text_view");
        waitForSecond(3);
        clickElementById("com.m.qr:id/cabin_selection_economy_row");
        logger.info("Ekonomi sınıfı secildi");
    }

    @Step("Ucus ara")
    public void searchFlight(){
        clickElementById("com.m.qr:id/rvmp_booking_search_flights_button");
        logger.info("Ucus arandi");
    }

}
