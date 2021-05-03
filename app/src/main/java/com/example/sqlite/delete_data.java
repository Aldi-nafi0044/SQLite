package com.example.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlite.database.DBcontroller;

public class delete_data extends AppCompatActivity {
    private EditText upnama, uptelpon;
    private Button btupdate;
    private DBcontroller dbcontroller;
    String courseName, courseTelpon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        upnama = findViewById(R.id.update_nama);
        uptelpon = findViewById(R.id.update_telpon);
        btupdate = findViewById(R.id.btnupdate);

        dbcontroller = new DBcontroller(delete_data.this);

        courseName = getIntent().getStringExtra("nama");
        courseTelpon = getIntent().getStringExtra("telpon");

        upnama.setText(courseName);
        uptelpon.setText(courseTelpon);
    }
    public void onClick(View v) {
        // calling a method to delete our course.
        dbcontroller.deleteCourse(courseName);
        Toast.makeText(delete_data.this, "Deleted the course", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(delete_data.this, MainActivity.class);
        startActivity(intent);
    }
}
