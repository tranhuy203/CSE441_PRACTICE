package com.example.ex01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edt_A, edt_B;
    private Button btn_sum;
    private TextView tv_sum;

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
        initView();
    }

    private void initView() {
        edt_A = findViewById(R.id.edt_A);
        edt_B = findViewById(R.id.edt_B);
        tv_sum = findViewById(R.id.tv_sum);
        btn_sum = findViewById(R.id.btn_sum);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a = Integer.parseInt(edt_A.getText().toString().trim());
                    int b = Integer.parseInt(edt_B.getText().toString().trim());
                    tv_sum.setText("Kết quả: " + (a + b) + "");
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Hãy nhập đúng định dạng A, B là số nguyên", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}