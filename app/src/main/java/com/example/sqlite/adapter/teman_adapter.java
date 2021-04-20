package com.example.sqlite.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.R;
import com.example.sqlite.database.Teman;

import java.util.ArrayList;

public class teman_adapter extends RecyclerView.Adapter<teman_adapter.TemanViewHolder>{
    private ArrayList<Teman>listData;

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

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView namatext,telpontext;
        public TemanViewHolder(View view) {
            super(view);
            cardku = (CardView)view.findViewById(R.id.kartuku);
            namatext = (TextView) view.findViewById(R.id.textnama);
            telpontext = (TextView) view.findViewById(R.id.texttelpon);

            cardku.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return true;
                }
            });
        }
    }
}
