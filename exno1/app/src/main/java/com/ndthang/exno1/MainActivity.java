package com.ndthang.exno1;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout gradientLayout;

    EditText colorR1;
    EditText colorB1;
    EditText colorG1;
    EditText colorR2;
    EditText colorB2;
    EditText colorG2;

    EditText colorRFont;
    EditText colorBFont;
    EditText colorGFont;
    EditText inputSizeFont;

    TextView labelHexStart;
    TextView labelHexEnd;
    TextView labelFontSize;
    TextView labelFontColor;

    Button btnChangeColorPanel;
    Button btnChangeColorFont;
    Button btnOKChangeSize;
    Button btnAddSizeFont;
    Button btnMinusSizeFont;
    Button btnRandomColorFont;

    float fontSize = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findItem();
        changeColorPanel();
        changeSizeFont();
        changeColorFont();
        upOrDownSize();
        randomColorFont();
    }

    void randomColorFont() {
        btnRandomColorFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int r = random.nextInt(256);
                colorRFont.setText(String.valueOf(r));
                int g = random.nextInt(256);
                colorGFont.setText(String.valueOf(g));
                int b = random.nextInt(256);
                colorBFont.setText(String.valueOf(b));
                labelFontColor.setTextColor(Color.rgb(r, g, b));
                labelFontColor.setText(convertToHex(r, b, g));
            }
        });
    }

    void changeColorFont() {
        btnChangeColorFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getRFont = colorRFont.getText().toString();
                String getGFont = colorGFont.getText().toString();
                String getBFont = colorBFont.getText().toString();
                if (checkRGBValueInput(getBFont, getGFont, getRFont)) {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ mã màu", Toast.LENGTH_SHORT).show();
                    return;
                }
                int r = Integer.parseInt(getRFont);
                int g = Integer.parseInt(getGFont);
                int b = Integer.parseInt(getBFont);
                if (checkRGBValue(r, g, b)) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số nhỏ hơn hoặc bằng 255", Toast.LENGTH_SHORT).show();
                    return;
                }
                labelFontColor.setTextColor(Color.rgb(r, g, b));
            }
        });
    }

    void changeColorPanel() {
        btnChangeColorPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getR1 = colorR1.getText().toString();
                String getG1 = colorG1.getText().toString();
                String getB1 = colorB1.getText().toString();

                String getR2 = colorR2.getText().toString();
                String getG2 = colorG2.getText().toString();
                String getB2 = colorB2.getText().toString();
                if (checkRGBValueInput(getB2, getB1, getG2, getG1, getR1, getR2)) {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ mã màu", Toast.LENGTH_SHORT).show();
                    return;
                }
                int r1 = Integer.parseInt(getR1);
                int g1 = Integer.parseInt(getG1);
                int b1 = Integer.parseInt(getB1);

                int r2 = Integer.parseInt(getR2);
                int g2 = Integer.parseInt(getG2);
                int b2 = Integer.parseInt(getB2);
                if (checkRGBValue(r1, g1, b1, r2, b2, g2)) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số nhỏ hơn hoặc bằng 255", Toast.LENGTH_SHORT).show();
                    return;
                }
                labelHexStart.setText(convertToHex(r1, g1, b1));
                labelHexEnd.setText(convertToHex(r2, g2, b2));
                labelHexStart.setTextColor(Color.rgb(r1, g1, b1));
                labelHexEnd.setTextColor(Color.rgb(r2, g2, b2));

                GradientDrawable gradientDrawable = (GradientDrawable) gradientLayout.getBackground();
                gradientDrawable.setColors(new int[]{hexColor(r1, b1, g1), hexColor(r2, b2, g2)});

                gradientLayout.setBackground(gradientDrawable);

            }
        });
    }

    void upOrDownSize() {
        btnAddSizeFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labelFontSize.setTextSize(fontSize + 1);
                fontSize += 1;
                if (fontSize == 40)
                    fontSize = 24;
                inputSizeFont.setText(String.valueOf(fontSize));
            }
        });
        btnMinusSizeFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labelFontSize.setTextSize(fontSize - 1);
                fontSize -= 1;
                if (fontSize == 5)
                    fontSize = 24;
                inputSizeFont.setText(String.valueOf(fontSize));
            }
        });
    }

    void downSize() {

    }

    void changeSizeFont() {
        btnOKChangeSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getSizeFont = inputSizeFont.getText().toString();
                if (getSizeFont.isEmpty()) {
                    fontSize = 20;
                    labelFontSize.setTextSize(fontSize);
                    return;
                }
                float size = Float.parseFloat(getSizeFont);
                if (size > 40) {
                    size = 20;
                    Toast.makeText(MainActivity.this, "Số quá lớn", Toast.LENGTH_SHORT).show();
                    return;
                }
                labelFontSize.setTextSize(size);
            }
        });
    }

    String convertToHex(int r, int b, int g) {
        int color = Color.rgb(r, g, b);
        return String.format("#%06X", (0xFFFFFF & color));
    }

    int hexColor(int r, int b, int g) {
        return Color.rgb(r, g, b);
    }
    boolean checkRGBValue(int... num) {
        for (int value : num) {
            if (value < 0 || value > 255) {
                return true;
            }
        }
        return false;
    }

    boolean checkRGBValueInput(String... content) {
        for (String value : content) {
            if (value.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    //Load item khi khởi động chương trình
    void findItem() {
        gradientLayout = findViewById(R.id.gradientLayout);

        colorB1 = findViewById(R.id.colorB1);
        colorG1 = findViewById(R.id.colorG1);
        colorR1 = findViewById(R.id.colorR1);

        colorB2 = findViewById(R.id.colorB2);
        colorG2 = findViewById(R.id.colorG2);
        colorR2 = findViewById(R.id.colorR2);

        colorRFont = findViewById(R.id.colorRFont);
        colorBFont = findViewById(R.id.colorBFont);
        colorGFont = findViewById(R.id.colorGFont);

        inputSizeFont = findViewById(R.id.inputSizeFont);

        labelHexStart = findViewById(R.id.labelHexStart);
        labelHexEnd = findViewById(R.id.labelHexEnd);
        labelFontColor = findViewById(R.id.labelFontColor);
        labelFontSize = findViewById(R.id.labelFontSize);

        btnChangeColorPanel = findViewById(R.id.btnChangeColorPanel);
        btnOKChangeSize = findViewById(R.id.btnOKChangeSize);
        btnAddSizeFont = findViewById(R.id.btnAddSizeFont);
        btnMinusSizeFont = findViewById(R.id.btnMinusSizeFont);
        btnChangeColorFont = findViewById(R.id.btnChangeColorFont);
        btnRandomColorFont = findViewById(R.id.btnRandomColorFont);
    }
}