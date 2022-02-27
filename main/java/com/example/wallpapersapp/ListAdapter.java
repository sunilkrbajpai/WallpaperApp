package com.example.wallpapersapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter {

    ArrayList names;
    ArrayList thumbs;
    Context context;
    int[] myImageList;

    public ListAdapter(ArrayList names, Context context, int[] myImageList) {
        this.names = names;
        this.thumbs = thumbs;
        this.context = context;
        this.myImageList=myImageList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        viewHolder vh = new viewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        viewHolder myViewHolder = (viewHolder) holder;

        
//        String str="R.drawable."+thumbs.get(position);
//        int resID = context.getResources().getIdentifier(str , "drawable", context.getPackageName());
//        Drawable image = context.getResources().getDrawable(resID);

        myViewHolder.name.setText((String) names.get(position));
        myViewHolder.myimage.setImageResource(myImageList[position]);
//        Glide.with(myViewHolder.myimage).load(thumbs.get(position)).into(myViewHolder.myimage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//        show toast notification
//                Toast.makeText(v.getContext(), (String) names.get(position), Toast.LENGTH_LONG).show();

                Intent intent=new Intent(context,MainActivity.class);
                intent.putExtra("category",(String) names.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView myimage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemText);
            myimage= itemView.findViewById(R.id.myImage);
        }
    }
}