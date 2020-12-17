package com.example.day02.view;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.day02.R;
import com.example.day02.base.BaseActivity;
import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;
import com.example.day02.contract.MainContract;
import com.example.day02.fragment.BlankFragment;
import com.example.day02.fragment.HomeFragment;
import com.example.day02.persenter.IMainPersenterIpml;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<IMainPersenterIpml> implements MainContract.MainView {


    private com.youth.banner.Banner bann;
    private com.google.android.material.tabs.TabLayout tab;
    private androidx.viewpager.widget.ViewPager vp;


    @Override
    protected void initData() {
        getPersenter().per();
    }

    @Override
    protected void initView() {
        bann = (Banner) findViewById(R.id.bann);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        initFragment();
    }

    private void initFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new BlankFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("学校新闻");
        tab.getTabAt(1).setText("班级成绩查询");
    }


    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected IMainPersenterIpml getPersenter() {
        return new IMainPersenterIpml(this);
    }

    @Override
    public void getBanner(BannerBean bannerBean) {
        Log.e("TAG", "onNext: "+bannerBean.toString() );
        ArrayList<BannerBean.BannerlistBean> list=new ArrayList<>();
        list.addAll(bannerBean.getBannerlist());
        bann.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.BannerlistBean bean = (BannerBean.BannerlistBean) path;
                Glide.with(context).load(bean.getImageurl()).into(imageView);
            }
        }).start();
    }

    @Override
    public void getData(ProjectBean projectBean) {

    }

    @Override
    public void getList(ListBean listBean) {

    }

    @Override
    public void getResult(String result) {
        Log.e("TAG", "onError: " + result);
    }

}