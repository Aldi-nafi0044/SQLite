package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.database.DBcontroller;

public class update_data extends AppCompatActivity {
    private EditText upnama, uptelpon;
    private Button btupdate;
    private DBcontroller dbcontroller;
    String courseName, courseTelpon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_data);
        upnama = findViewById(R.id.update_nama);
        uptelpon = findViewById(R.id.update_telpon);
        btupdate = findViewById(R.id.btnupdate);

        dbcontroller = new DBcontroller(update_data.this);

        courseName = getIntent().getStringExtra("nama");
        courseTelpon = getIntent().getStringExtra("telpon");

        upnama.setText(courseName);
        uptelpon.setText(courseTelpon);

        btupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbcontroller.updatedata(courseName, upnama.getText().toString(), uptelpon.getText().toString());
                Toast.makeText(update_data.this, "Course Updated..", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(update_data.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}