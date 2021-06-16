package bg.softuni.lection2.mobilele.model.view;

import bg.softuni.lection2.mobilele.model.entites.enums.EngineEnum;
import bg.softuni.lection2.mobilele.model.entites.enums.TransmitionEnum;

import java.math.BigDecimal;

public class OfferSummaryViewModel {
    private EngineEnum engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private int year;
    private TransmitionEnum transmission;

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferSummaryViewModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferSummaryViewModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummaryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSummaryViewModel setYear(int year) {
        this.year = year;
        return this;
    }

    public TransmitionEnum getTransmission() {
        return transmission;
    }

    public OfferSummaryViewModel setTransmission(TransmitionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
}
