package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImaageAdapter extends RecyclerView.Adapter<ImaageAdapter.foodViewHolder> {
    Context context;
    ArrayList<food> foods;


    public ImaageAdapter(Context context, ArrayList<food> foods,ArrayList<food> foods1)
    {
        this.context=context;
        this.foods=foods;

    }

    {

    }
    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.data_set,parent,false);


        return new foodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull foodViewHolder holder, int position)
    {

        food food=foods.get(position);
        holder.foodimage.setImageResource(food.getImage());
        holder.title.setText(food.getText());
        holder.textView1.setText(food.getText());

    }

    @Override
    public int getItemCount()
    {
        return foods.size();
    }

    public class foodViewHolder extends RecyclerView.ViewHolder

    {
        ImageView foodimage;
        TextView title;
        TextView textView1;
        public foodViewHolder(@NonNull View itemView)
        {
            super(itemView);

            foodimage=itemView.findViewById(R.id.image);
            title=itemView.findViewById(R.id.title);
            textView1=itemView.findViewById(R.id.title1);



        }
    }
}
