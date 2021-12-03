package ie.ul.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    TextView restName, restDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      //  restName = findViewById(R.id.details_title);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        //String desc = intent.getStringExtra("description");
     //   restName.setText(title);
        //restDescription.setText(desc);

    }
}