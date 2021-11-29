package ie.ul.foodapp.firebase;

import static android.content.ContentValues.TAG;

import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import ie.ul.foodapp.R;
import ie.ul.foodapp.model.Business;
import ie.ul.foodapp.model.Customer;
import ie.ul.foodapp.model.Offer;
import ie.ul.foodapp.utils.App;

public class FirebaseLink {


  public static FirebaseAuth mAuth;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                            //
    //    USER                                                                                    //
    //                                                                                            //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public enum UserType {
        Unknown,
        Business,
        Customer
    }

    /**
     * Used to retrieve the current user type (business or customer).
     * @return current type of user.
     */
    public static UserType getUserType() {
        CompletableFuture<UserType> uType = new CompletableFuture<>();

        // retrieve from db
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String email = currentUser.getEmail();
        FirebaseFirestore dataBase = FirebaseFirestore.getInstance();
        DocumentReference docRefUser = dataBase.collection("User").document(email);
        DocumentReference docRefBusiness = dataBase.collection("Business").document(email);
        docRefUser.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //System.out.println(document.getString("type"));
                        switch (document.getString("type")) {
                            case "User": {
                                uType.complete(UserType.Customer);
                                break;
                            }
                            case "Business": {
                                uType.complete(UserType.Business);
                                break;
                            }
                            default: {
                                uType.complete(UserType.Unknown);
                                break;
                            }
                        }
                    } else {
                        Log.d(TAG, "Cant get Current User Type ");
                    }
                } else {
                    Log.d(TAG, "Getting User Type Failed:", task.getException());
                }
            }
        });

        docRefUser.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //System.out.println(document.getString("type"));
                        switch (document.getString("type")) {
                            case "User": {
                                uType.complete(UserType.Customer);
                                break;
                            }
                            case "Business": {
                                uType.complete(UserType.Business);
                                break;
                            }
                            default: {
                                uType.complete(UserType.Unknown);
                                break;
                            }
                        }
                    } else {
                        Log.d(TAG, "Cant get Current User Type ");
                    }
                } else {
                    Log.d(TAG, "Getting User Type Failed:", task.getException());
                }
            }
        });

        try {
            return uType.get();
        } catch (ExecutionException | InterruptedException e) {
            return UserType.Unknown;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                            //
    //    BUSINESS                                                                                //
    //                                                                                            //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    protected static Business currentBusiness;

    /**
     * Used to retrieve the current business (only works when logged as a business, returns null otherwise).
     * @return current business or null.
     */
    public static Business getCurrentBusiness() {
        if (currentBusiness == null) {
            /* TODO retrieve it from database */

            currentBusiness = new Business();

            Offer o0 = new Offer(currentBusiness);
            o0.setName("offer 0");
            o0.setDescription("descr 0");
            o0.setPickup(LocalTime.of(19,32));
            o0.setPrice(123.456);
            o0.setOfferImage(BitmapFactory.decodeResource(App.getContext().getResources(), R.drawable.default_offer_picture));
            currentBusiness.addOffer(o0);

            Offer o1 = new Offer(currentBusiness);
            o1.setName("offer 1");
            o1.setDescription("descr 1");
            o1.setPickup(LocalTime.of(23,59));
            o1.setPrice(0.01);
            o1.setOfferImage(BitmapFactory.decodeResource(App.getContext().getResources(), R.drawable.default_offer_picture));
            currentBusiness.addOffer(o1);

            Offer o2 = new Offer(currentBusiness);
            o2.setName("offer 2");
            o2.setDescription("descr 2");
            o2.setPickup(LocalTime.of(18,0));
            o2.setPrice(8);
            o2.setOfferImage(BitmapFactory.decodeResource(App.getContext().getResources(), R.drawable.default_offer_picture));
            currentBusiness.addOffer(o2);
        }

        return currentBusiness;
    }

    /**
     * Update the business in the database to be similar to the given parameter.
     * This does not update the offers of the business.
     * @see FirebaseLink::createOffer
     * @param b updated version of the business.
     */
    public static void updateBusiness(Business b) {
        /* TODO save into database */
    }

    public static List<Business> findNearByBusiness(Object position, double radiusKm) {
        /* TODO retrieve from database */
        return new LinkedList<>();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                            //
    //    CUSTOMERS                                                                               //
    //                                                                                            //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    protected static Object currentCustomer;

    /**
     * Used to retrieve the current customer (only works when logged as a regular user, returns null otherwise).
     * @return current customer or null.
     */
    public static Object getCurrenCustomer() {

        if(getUserType() == UserType.Customer) {
            //Creates Customer
            Customer currentCustomer = new Customer();

            // gets all data from currently signed in customer
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            String email = currentUser.getEmail();
            FirebaseFirestore dataBase = FirebaseFirestore.getInstance();
            DocumentReference docRef = dataBase.collection("Users").document(email);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            currentCustomer.setEmail(document.getString("email"));
                        } else {
                            Log.d(TAG, "Cant get User Data ");
                        }
                    } else {
                        Log.d(TAG, "Getting User Data Failed:", task.getException());
                    }
                }
            });
        }
        else {

            return null;
        }
        return currentCustomer;


    }

    /**
     * Update the customer in the database to be similar to the given parameter.
     * This does not update the offers of the customer.
     * @see FirebaseLink::bookOffer
     * @param u updated version of the customer.
     */
    public static void updateCustomer(Object u) {
        /* TODO save into database */
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                            //
    //    OFFERS                                                                                  //
    //                                                                                            //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Save the given offer to the database (only works when logged as a business).
     * @param o offer to create.
     */
    public static void createOffer(Offer o) {
        /* TODO save into database */
        getCurrentBusiness().addOffer(o);
    }

    /**
     * Book and offer (only works when logged as a customer).
     * @param o the offer to book.
     */
    public static void bookOffer(Offer o) {
        /* TODO save into database */
        o.setBooker(getCurrenCustomer());
    }

}
