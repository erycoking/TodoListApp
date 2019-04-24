package com.erycoking.todolistapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.erycoking.todolistapp.models.Todo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TodoRecyclerViewAdapter  extends RecyclerView.Adapter<TodoRecyclerViewAdapter.TodoViewHolder>{

    private ArrayList<Todo> todoArrayList = new ArrayList<>();
    private Context mContext;

    public TodoRecyclerViewAdapter(ArrayList<Todo> todoArrayList, Context mContext) {
        this.todoArrayList = todoArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_layout, parent, false);
        TodoViewHolder todoViewHolder = new TodoViewHolder(view);
        return todoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.todoId.setText(Integer.toString(todoArrayList.get(position).getId()));
        holder.todoUserId.setText(Integer.toString(todoArrayList.get(position).getUser_id()));
        holder.todoTitle.setText(todoArrayList.get(position).getTitle());
        holder.todoStatus.setText(String.valueOf(todoArrayList.get(position).isCompleted()));
    }

    @Override
    public int getItemCount() {
        return todoArrayList.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout parentLayout;
        private CardView mCardView;
        private TextView todoUserId, todoId, todoTitle, todoStatus;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.todoParentLayout);
            mCardView = itemView.findViewById(R.id.todoCardView);
            todoUserId = itemView.findViewById(R.id.todoUserId);
            todoId = itemView.findViewById(R.id.todoId);
            todoTitle = itemView.findViewById(R.id.todoTitle);
            todoStatus = itemView.findViewById(R.id.todoStatus);
        }
    }
}
