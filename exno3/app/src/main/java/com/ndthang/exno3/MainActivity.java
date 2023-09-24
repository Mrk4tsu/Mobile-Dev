package com.ndthang.exno3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber1;
    EditText editTextNumber2;
    TextView textResul;
    Button btnDivide;
    Button btnMulti;
    Button btnMinus;
    Button btnAdd;
    static float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        textResul = findViewById(R.id.textResul);
        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);

        String text1 = editTextNumber1.getText().toString();
        String text2 = editTextNumber2.getText().toString();

        float num1 = Float.parseFloat(text1);
        float num2 = Float.parseFloat(text2);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = num1 + num2;
                textResul.setText("" + result);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = num1 - num2;
                textResul.setText("" + result);
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = num1 * num2;
                textResul.setText("" + result);
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num2 == 0) textResul.setText("Số chia không thể = 0".toUpperCase());
                result = num1 / num2;
                textResul.setText("" + result);
            }
        });
    }
    void setBtnAdd(){

    }
}