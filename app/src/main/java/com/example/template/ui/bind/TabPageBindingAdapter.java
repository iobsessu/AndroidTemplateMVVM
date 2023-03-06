package com.example.template.ui.bind;

import android.view.LayoutInflater;
import android.view.View;
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

import java.util.List;

public class TabPageBindingAdapter {

    @BindingAdapter(value = {"fragmentList"}, requireAll = false)
    public static void fragmentList(ViewPager2 viewPager2, List<BaseViewPagerFragment> fragmentList) {
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter((FragmentActivity) viewPager2.getContext(), fragmentList);
        viewPager2.setAdapter(tabFragmentAdapter);

        TabLayout tabLayout = viewPager2.getRootView().findViewById(R.id.tab_layout);
        TabLayout.Tab tab;
        for(int i = 0; i < fragmentList.size(); i++) {
            tab = tabLayout.newTab();
            tabLayout.addTab(tab);
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView icon = view.findViewById(R.id.icon);
                TextView title = view.findViewById(R.id.title);
                title.setTextColor(AppApplication.getInstance().getColor(R.color.primary_text));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView icon = view.findViewById(R.id.icon);
                TextView title = view.findViewById(R.id.title);
                title.setTextColor(AppApplication.getInstance().getColor(R.color.C_666666));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab1, position) -> {

                    View view = LayoutInflater.from(viewPager2.getContext()).inflate(R.layout.custom_tab, null);
                    ImageView icon = view.findViewById(R.id.icon);
                    TextView title = view.findViewById(R.id.title);
                    title.setText(fragmentList.get(position).getTitle());
                    icon.setImageResource(fragmentList.get(position).getIcon());
                    tab1.setCustomView(view);
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
