package com.kalenicz.maciej.retrofi2test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
  private List<UserList.Datum> datumList;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.id.setText(String.valueOf(datumList.get(position).getId()));
        holder.name.setText(datumList.get(position).getFirst_name());
        holder.lastName.setText(datumList.get(position).getLast_name());
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        TextView lastName;

        public ViewHolder(View v) {
            super(v);
            id = v.findViewById(R.id.id_code);
            name = v.findViewById(R.id.first_name);
            lastName= v.findViewById(R.id.last_name);
        }
    }
    public Adapter(List<UserList.Datum> datumList) {
        this.datumList = datumList;
    }
}