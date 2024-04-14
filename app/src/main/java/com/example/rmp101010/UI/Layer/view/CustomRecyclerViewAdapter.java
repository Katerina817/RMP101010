package com.example.rmp101010.UI.Layer.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rmp101010.Data.Layer.model.Item;
import com.example.rmp101010.R;

import java.util.List;
interface ItemClickListener {
    void onItemClick(int position);
}
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Item> items;
    private ItemClickListener itemClickListener;//для хранения слушателя и метод для его установки
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    public CustomRecyclerViewAdapter(Context context, List<Item> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fourthfragment, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.textView.setText(item.getText());
        holder.imageView.setImageResource(item.getPicture());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(holder.getAdapterPosition());
            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        public ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textViewR);
            imageView = view.findViewById(R.id.imageViewR);
        }
    }
}
