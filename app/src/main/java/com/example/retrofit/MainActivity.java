package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.model.Images_Model;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


RecyclerView recyclerView;
TextView textv;
LinearLayoutManager linearLayoutManager;
List<Images_Model> imagesList;
ImageAdapter imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // textv=findViewById(R.id.textview);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(this);
        imagesList=new ArrayList<>();
        recyclerView.setLayoutManager(linearLayoutManager);
        imageAdapter=new ImageAdapter(imagesList);
        recyclerView.setAdapter(imageAdapter);

showData();
    }

public void showData()
{
MyWebService webService=MyWebService.retrofit.create(MyWebService.class);
    Call<List<Images_Model>> call=webService.getPosts();
    call.enqueue(new Callback<List<Images_Model>>() {
        @Override
        public void onResponse(Call<List<Images_Model>> call, Response<List<Images_Model>> response) {
            if(response.isSuccessful() &&response.body()!=null)
            {
                Toast.makeText(getApplicationContext(), "success",Toast.LENGTH_LONG).show();
                imagesList.addAll(response.body());
                imageAdapter.notifyDataSetChanged();

            }
        }

        @Override
        public void onFailure(Call<List<Images_Model>> call, Throwable t) {
            Toast.makeText(getApplicationContext(),"Error"+t.getMessage(),Toast.LENGTH_LONG).show();
        }
    });



}



}
