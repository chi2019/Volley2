package com.example.chanakya.volley2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chanakya.volley2.DetailsFragment;
import com.example.chanakya.volley2.R;
import com.example.chanakya.volley2.model.Item;
import com.squareup.picasso.Picasso;

import com.example.chanakya.volley2.model.Item;
import java.util.List;

/**
 * Created by chanakya on 2/18/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          View v = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Item item = items.get(position);

        holder.descrition.setText(item.getDescription());
        holder.title.setText(item.getTitle());

        if (item.getImage().isEmpty()) {
            holder.image.setImageResource(R.drawable.ic_launcher_background);
        } else{
            Picasso.with(context).load(item.getImage()).placeholder(R.drawable.ic_launcher_background).into( holder.image);

        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView descrition;
        ImageView image;

        public MyViewHolder(View v){
            super(v);

            this.title = v.findViewById(R.id.textViewTitle);
            this.descrition = v.findViewById(R.id.textViewDescription);
            this.image = v.findViewById(R.id.imageView);
        }

    }


}
