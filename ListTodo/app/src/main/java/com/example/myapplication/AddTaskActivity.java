package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class AddTaskActivity extends AppCompatActivity {
    FloatingActionButton btnBackHome;
    EditText editDate, editName, editMessage, editPriority;
    Button btnAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        initUI();
        initListenerAction();
    }

    private void initUI() {
        btnBackHome = findViewById(R.id.button_back_home);
        editDate = findViewById(R.id.ed_date);
        editMessage = findViewById(R.id.ed_message);
        editPriority = findViewById(R.id.et_priority);
        editName = findViewById(R.id.ed_name);
        btnAddTask = findViewById(R.id.button_add_task);
    }

    private void initListenerAction() {
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String date = editDate.getText().toString();
                String message = editMessage.getText().toString();
                String priority = editPriority.getText().toString();

                TASKS tasks = new TASKS(name, date, message, priority);
                // Kết nói DB, và thêm
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("TASKS");
                String key = reference.push().getKey();

                HashMap<String, Object> item = new HashMap<>();
                item.put(key, tasks.toFireBaseOB());

                reference.updateChildren(item, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error == null){
                            Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        });
    }
}