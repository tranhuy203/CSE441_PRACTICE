package com.example.btth3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.InputStream;

public class StudentInfoActivity extends AppCompatActivity {
    private ImageView img;
    private TextView tv_id,tv_name,tv_birth_date,tv_address,tv_gender,tv_email,tv_major,tv_gpa,tv_year;
    private Student student;
    private int position;
    private final int GO_TO_EDIT = 9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // find by id
        img = findViewById(R.id.img);
        tv_id = findViewById(R.id.tv_id);
        tv_name = findViewById(R.id.tv_name);
        tv_birth_date = findViewById(R.id.tv_birth_date);
        tv_address = findViewById(R.id.tv_address);
        tv_gender = findViewById(R.id.tv_gender);
        tv_email = findViewById(R.id.tv_email);
        tv_major = findViewById(R.id.tv_major);
        tv_gpa = findViewById(R.id.tv_gpa);
        tv_year = findViewById(R.id.tv_year);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // logic processing
        // img gender
         student = (Student) getIntent().getSerializableExtra("student_data");
         position = getIntent().getIntExtra("position",0);
         toolbar.setTitle(student.getId());
        loadData();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_student_ifo, menu); // Inflate menu
        return true;
    }
    private void deleteStudent(){
        Intent i = new Intent(StudentInfoActivity.this,StudentListActivity.class);
        i.putExtra("position",position);
        setResult(2,i);
        finish();
    }
    private void editStudent(){
        Intent i = new Intent(StudentInfoActivity.this, EditStudentActivity.class);
        i.putExtra("student_data",student);
        i.putExtra("position",position);
        startActivityForResult(i,GO_TO_EDIT);
    }
    private void loadData(){
        if(student.getGender().trim().equals("Nữ")){
            img.setImageResource(R.drawable.women);
        }else {
            img.setImageResource(R.drawable.man);
        }
        // id
        tv_id.setText("Mã sinh viên: "+student.getId());
        // name
        tv_name.setText("Họ và tên: "+student.getFull_name().toString());
        tv_address.setText("Địa chỉ: "+student.getAddress());
        tv_email.setText("Email: "+student.getEmail());
        tv_gender.setText("Giới tính: "+student.getGender());
        tv_birth_date.setText("Ngày sinh: "+student.getBirth_date());
        tv_major.setText("Chuyên ngành: "+student.getMajor());
        tv_gpa.setText("Điểm TB tích lũy: "+student.getGpa());
        tv_year.setText("Sinh viên năm thứ: "+student.getYear());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed(); // Xử lý nút trở lại
            return true;
        } if(id==R.id.edit){
            editStudent();
            return true;
        }if(id==R.id.delete){
            showDeleteDialog();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            student = (Student)data.getSerializableExtra("student_update");
            loadData();
            Intent i = new Intent(StudentInfoActivity.this,StudentListActivity.class);
            i.putExtra("student_update",student);
            i.putExtra("position",position);
            setResult(3,i);
        }
    }
    public void showDeleteDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận xóa");
        builder.setMessage("Bạn có chắc chắn muốn xóa không?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteStudent();
            }
        });

        builder.setNegativeButton(" CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Đóng hộp thoại
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}