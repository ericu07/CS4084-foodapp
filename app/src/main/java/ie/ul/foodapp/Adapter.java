package ie.ul.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private ArrayList<String> data;

    public Adapter(Context context, ArrayList<String> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.custom_card,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String title = data.get(i);
        viewHolder.textTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle,textDescription;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textTitle = itemView.findViewById(R.id.card1);
            textDescription = itemView.findViewById(R.id.card1Description);
        }
    }
}
