package com.shubh.pagination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VHolder> {

    ArrayList<String> data;
    Context context;

    public Adapter(ArrayList<String> data, Context context){

        this.data=data;
        this.context=context;
    }

    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, int position) {

        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class VHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public VHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textItem);
        }
    }
}