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
    }
    void setBtnAdd(){

    }
}