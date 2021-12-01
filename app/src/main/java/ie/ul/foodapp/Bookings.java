package ie.ul.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Bookings extends AppCompatActivity {
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        ArrayList<String> bookedItems = getBookedItems();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, bookedItems);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<String> getBookedItems(){
        ArrayList<String> items = new ArrayList<>();
        items.add("First Booking");
        items.add("Second Booking");
        items.add("Third Booking");
        items.add("Fourth Booking");
        return items;
    }
}