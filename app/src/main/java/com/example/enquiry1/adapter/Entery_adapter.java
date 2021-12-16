package com.example.enquiry1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enquiry1.R;
import com.example.enquiry1.model.entry;

import java.util.ArrayList;

public class Entery_adapter extends RecyclerView.Adapter<Entery_adapter.view_holder>{
    Context context;
    ArrayList<entry> list;

    public Entery_adapter(Context context, ArrayList<entry> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_view,parent,false);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
        holder.date.setText(list.get(position).getDate());
        holder.name.setText(list.get(position).getName());
        holder.num.setText(list.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class view_holder extends RecyclerView.ViewHolder
    {
        TextView name,num,date;
        public view_holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Entry_Name);
            num = itemView.findViewById(R.id.Entery_mob);
            date = itemView.findViewById(R.id.Entery_date);
        }
    }
}
