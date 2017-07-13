package com.example.dongkibae.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit= new Retrofit.Builder().baseUrl(ApiService.API_URI).build();
        apiService = retrofit.create(ApiService.class);


        //get
        Call<ResponseBody> commit = apiService.getComment(1);
        commit.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String result = response.body().string();
                    Log.v("Test" , result);
                    try {
                        JSONArray jsonArray = new JSONArray(result);
                        int postId,id;
                        int j;
                        String name;
                        String mail;
                        String body;
                        for ( j = 0; j<=jsonArray.length();j++);{
                            JSONObject jsonObject = jsonArray.getJSONObject(j);
                            postId = jsonObject.getInt("postId");
                            id = jsonObject.getInt("id");
                            name = jsonObject.getString("name");
                            mail = jsonObject.getString("email");
                            body = jsonObject.getString("body");
                            Log.v("Test", jsonObject.toString());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        //post
        Call<ResponseBody> comment2 = apiService.getComment(2);
        comment2.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.v("Test" , response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
