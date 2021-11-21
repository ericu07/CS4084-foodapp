package ie.ul.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView restName, restDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        restName = findViewById(R.id.details_title);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        //String desc = intent.getStringExtra("description");
        restName.setText(title);
        //restDescription.setText(desc);

    }
}