package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofit.model.Post;

import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView textv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textv=findViewById(R.id.textview);

showData();
    }

public void showData()
{
MyWebService webService=MyWebService.retrofit.create(MyWebService.class);
    Call<List<Post>> call=webService.getPosts();
    call.enqueue(new Callback<List<Post>>() {
        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            if(response.isSuccessful())
            {
                for(Post post:response.body())
                {
                    showPost(post);
                }

            }
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {

        }
    });



}

    private void showPost(Post post)

    {

        String st=String.valueOf(post.getId());
        String st1=post.getBody();
        textv.setText(""+st);




    }


}
