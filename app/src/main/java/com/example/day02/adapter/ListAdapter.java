package com.example.day02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02.R;
import com.example.day02.bean.ListBean;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ListBean.StudenlistBean> list;

    public ListAdapter(Context context, List<ListBean.StudenlistBean> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new MyHoler1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHoler1 holer1= (MyHoler1) holder;
        holer1.name.setText("姓名："+list.get(position).getName());
        holer1.tv1.setText("机试成绩："+list.get(position).getSkill());
        holer1.tv2.setText("理论成绩："+list.get(position).getTheory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myOnClickListener!=null){
                    myOnClickListener.MyOnClick(position);
                }
            }
        });
    }
    MyOnClickListener myOnClickListener;

    public void setMyOnClickListener(MyOnClickListener myOnClickListener) {
        this.myOnClickListener = myOnClickListener;
    }

    public interface MyOnClickListener{
        void MyOnClick(int pos);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyHoler1 extends RecyclerView.ViewHolder {

        private final TextView tv2;
        private final TextView tv1;
        private final TextView name;

        public MyHoler1(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
