package com.emproto.pojo.pojo.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emproto.pojo.R;

import java.util.List;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NamesViewHolder> {
    List<String> names;
    Context context;

    public NamesAdapter(List<String> names, Context context) {
        this.names = names;
        this.context = context;
    }


    @NonNull
    @Override
    public NamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NamesViewHolder(LayoutInflater.from(context).inflate(R.layout.view_names, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NamesViewHolder holder, int position) {
        holder.textView.setText(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class NamesViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public NamesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
        }
    }
}
