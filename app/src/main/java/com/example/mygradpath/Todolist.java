package com.example.mygradpath;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Todolist extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<String> todoList;
    private TodoAdapter todoAdapter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        todoList = new ArrayList<>();



        todoAdapter = new TodoAdapter(todoList);
        recyclerView.setAdapter(todoAdapter);

        editText = findViewById(R.id.editText);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = editText.getText().toString().trim();
                if (!newTask.isEmpty()) {
                    todoList.add(newTask);
                    todoAdapter.notifyDataSetChanged();
                    editText.setText("");
                    showToast("Task added: " + newTask);
                }
            }
        });
    }

    private class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

        private List<String> tasks;

        public TodoAdapter(List<String> tasks) {
            this.tasks = tasks;
        }

        @NonNull
        @Override
        public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist2, parent, false);
            return new TodoViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
            String task = tasks.get(position);
            holder.editText.setText(task);

            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String deletedTask = tasks.get(holder.getAdapterPosition());
                    tasks.remove(holder.getAdapterPosition());
                    notifyItemRemoved(holder.getAdapterPosition());
                    showToast("Task deleted: " + deletedTask);
                }
            });

            holder.btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String updatedTask = holder.editText.getText().toString();
                    tasks.set(holder.getAdapterPosition(), updatedTask);
                    notifyItemChanged(holder.getAdapterPosition());
                    showToast("Task updated: " + updatedTask);
                }
            });
        }

        @Override
        public int getItemCount() {
            return tasks.size();
        }

        public class TodoViewHolder extends RecyclerView.ViewHolder {
            EditText editText;
            ImageButton btnDelete;
            ImageButton btnEdit;

            public TodoViewHolder(@NonNull View itemView) {
                super(itemView);
                editText = itemView.findViewById(R.id.editText);
                btnDelete = itemView.findViewById(R.id.d);
                btnEdit = itemView.findViewById(R.id.btnEdit);
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
