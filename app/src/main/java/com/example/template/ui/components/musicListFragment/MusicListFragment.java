package com.example.template.ui.components.musicListFragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

//import com.example.template.BR;
import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.data.bean.Music;
import com.example.template.data.bean.PlayList;
import com.example.template.databinding.FragmentMusicListBinding;
import com.example.template.ui.adapter.MusicListAdapter;
import com.example.template.ui.adapter.RecommendAdapter;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MusicListFragment extends BaseFragment {

    private MusicListState state;

    private MusicListFragment() {}
    private FragmentMusicListBinding binding;

    public static MusicListFragment getInstance(List<Music> musicList) {
        MusicListFragment fragment = new MusicListFragment();
        Bundle args = new Bundle();

        ArrayList<Music> arrayList = new ArrayList<>(musicList);
        args.putSerializable("musicList", arrayList);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(MusicListState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
//        return new DataBindingConfig(R.layout.fragment_music_list, BR.vm, state);
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initMusicData();
//        binding = (FragmentMusicListBinding) getBinding();
//        LinearLayout view1 = (LinearLayout) binding.getRoot();
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.rightMargin = 100;
//        view1.setLayoutParams(layoutParams);
    }

    private void initMusicData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            ArrayList<Music> musicList = (ArrayList<Music>) bundle.getSerializable("musicList");
            state.musicList.set(musicList);
        }
    }

    public static class MusicListState extends StateHolder {
        public State<List<Music>> musicList = new State<>(new ArrayList<>());
        public MusicListAdapter adapter = new MusicListAdapter(AppApplication.getInstance());
    }
}
