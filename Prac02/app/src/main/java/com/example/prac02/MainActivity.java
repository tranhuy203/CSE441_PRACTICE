package com.example.prac02;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StaffViewModel staffViewModel;
    private ArrayAdapter<Staff> adapter;
    private ListView lv;
    private Button btn_add;
    private EditText edt_id,edt_name,edt_birthdate,edt_salary;
    private TextView result;
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
        lv = findViewById(R.id.lv);
        btn_add = findViewById(R.id.btn_add);
        edt_birthdate = findViewById(R.id.edt_birthdate);
        edt_id = findViewById(R.id.edt_id);
        edt_name=findViewById(R.id.edt_name);
        edt_salary = findViewById(R.id.edt_salary);
        result = findViewById(R.id.result);
        staffViewModel = new StaffViewModel();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        lv.setAdapter(adapter);

        // Quan sát dữ liệu từ ViewModel
        staffViewModel.getStaffs().observe(this, new Observer<List<Staff>>() {
            @Override
            public void onChanged(List<Staff> staffs) {
                adapter.clear();
                adapter.addAll(staffs);
                adapter.notifyDataSetChanged();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}