package ie.ul.foodapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.List;

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
        setContentView(R.layout.offer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        restName = findViewById(R.id.details_title);
        offerName = findViewById(R.id.offerName);
        offerDesc = findViewById(R.id.offerDesc);
        price = findViewById(R.id.priceInput);
        pickup = findViewById(R.id.inputTime);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("description");

        db.collection("Offers")
                .whereEqualTo("Name", desc)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()){
                                String description = (String) document.get("description");
                                offerDesc.setText(description);

                                String cost = (String) document.get("Price");
                                price.setText(cost);

                                String time = (String) document.get("pickup time");
                                pickup.setText(time);

                                Log.d("Firebase", "Name of Business:" + ((String) document.get("name")));
                                Log.d("Firebase", document.getId() + " => " + document.getData());
                            }
                        }else{
                            Log.d("Firebase", "Error getting documents: ", task.getException());
                        }
                    }
                });


        restName.setText(title);
        offerName.setText(desc);

    }
}