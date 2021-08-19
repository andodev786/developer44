package com.example.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.model.Images_Model;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
private List<Images_Model> imagesList;

    public ImageAdapter(List<Images_Model> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.text.setText(imagesList.get(position).getTitle());
        holder.url.setText(imagesList.get(position).getUrl());

    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
            TextView text;
            ImageView image;
        TextView url;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                text=itemView.findViewById(R.id.text);
                image=itemView.findViewById(R.id.image);
                url=itemView.findViewById(R.id.url);

        }
    }
}
