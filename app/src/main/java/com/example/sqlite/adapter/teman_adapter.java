package com.example.sqlite.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.R;
import com.example.sqlite.database.Teman;
import com.example.sqlite.update_data;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class teman_adapter extends RecyclerView.Adapter<teman_adapter.TemanViewHolder> {
    private ArrayList<Teman>listData;
    Bundle bundle = new Bundle();
    private String[] SubjectValues;

    public teman_adapter(ArrayList<Teman>listData){
        this.listData = listData;
    }

    @Override
    public TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinf = LayoutInflater.from(parent.getContext());
        View view = layoutinf.inflate(R.layout.row_data_teman,parent,false);
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder( TemanViewHolder holder, int position) {
        String nm, tlp;

        nm = listData.get(position).getNama();
        tlp = listData.get(position).getTelpon();

        holder.namatext.setTextColor(Color.BLUE);
        holder.namatext.setTextSize(20);
        holder.telpontext.setTextSize(15);
        holder.namatext.setText(nm);
        holder.telpontext.setText(tlp);
    }

    @Override
    public int getItemCount() {
        return (listData != null)?listData.size(): 0;
    }
    public class TemanViewHolder extends RecyclerView.ViewHolder{
        private CardView cardku;
        private TextView namatext,telpontext;

        public TemanViewHolder(View view){
            super(view);
            cardku = (CardView)view.findViewById(R.id.kartuku);
            namatext = (TextView) view.findViewById(R.id.textnama);
            telpontext = (TextView) view.findViewById(R.id.texttelpon);
            cardku.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu pm = new PopupMenu(cardku.getContext(),itemView);
                    pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.edit:
                                    Intent intent = new Intent(view.getContext(), update_data.class);
                                    view.getContext().startActivity(intent);;
                                    break;
                                case R.id.hapus:
                                    Snackbar.make(view,"hapus",Snackbar.LENGTH_LONG).show();
                                    break;
                            }
                            return false;
                        }
                    });
                    pm.inflate(R.menu.popupmenu);
                    pm.show();
                }
            });
        }
    }
}
