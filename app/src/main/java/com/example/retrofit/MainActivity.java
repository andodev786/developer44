package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.model.Images;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


@BindView(R.id.textview)
TextView textv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // textv=findViewById(R.id.textview);

showData();
    }

public void showData()
{
MyWebService webService=MyWebService.retrofit.create(MyWebService.class);
    Call<List<Images>> call=webService.getPosts();
    call.enqueue(new Callback<List<Images>>() {
        @Override
        public void onResponse(Call<List<Images>> call, Response<List<Images>> response) {
            if(response.isSuccessful())
            {
                for(Images post:response.body())
                {
                    showPost(post);
                }

            }
        }

        @Override
        public void onFailure(Call<List<Images>> call, Throwable t) {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }
    });



}

    private void showPost(Images post)

    {

        String st=String.valueOf(post.getId());
        String s=post.getUrl();
        //String st1=post.getBody();

        textv.setText(""+s);




    }


}
