package com.test.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ms.banner.Banner;
import com.ms.banner.Transformer;
import com.ms.banner.holder.BannerViewHolder;
import com.ms.banner.holder.HolderCreator;
import com.ms.banner.listener.OnBannerListener;
import com.test.CustomData;
import com.test.R;
import com.test.ui.CustomViewHolder2;
import com.test.ui.CustomViewHolder3;

import java.util.ArrayList;
import java.util.List;

public class CustomViewPagerActivity extends AppCompatActivity implements OnBannerListener {

    Banner banner1;
    Banner banner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_pager);

        banner1 = (Banner) findViewById(R.id.banner1);
        banner2 = (Banner) findViewById(R.id.banner2);

        List<CustomData> list = new ArrayList<>();
        list.add(new CustomData("", "CustomLayout", false));
        list.add(new CustomData("", "Transformer", false));
        list.add(new CustomData("", "Viewpager", false));

        ArrayList<CustomData> arrList = new ArrayList<>();
        CustomData data1 = new CustomData("http://img.zcool.cn/community/01fca557a7f5f90000012e7e9feea8.jpg", "", false);
        CustomData data2 = new CustomData("", "", true);
        CustomData data3 = new CustomData("http://img.zcool.cn/community/01996b57a7f6020000018c1bedef97.jpg", "", false);
        arrList.add(data1);
        arrList.add(data2);
        arrList.add(data3);

        banner1.setAutoPlay(true)
                .setOffscreenPageLimit(list.size())
                .setPages(list, new HolderCreator<BannerViewHolder>() {
                    @Override
                    public BannerViewHolder createViewHolder() {
                        return new CustomViewHolder2();
                    }
                })
                .setOnBannerListener(this)
                .setBannerAnimation(Transformer.Scale)
                .start();

        banner2.setAutoPlay(true)
                .setOffscreenPageLimit(list.size())
                .setPages(arrList, new HolderCreator<BannerViewHolder>() {
                    @Override
                    public BannerViewHolder createViewHolder() {
                        return new CustomViewHolder3();
                    }
                })
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public void onBannerClick(int position) {

    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner1.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner1.stopAutoPlay();
    }
}
