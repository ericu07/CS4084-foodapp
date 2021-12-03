package ie.ul.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ArrayList<String> items2 =   GetOffers();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(this, items2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    public ArrayList<String> GetOffers(){
        ArrayList<String>   items = new ArrayList<>();
        items.add("Pizza");
        items.add("Chicken soup");
        items.add("Chinese noodles");
        items.add("Turkey");
        items.add("Sandwiches");
        return items;
    }




}