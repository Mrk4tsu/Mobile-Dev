package com.example.cau2_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity {
    StringBuilder phepToan = new StringBuilder();
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnCong, btnTru, btnNhan, btnChiaHet, btnChiaDu, btnBang, btnCham, btnAC, btnDel, btnDoiDau;
    TextView text_pheptoan, text_ketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        initAction();
    }
    double evaluate(String expression) {
        Expression e = new Expression(expression);
        return e.calculate();
    }
    void initAction() {
        // Tạo một OnClickListener chung
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                phepToan.append(b.getText().toString());

                TextView text_pheptoan = findViewById(R.id.text_pheptoan);
                text_pheptoan.setText(phepToan.toString());
                System.out.printf("Button %s\n", b.getText().toString());
            }
        };
        // Thiết lập OnClickListener cho mỗi nút
        btn0.setOnClickListener(buttonClickListener);
        btn1.setOnClickListener(buttonClickListener);
        btn2.setOnClickListener(buttonClickListener);
        btn3.setOnClickListener(buttonClickListener);
        btn4.setOnClickListener(buttonClickListener);
        btn5.setOnClickListener(buttonClickListener);
        btn6.setOnClickListener(buttonClickListener);
        btn7.setOnClickListener(buttonClickListener);
        btn8.setOnClickListener(buttonClickListener);
        btn9.setOnClickListener(buttonClickListener);
        btnChiaDu.setOnClickListener(buttonClickListener);
        btnChiaHet.setOnClickListener(buttonClickListener);
        btnCong.setOnClickListener(buttonClickListener);
        btnTru.setOnClickListener(buttonClickListener);
        btnNhan.setOnClickListener(buttonClickListener);
        btnCham.setOnClickListener(buttonClickListener);

        // Tạo một OnClickListener cho nút C
        View.OnClickListener clearClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phepToan.setLength(0); // Xóa nội dung của phepToan

                text_ketqua.setText("0"); // Cập nhật text_ketqua thành "0"
                text_pheptoan.setText("0"); // Cập nhật text_pheptoan thành "0"
                System.out.printf("Xóa toàn bộ\n");
            }
        };
        btnAC.setOnClickListener(clearClickListener);

        // Tạo một OnClickListener cho nút Xóa
        View.OnClickListener deleteClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phepToan.length() > 0) {
                    phepToan.deleteCharAt(phepToan.length() - 1); // Xóa ký tự cuối cùng của phepToan
                    System.out.printf("Delete\n");
                }

                TextView text_pheptoan = findViewById(R.id.text_pheptoan);
                if (phepToan.length() > 0) {
                    text_pheptoan.setText(phepToan.toString()); // Cập nhật text_pheptoan với nội dung mới của phepToan
                } else {
                    text_pheptoan.setText("0"); // Nếu phepToan trống, cập nhật text_pheptoan thành "0"
                    System.out.printf("Set phepToan về 0\n");
                }

            }
        };
        btnDel.setOnClickListener(deleteClickListener);

        // Tạo một OnClickListener cho nút Cham
        View.OnClickListener dotClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phepToan.length() == 0 || phepToan.charAt(phepToan.length() - 1) == '+' || phepToan.charAt(phepToan.length() - 1) == '-' || phepToan.charAt(phepToan.length() - 1) == '*' || phepToan.charAt(phepToan.length() - 1) == '/') {
                    phepToan.append("0.");
                } else if (!phepToan.toString().contains(".")) {
                    phepToan.append(".");
                }

                TextView text_pheptoan = findViewById(R.id.text_pheptoan);
                text_pheptoan.setText(phepToan.toString());
            }
        };

        // Thiết lập OnClickListener cho nút Cham
        btnCham.setOnClickListener(dotClickListener);

        // Tạo một OnClickListener cho nút Bang
        View.OnClickListener equalsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện phép toán trong phepToan
                double result = evaluate(phepToan.toString());

                text_ketqua.setText(String.valueOf(result)); // Cập nhật text_ketqua với kết quả
            }
        };

        // Thiết lập OnClickListener cho nút Bang
        btnBang.setOnClickListener(equalsClickListener);
    }

    public void initViews() {
        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);

        btnCong = findViewById(R.id.button_cong);
        btnTru = findViewById(R.id.button_tru);
        btnNhan = findViewById(R.id.button_nhan);
        btnChiaHet = findViewById(R.id.button_chiahet);
        btnChiaDu = findViewById(R.id.button_chiadu);
        btnBang = findViewById(R.id.button_bang);
        btnCham = findViewById(R.id.button_cham);
        btnAC = findViewById(R.id.button_c);
        btnDel = findViewById(R.id.button_xoa);
        btnDoiDau = findViewById(R.id.button_doidau);

        text_pheptoan = findViewById(R.id.text_pheptoan);
        text_ketqua = findViewById(R.id.text_ketqua);
    }
}