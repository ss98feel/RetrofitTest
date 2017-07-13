package com.example.dongkibae.retrofittest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dongkibae on 2017. 7. 11..
 */

public interface ApiService {

    public static final String API_URI = "http://jsonplaceholder.typicode.com/";

    @GET("comments")
    Call<ResponseBody>getComment(@Query("postId") int postId);

    @GET("comments")
    Call<ResponseBody>getPostComment(@Query("postId") int postId);

    @GET("comments")
    Call<ResponseBody>getCommentStr(@Query("postId") String postId);

    @FormUrlEncoded
    @GET("comments")
    Call<ResponseBody>getPostCommentStr(@Field("postId") String postId);

}
