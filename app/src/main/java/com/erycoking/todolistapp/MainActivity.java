package com.erycoking.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.erycoking.todolistapp.clients.TodoClient;
import com.erycoking.todolistapp.models.Todo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button mButton;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    private void init() {
        mButton = findViewById(R.id.addTodo);
        mRecyclerView = findViewById(R.id.todoRecyclerView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTodo();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoClient client = retrofit.create(TodoClient.class);
        Call<ArrayList<Todo>> call = client.getAllTodos();

        call.enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                if (response.isSuccessful()){
                    TodoRecyclerViewAdapter adapter = new TodoRecyclerViewAdapter(response.body(), MainActivity.this);
                    mRecyclerView.setAdapter(adapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                String msg = "Something went wrong, try again later";
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
            }
        });
    }

    private void addTodo() {

    }


}
