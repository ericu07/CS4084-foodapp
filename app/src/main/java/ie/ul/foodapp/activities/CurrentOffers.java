package ie.ul.foodapp.activities;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import ie.ul.foodapp.R;
import ie.ul.foodapp.firebase.FirebaseLink;
import ie.ul.foodapp.model.Business;
import ie.ul.foodapp.model.Offer;

public class CurrentOffers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_offers);

        Business b = FirebaseLink.getCurrentBusiness();

        for (Offer offerModdel : b.getOffers()) {
            ie.ul.foodapp.components.Offer offerView = new ie.ul.foodapp.components.Offer(this);
            offerView.setOffer(offerModdel);
            ((LinearLayout)findViewById(R.id.linearLayout_content)).addView(offerView);
        }
    }

}
