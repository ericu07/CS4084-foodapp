package ie.ul.foodapp.firebase;

import android.graphics.BitmapFactory;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import ie.ul.foodapp.R;
import ie.ul.foodapp.model.Business;
import ie.ul.foodapp.model.Offer;
import ie.ul.foodapp.utils.App;

public class FirebaseLink {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                            //
    //    BUSINESS                                                                                //
    //                                                                                            //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Used to retrieve the current business (only works when logged as a business, returns null otherwise).
     * @return current business or null.
     */
    public static Business getCurrentBusiness() {
        Business b = new Business(); /* TODO retrive it from database */

        Offer o0 = new Offer(b);
        o0.setName("offer 0");
        o0.setDescription("descr 0");
        o0.setPickup(LocalTime.of(19,32));
        o0.setPrice(123.456);
        o0.setOfferImage(BitmapFactory.decodeResource(App.getContext().getResources(), R.drawable.default_offer_picture));
        b.addOffer(o0);

        Offer o1 = new Offer(b);
        o1.setName("offer 1");
        o1.setDescription("descr 1");
        o1.setPickup(LocalTime.of(23,59));
        o1.setPrice(0.01);
        o1.setOfferImage(BitmapFactory.decodeResource(App.getContext().getResources(), R.drawable.default_offer_picture));
        b.addOffer(o1);

        Offer o2 = new Offer(b);
        o2.setName("offer 2");
        o2.setDescription("descr 2");
        o2.setPickup(LocalTime.of(18,0));
        o2.setPrice(8);
        o2.setOfferImage(BitmapFactory.decodeResource(App.getContext().getResources(), R.drawable.default_offer_picture));
        b.addOffer(o2);

        return b;
    }

    /**
     * Update the business in the database to be similar to the given parameter.
     * This does not update the offers of the business.
     * @see FirebaseLink::createOffer
     * @param b updated version of the business.
     */
    public static void updateBusiness(Business b) {}

    public static List<Business> findNearByBusiness(Object position, double radiusKm) {
        return new LinkedList<>();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                            //
    //    CUSTOMERS                                                                                //
    //                                                                                            //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Used to retrieve the current customer (only works when logged as a regular user, returns null otherwise).
     * @return current customer or null.
     */
    public static Object getCurrenCustomer() {
        return null;
    }

    /**
     * Update the customer in the database to be similar to the given parameter.
     * This does not update the offers of the customer.
     * @see FirebaseLink::bookOffer
     * @param u updated version of the customer.
     */
    public static void updateCustomer(Object u) {}

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                            //
    //    OFFERS                                                                                  //
    //                                                                                            //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Save the given offer to the database (only works when logged as a business).
     * @param o offer to create.
     */
    public static void createOffer(Offer o) {}

    /**
     * Book and offer (only works when logged as a customer).
     * @param o the offer to book.
     */
    public static void bookOffer(Offer o) {}

}
