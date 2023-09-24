package com.ndthang.exno1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button buttonChangeColor;
    private Button buttonChangeSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonChangeSize = findViewById(R.id.buttonChangeSize);
        buttonChangeSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float newSize = 24;
                textView.setTextSize(newSize);
            }
        });

        buttonChangeColor = findViewById(R.id.buttonChangeColor);
        buttonChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextColor(Color.RED);
            }
        });
    }
}