package com.example.template.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.template.ui.components.musicListFragment.MusicListFragment;
import com.kunminx.architecture.ui.page.BaseFragment;

import java.util.List;

public class FragmentAdapter extends FragmentStateAdapter {

    private List<MusicListFragment> fragmentList;

    public FragmentAdapter(@NonNull FragmentActivity activity, List<MusicListFragment> fragmentList) {
        super(activity);
        this.fragmentList = fragmentList;
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
