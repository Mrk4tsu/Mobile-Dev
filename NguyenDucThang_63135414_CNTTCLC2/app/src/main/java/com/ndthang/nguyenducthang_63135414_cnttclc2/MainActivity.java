package com.ndthang.nguyenducthang_63135414_cnttclc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_fragment_1;
    Button btn_fragment_2;
    Button btn_fragment_3;
    Button btn_fragment_4;
    Button backHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findItem();

        goFragment();
    }
    void goFragment(){
        btn_fragment_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);
            }
        });
        btn_fragment_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        btn_fragment_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomizeListView.class);
                startActivity(intent);
            }
        });
        btn_fragment_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });

    }
    void findItem(){
        btn_fragment_1 = findViewById(R.id.fragment_1);
        btn_fragment_2 = findViewById(R.id.fragment_2);
        btn_fragment_3 = findViewById(R.id.fragment_3);
        btn_fragment_4 = findViewById(R.id.fragment_4);
    }
}