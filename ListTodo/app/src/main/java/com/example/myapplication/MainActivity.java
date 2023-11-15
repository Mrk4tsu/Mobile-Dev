package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TASKS> tasksList;
    FloatingActionButton btnAddTask;
    RecyclerView recyclerTask;
    TASKAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initListenerAction();

        tasksList = new ArrayList<TASKS>();
        //Tạo cấu trúc CSDL
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("TASKS");
        reference.addValueEventListener(ngheFB);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerTask.setLayoutManager(linearLayoutManager);
        recyclerTask.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        taskAdapter = new TASKAdapter(tasksList);
        recyclerTask.setAdapter(taskAdapter);
        taskAdapter.notifyDataSetChanged();
    }
    ValueEventListener ngheFB = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            tasksList.clear();

            // Lấy dữ liệu từ biến snapshot, đưa vào một biến danh sách để xử lý
            for (DataSnapshot obj: snapshot.getChildren()){
                TASKS tasks = obj.getValue(TASKS.class);
                tasksList.add(tasks);
            }
            taskAdapter.notifyDataSetChanged();
        }
        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    void initUI(){
        btnAddTask = findViewById(R.id.btn_add_task);
        recyclerTask = findViewById(R.id.rc_list_task);
    }
    void initListenerAction(){
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}