package com.ndthang.exno3;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber1;
    EditText editTextNumber2;
    TextView resultCalculate;
    TextView math;
    TextView numb1;
    TextView numb2;
    Button btnDivide;
    Button btnMulti;
    Button btnMinus;
    Button btnAdd;
    static float result = 0;
    String info = "Vui lòng nhập đầy đủ thông tin!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchItem();
        add();
        minus();
        multi();
        divide();
    }
    void add(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getNumber1 = editTextNumber1.getText().toString();
                String getNumber2 = editTextNumber2.getText().toString();
                if (getNumber1.isEmpty() || getNumber2.isEmpty()){
                    Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();
                    return;
                }
                float num1 = Float.parseFloat(getNumber1);
                float num2 = Float.parseFloat(getNumber2);
                float sum = num1 + num2;
                math.setText("+");
                numb1.setText(String.valueOf(num1));
                numb2.setText(String.valueOf(num2));
                resultCalculate.setText(String.valueOf(sum));
            }
        });
    }
    void minus(){
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getNumber1 = editTextNumber1.getText().toString();
                String getNumber2 = editTextNumber2.getText().toString();
                if (getNumber1.isEmpty() || getNumber2.isEmpty()){
                    Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();
                    return;
                }
                float num1 = Float.parseFloat(getNumber1);
                float num2 = Float.parseFloat(getNumber2);
                float minus = num1 - num2;
                math.setText("-");
                numb1.setText(String.valueOf(num1));
                numb2.setText(String.valueOf(num2));
                resultCalculate.setText(String.valueOf(minus));
            }
        });
    }
    void multi(){
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNumber1 = editTextNumber1.getText().toString();
                String getNumber2 = editTextNumber2.getText().toString();
                if (getNumber1.isEmpty() || getNumber2.isEmpty()){
                    Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();
                    return;
                }
                float num1 = Float.parseFloat(getNumber1);
                float num2 = Float.parseFloat(getNumber2);
                float multi = num1 * num2;
                math.setText("x");
                numb1.setText(String.valueOf(num1));
                numb2.setText(String.valueOf(num2));
                resultCalculate.setText(String.valueOf(multi));
            }
        });
    }
    void divide(){
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNumber1 = editTextNumber1.getText().toString();
                String getNumber2 = editTextNumber2.getText().toString();
                if (getNumber1.isEmpty() || getNumber2.isEmpty()){
                    Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();
                    return;
                }
                float num1 = Float.parseFloat(getNumber1);
                float num2 = Float.parseFloat(getNumber2);
                if(num2 == 0){
                    info = "Không thể chia với số 0";
                    Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();
                    return;
                }
                float divide = num1 / num2;
                math.setText(":");
                numb1.setText(String.valueOf(num1));
                numb2.setText(String.valueOf(num2));
                resultCalculate.setText(String.valueOf(divide));
            }
        });
    }
    String mSetText(String str){
        return str;
    }
    void formatDataInput(float...num){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    }
    void searchItem(){
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        numb1 = findViewById(R.id.number1);
        numb2 = findViewById(R.id.number2);
        math = findViewById(R.id.math);
        resultCalculate = findViewById(R.id.resultCalculate);

        btnDivide = findViewById(R.id.btnDivide);
        btnAdd = findViewById(R.id.btnAdd);
        btnMulti = findViewById(R.id.btnMulti);
        btnMinus = findViewById(R.id.btnMinus);
    }
}