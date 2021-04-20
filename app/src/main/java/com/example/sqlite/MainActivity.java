package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sqlite.adapter.teman_adapter;
import com.example.sqlite.database.DBcontroller;
import com.example.sqlite.database.Teman;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private teman_adapter adapter;
    private ArrayList<Teman>temanarraylist;
    DBcontroller controller = new DBcontroller(this);
    String id,nm,tlp;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        Bacadata();
        
        adapter = new teman_adapter(temanarraylist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TemanBaru.class);
                startActivity(intent);

            }
        });
    }

    public void Bacadata() {
        ArrayList<HashMap<String,String>> daftarteman = controller.getAllTeman();
        temanarraylist = new ArrayList<>();
        /*memindah hasil query kedalam teman*/
        for (int i=0; i<daftarteman.size(); i++){
            Teman teman = new Teman();

            teman.setId(daftarteman.get(i).get("id").toString());
            teman.setNama(daftarteman.get(i).get("nama").toString());
            teman.setTelpon(daftarteman.get(i).get("telpon").toString());
            /*pindahkan dari Teman kedalam Arraylist teman di adapter*/
            temanarraylist.add(teman);
        }
    }
}