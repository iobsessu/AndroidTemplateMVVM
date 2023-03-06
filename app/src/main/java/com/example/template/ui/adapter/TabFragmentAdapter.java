package com.example.template.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.template.ui.base.BaseViewPagerFragment;

import java.util.List;

public class TabFragmentAdapter extends FragmentStateAdapter {

    private List<BaseViewPagerFragment> fragmentList;
    private List<String> titleList;
    public TabFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<BaseViewPagerFragment> fragmentList) {
        super(fragmentActivity);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
