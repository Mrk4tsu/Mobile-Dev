package com.ndthang.nguyenducthang_63135414_cnttclc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    Button phepcong;
    Button pheptru;
    Button phepnhan;
    Button phepchia;
    EditText sothunhat;
    EditText sothuhai;
    TextView pheptoan;
    TextView ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
    void findItem(){
        phepchia = findViewById(R.id.phepchia);
        phepnhan = findViewById(R.id.phepnhan);
        pheptru = findViewById(R.id.pheptru);
        phepcong = findViewById(R.id.phepcong);

        sothunhat = findViewById(R.id.sothunhat);
        sothuhai = findViewById(R.id.sothuhai);

        pheptoan = findViewById(R.id.pheptinh);
        ketqua = findViewById(R.id.result);
    }
}