package com.ndthang.bmicaculator;

import static com.ndthang.bmicaculator.R.id.textViewResult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight;
    private EditText editTextHeight;
    private TextView textViewResult;
    private TextView textViewResultString;
    private Button buttonCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        textViewResult = findViewById(R.id.textViewResult);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResultString = findViewById(R.id.textViewResultString);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightString = editTextWeight.getText().toString();
        String heightString = editTextHeight.getText().toString();

        if (!weightString.isEmpty() && !heightString.isEmpty()) {
            float weight = Float.parseFloat(weightString);
            // Chuyển đổi chiều cao thành mét
            float height = Float.parseFloat(heightString) / 100;

            float bmi = weight / (height * height);

            //Làm tròn số thập phân
            DecimalFormat df = new DecimalFormat("#.0");
            String formattedBMI = df.format(bmi);

            String result;

            if (bmi < 18.5) {
                result = "Weark";
            } else if (bmi < 24.9) {
                result = "Normal";
            } else if (bmi < 29.9) {
                result = "Fat";
            } else {
                result = "Very fat";
            }

            textViewResult.setText("" + formattedBMI );
            textViewResultString.setText(result.toUpperCase());
        } else {
            textViewResult.setText("Vui lòng nhập thông tin.");
            textViewResultString.setText("");
        }
    }
}