package ie.ul.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView restName,
            restDescription,
            offerName,
            offerDesc,
            price,
            pickup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        restName = findViewById(R.id.details_title);
        offerName = findViewById(R.id.offerName);
        offerDesc = findViewById(R.id.offerDesc);
        price = findViewById(R.id.priceInput);
        pickup = findViewById(R.id.inputTime);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("description");
        restName.setText(title);
        offerName.setText(desc);

        //TO DO: get information from business name

        //offerName.setText();
        //offerDesc.setText();
        //price.setText();
        //pickup.setText();

    }
}