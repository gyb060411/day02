package com.example.day02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day02.R;
import com.example.day02.bean.ProjectBean;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ProjectBean.NewsBean>list;

    public HomeAdapter(Context context, List<ProjectBean.NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new MyHoler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHoler holer= (MyHoler) holder;
        Glide.with(context).load(list.get(position).getImageUrl()).into(holer.img);
        holer.name.setText(list.get(position).getTile());
        holer.title.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyHoler extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView name;
        private final ImageView img;

        public MyHoler(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.tv1);
            title = itemView.findViewById(R.id.tv2);
        }
    }
}
