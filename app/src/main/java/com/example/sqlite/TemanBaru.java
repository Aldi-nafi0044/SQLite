package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqlite.database.DBcontroller;
import com.example.sqlite.database.Teman;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {
    private TextInputEditText tnama,ttelpon;
    private Button simpanbtn;
    String nm,tlp;
    DBcontroller controller = new DBcontroller(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);
        tnama = (TextInputEditText)findViewById(R.id.tietnama);
        ttelpon = (TextInputEditText)findViewById(R.id.tiettelpon);
        simpanbtn = (Button)findViewById(R.id.btnsimpan);

        simpanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tnama.getText().toString().equals("")||ttelpon.getText().equals("")){
                    Toast.makeText(getApplicationContext(),"Data belum lengkap",Toast.LENGTH_LONG).show();
                }else {
                    nm = tnama.getText().toString();
                    tlp = ttelpon.getText().toString();

                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);

                    controller.insertdata(qvalues);
                    callHome();
                }
            }
        });
    }
    public void callHome(){
        Intent intent = new Intent(TemanBaru.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}