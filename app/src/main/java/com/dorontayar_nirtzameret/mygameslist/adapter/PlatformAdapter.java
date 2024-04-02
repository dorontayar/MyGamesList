package com.dorontayar_nirtzameret.mygameslist.adapter;



import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dorontayar_nirtzameret.mygameslist.R;
import com.dorontayar_nirtzameret.mygameslist.model.platformModel.Result;

import java.util.ArrayList;

public class PlatformAdapter extends RecyclerView.Adapter<PlatformAdapter.ViewHolder> {

    private ArrayList<Result> items;
    private OnClickAdapterListner itemClick;

    public interface OnClickAdapterListner {
        void onClick(Result game, ArrayList<Result> items);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void setPosts(ArrayList<Result> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public ArrayList<Result> getPost() {
        return this.items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_geners, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result model = items.get(position);
        holder.titleType.setText(model.getName());

        if (model.isClicked()) {
            holder.titleBack.setBackgroundColor(Color.parseColor("#c43e00"));
        } else {
            holder.titleBack.setBackgroundColor(Color.parseColor("#342A24"));
        }

        holder.itemView.setOnClickListener(view -> {
            itemClick.onClick(model, items);
            System.out.println("CLICK");
            if (model.isClicked()) {
                holder.titleBack.setBackgroundColor(Color.parseColor("#c43e00"));
            } else {
                holder.titleBack.setBackgroundColor(Color.parseColor("#342A24"));
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleBack;
        TextView titleType;

        public ViewHolder(View view) {
            super(view);
            titleBack = view.findViewById(R.id.titleBack);
            titleType = view.findViewById(R.id.titleType);
        }
    }
}
