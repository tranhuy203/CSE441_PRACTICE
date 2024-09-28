package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChildActivity extends AppCompatActivity {
    private Button btnSubmit;
    private EditText edtGPA,edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();

    }
// Khởi tạo View
    private void initView() {
        btnSubmit = findViewById(R.id.btnSubmit);
        edtGPA = findViewById(R.id.edtGPA);
        edtName = findViewById(R.id.edtName);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChildActivity.this,MainActivity.class);
                String name = edtName.getText().toString().trim();
                String gpa = edtGPA.getText().toString().trim();
                i.putExtra("name",name);
                i.putExtra("gpa",gpa);
                setResult(2,i);
                finish();
            }
        });
    }
}