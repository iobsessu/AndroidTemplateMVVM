package com.example.template.ui.bind;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.template.R;
import com.example.template.ui.adapter.FragmentAdapter;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.kunminx.architecture.ui.page.BaseFragment;

import java.util.List;

public class TabPageBindingAdapter {

    @BindingAdapter(value = {"fragmentList"}, requireAll = false)
    public static void fragmentList(ViewPager2 viewPager2, List<BaseViewPagerFragment> fragmentList) {
        FragmentAdapter fragmentAdapter = new FragmentAdapter((FragmentActivity) viewPager2.getContext(), fragmentList);
        viewPager2.setAdapter(fragmentAdapter);

        TabLayout tabLayout = viewPager2.getRootView().findViewById(R.id.tab_layout);
        TabLayout.Tab tab;
        for(int i = 0; i < fragmentList.size(); i++) {
            tab = tabLayout.newTab();
            tabLayout.addTab(tab);
        }

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab1, position) -> {
                    tab1.setText(fragmentList.get(position).getTitle());
                    tab1.setIcon(fragmentList.get(position).getIcon());
                }
        ).attach();
    }

    @BindingAdapter(value = "scrollEnabled", requireAll = false)
    public static void scrollEnabled(ViewPager2 viewPager2, boolean enabled) {
        viewPager2.setUserInputEnabled(enabled);
    }
}
