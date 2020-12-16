package com.example.day02.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02.R;
import com.example.day02.adapter.ListAdapter;
import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;
import com.example.day02.contract.MainContract;
import com.example.day02.persenter.IMainPersenterIpml;

import java.util.ArrayList;

public class BlankFragment extends Fragment implements MainContract.MainView {

    private RecyclerView rlv;
    private ArrayList<ListBean.StudenlistBean> list;
    private ListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        IMainPersenterIpml iMainPersenterIpml = new IMainPersenterIpml(this);
        iMainPersenterIpml.per2();
    }

    private void initView(View view) {
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new ListAdapter(getActivity(), list);
        rlv.setAdapter(adapter);
        adapter.setMyOnClickListener(new ListAdapter.MyOnClickListener() {
            @Override
            public void MyOnClick(int pos) {
                list.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onNext(BannerBean bannerBean) {

    }

    @Override
    public void onNext(ProjectBean projectBean) {

    }

    @Override
    public void onNext(ListBean listBean) {
        list.addAll(listBean.getStudenlist());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String string) {
        Log.e("TAG", "onError: "+string );
    }
}