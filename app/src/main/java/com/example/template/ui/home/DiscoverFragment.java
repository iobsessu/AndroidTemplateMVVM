package com.example.template.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.data.bean.PlayList;
import com.example.template.ui.adapter.RecommendAdapter;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.layout_manager.Layout1;
import com.example.template.util.TokenUtil;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.xuexiang.xui.widget.banner.widget.banner.base.BaseBanner;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends BaseViewPagerFragment {

    private DiscoverState state;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        BarUtils.setStatusBarColor((AppCompatActivity) getActivity(), getActivity().getColor(R.color.primary_background));
//        BarUtils.setStatusBarLightMode((AppCompatActivity) getActivity(), true);
        initBanner();
        initData();
    }

    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(DiscoverState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_discover, BR.vm, state)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.bannerHandler, new BannerItemClickHandler());
    }

    private void initBanner() {
    }

    private void initData() {
        List<PlayList> list = new ArrayList<>();

        PlayList playList = new PlayList(1, "深度睡眠 |重度失眠者专用歌单", 69466562, "http://p2.music.126.net/g2_Gv0dtAicJ3ChTYu28_g==/1393081239628722.jpg?imageView=1&type=webp&thumbnail=246x0");
        list.add(playList);
        playList = new PlayList(2, "经典粤语合集【无损音质】黑胶唱片会员专属", 79722365, "http://p2.music.126.net/zAuVCW-cUvn29s9IxuQh-w==/109951167071306612.jpg?imageView=1&type=webp&thumbnail=246x0");
        list.add(playList);
        playList = new PlayList(3, "你总要一个人，经历些难捱的日子。", 43276521, "http://p2.music.126.net/omxC-mmwgGHbacIVBZYNkA==/109951163028873411.jpg?imageView=1&type=webp&thumbnail=246x0");
        list.add(playList);
        playList = new PlayList(4, "戳爷/黄老板/断眉/萌德/骚姆/比伯/烟卷", 42658565, "http://p2.music.126.net/sOWvFHC7alSUXHxmsTr1bQ==/109951163610820733.jpg?imageView=1&type=webp&thumbnail=246x0");
        list.add(playList);

        state.recommendPlayList.set(list);

        List<BannerItem> bannerItemList = new ArrayList<>();
        BannerItem bannerItem = new BannerItem();
        bannerItem.setTitle("Banner1");
        bannerItem.setImgUrl("https://i0.hdslb.com/bfs/banner/ee98c85722548d630957b4492be4dab9e5264782.jpg@1200w_300h_1c");
        bannerItemList.add(bannerItem);

        bannerItem = new BannerItem();
        bannerItem.setTitle("Banner2");
        bannerItem.setImgUrl("https://i0.hdslb.com/bfs/banner/20b573ed970ed1a9087ba77c88484df4097567dd.jpg@1200w_300h_1c");
        bannerItemList.add(bannerItem);

        bannerItem = new BannerItem();
        bannerItem.setTitle("Banner3");
        bannerItem.setImgUrl("https://i0.hdslb.com/bfs/banner/83ff182d67c3c89ff1836ebda6d3eeeb1e70f292.jpg@1200w_300h_1c.webp");
        bannerItemList.add(bannerItem);

        state.bannerList.set(bannerItemList);
    }



    public static class DiscoverState extends StateHolder {
        public RecommendAdapter adapter = new RecommendAdapter(AppApplication.getInstance());
        public State<List<BannerItem>> bannerList = new State<>(new ArrayList<>());
        public State<List<PlayList>> recommendPlayList = new State<>(new ArrayList<>());
        public State<Layout1> layout1State = new State<>(new Layout1(AppApplication.getInstance(),  GridLayoutManager.HORIZONTAL, false));
    }

    public class ClickProxy {
        public void logout() {
            TokenUtil.clearToken();
            getActivity().finish();
        }
    }

    public class BannerItemClickHandler implements BaseBanner.OnItemClickListener<BannerItem> {
        @Override
        public void onItemClick(View view, BannerItem item, int position) {
            Log.e("onItemClick:", item.title + " --- " + position);
        }
    }
}
