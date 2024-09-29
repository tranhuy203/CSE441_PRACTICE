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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StaffViewModel staffViewModel;
    private StaffAdapter adapter;
    private RecyclerView recyclerView;
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
        recyclerView = findViewById(R.id.recyclerView);
        btn_add = findViewById(R.id.btn_add);
        edt_birthdate = findViewById(R.id.edt_birthdate);
        edt_id = findViewById(R.id.edt_id);
        edt_name=findViewById(R.id.edt_name);
        edt_salary = findViewById(R.id.edt_salary);
        result = findViewById(R.id.result);
        staffViewModel = new StaffViewModel();
        adapter = new StaffAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Quan sát dữ liệu từ ViewModel
        staffViewModel.getStaffs().observe(this, new Observer<List<Staff>>() {
            @Override
            public void onChanged(List<Staff> staffs) {
                adapter.setStaffList(staffs);
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edt_id.getText().toString().trim();
                String name = edt_name.getText().toString().trim();
                String birthdate = edt_birthdate.getText().toString().trim();
                String salary = edt_salary.getText().toString().trim();
                Staff staff = new Staff(id,name,birthdate,salary);
                staffViewModel.addStaff(staff);
                edt_id.setText("");
                edt_name.setText("");
                edt_birthdate.setText("");
                edt_salary.setText("");
                if(result.getVisibility()!=View.GONE){
                    result.setVisibility(View.GONE);
                }
            }
        });
    }

}