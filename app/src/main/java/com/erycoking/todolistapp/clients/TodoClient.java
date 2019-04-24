package com.erycoking.todolistapp.clients;

import com.erycoking.todolistapp.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TodoClient {

    @GET("/todos")
    Call<ArrayList<Todo>> getAllTodos();

    @GET("/todos/{id}")
    Call<ArrayList<Todo>> getSingleTodos(@Path(value = "id") int id);

    @POST("todos")
    Call<Todo> createUser(@Body Todo todo);

}
