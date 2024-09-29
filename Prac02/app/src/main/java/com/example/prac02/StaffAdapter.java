package com.example.prac02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHoder>{
    private List<Staff> staffList;

    public StaffAdapter(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @NonNull
    @Override
    public StaffViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new StaffViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewHoder holder, int position) {
        holder.tv.setText(staffList.get(holder.getAdapterPosition()).toString());
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }

    public class StaffViewHoder extends RecyclerView.ViewHolder {
        private TextView tv;
        public StaffViewHoder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
