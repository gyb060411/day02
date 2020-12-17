package com.example.day02.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02.adapter.HomeAdapter;
import com.example.day02.R;
import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;
import com.example.day02.contract.MainContract;
import com.example.day02.persenter.IMainPersenterIpml;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements MainContract.MainView {

    private RecyclerView rlv;
    private ArrayList<ProjectBean.NewsBean> list;
    private HomeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        IMainPersenterIpml iMainPersenterIpml = new IMainPersenterIpml(this);
        iMainPersenterIpml.per1();
    }

    private void initView(View view) {
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new HomeAdapter(getActivity(), list);
        rlv.setAdapter(adapter);
    }

    @Override
    public void getBanner(BannerBean bannerBean) {

    }

    @Override
    public void getData(ProjectBean projectBean) {
        list.addAll(projectBean.getNews());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getList(ListBean listBean) {

    }

    @Override
    public void getResult(String result) {
        Log.e("TAG", "onError: " + result);
    }
}