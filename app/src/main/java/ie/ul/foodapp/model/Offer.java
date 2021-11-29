package ie.ul.foodapp.model;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import java.time.LocalTime;

import ie.ul.foodapp.utils.BitmapUtils;

public class Offer {

    protected Business business;
    protected Object booker;
    protected int ID;
    protected String name;
    protected String description;
    protected LocalTime pickup;
    protected double price;

    protected Bitmap offerImage;
    protected Bitmap croppedImage;

    public Offer(Business business) {
        this.business = business;
    }

    public Offer(Offer o) {
        this.business = o.business;
        this.booker = o.booker;
        this.ID = o.ID;
        this.name = o.name;
        this.description = o.description;
        this.pickup = o.pickup;
        this.price = o.price;

        this.offerImage = o.offerImage;
        this.croppedImage = o.croppedImage;
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Offer(this);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public int getOfferID() {return business.ID;}

    public Object getBooker() {
        return booker;
    }

    public void setBooker(Object booker) {
        this.booker = booker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getPickup() {
        return pickup;
    }

    public void setPickup(LocalTime pickup) {
        this.pickup = pickup;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Bitmap getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(Bitmap offerImage) {
        this.offerImage = offerImage;
        this.croppedImage = BitmapUtils.cropToAspectRatio(offerImage, 2.5f, 1f);
    }

    public Bitmap getCroppedImage() {
        return croppedImage;
    }
}
