package ie.ul.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayList<String> items = getArrayList();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, items);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<String> getArrayList(){
        ArrayList<String> items = new ArrayList<>();
        items.add("First Restaurant");
        items.add("Second Restaurant");
        items.add("Third Restaurant");
        items.add("Fourth Restaurant");
        items.add("Fifth Restaurant");
        return items;
    }
}