package ie.ul.foodapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ie.ul.foodapp.firebase.FirebaseLink;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

        public void onClickGetData (View view) {
            FirebaseLink.getUserType();
        }
    }

