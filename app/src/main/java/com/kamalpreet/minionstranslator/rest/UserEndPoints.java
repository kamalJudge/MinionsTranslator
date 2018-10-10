package com.kamalpreet.minionstranslator.rest;

import com.kamalpreet.minionstranslator.model.Contents;
import com.kamalpreet.minionstranslator.model.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserEndPoints
{
    @GET("/translate/minion.json?")
    Call<Model> getContents(@Query("text") String text);
}
