package com.example.template.ui.bind;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.ui.adapter.FragmentAdapter;
import com.example.template.ui.adapter.TabFragmentAdapter;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.components.musicListFragment.MusicListFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.kunminx.architecture.ui.page.BaseFragment;

import java.util.List;

public class TabPageBindingAdapter {

    @BindingAdapter(value = {"fragmentList"}, requireAll = false)
    public static void fragmentList(ViewPager2 viewPager2, List<BaseViewPagerFragment> fragmentList) {
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter((FragmentActivity) viewPager2.getContext(), fragmentList);
        viewPager2.setAdapter(tabFragmentAdapter);
        bindViewPager2WithTabLayout(viewPager2, fragmentList);
    }

    /**
     * 将ViewPager2与第一个同级的TabLayout绑定
     * （为了不在activity里用getBinding()手动获取视图）
     * 目前没有找到更好的解决方案。希望以后会碰到。
     */
    private static void bindViewPager2WithTabLayout(ViewPager2 viewPager2, List<BaseViewPagerFragment> fragmentList) {
        ViewParent view = viewPager2.getParent();
        TabLayout tabLayout = null;
//        TabLayout tabLayout = viewPager2.getRootView().findViewById(R.id.tab_layout);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                View child = viewGroup.getChildAt(i);
                if (child instanceof TabLayout) {
                    tabLayout = (TabLayout) child;
                    break;
                }
            }
        }
        if(tabLayout == null) {
            return;
        }
        TabLayout.Tab tab;
        for(int i = 0; i < fragmentList.size(); i++) {
            tab = tabLayout.newTab();
            tabLayout.addTab(tab);
        }

        new TabLayoutMediator(tabLayout, viewPager2, false, false,
                (tabItem, position) -> {
                    tabItem.setText(fragmentList.get(position).getTitle());
////                    View view = LayoutInflater.from(viewPager2.getContext()).inflate(R.layout.custom_tab, null);
////                    ImageView icon = view.findViewById(R.id.icon);
////                    TextView title = view.findViewById(R.id.title);
////                    title.setText(fragmentList.get(position).getTitle());
////                    icon.setImageResource(fragmentList.get(position).getIcon());
////                    tab1.setCustomView(view);
                }
        ).attach();
    }

    @BindingAdapter(value = "scrollEnabled", requireAll = false)
    public static void scrollEnabled(ViewPager2 viewPager2, boolean enabled) {
        viewPager2.setUserInputEnabled(enabled);
    }

    @BindingAdapter(value = {"fragmentList1"}, requireAll = false)
    public static void fragmentList1(ViewPager2 viewPager2, List<MusicListFragment> fragmentList) {
        FragmentAdapter tabFragmentAdapter = new FragmentAdapter((FragmentActivity)viewPager2.getContext(), fragmentList);
        viewPager2.setAdapter(tabFragmentAdapter);
    }
}
