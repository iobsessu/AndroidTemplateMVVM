package com.example.template.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.home.HomeFragment;
import com.example.template.ui.my.MyFragment;
import com.example.template.ui.product.ProductFragment;
import com.example.template.ui.calendar.CalendarFragment;
import com.kunminx.architecture.ui.page.BaseActivity;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private MainActivityState state;
//    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = (ActivityMainBinding) getBinding();
        initFragmentList();
    }

    private void initFragmentList() {
        List<BaseViewPagerFragment> fragmentList = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setTitle(R.string.discover);
        homeFragment.setIcon(R.mipmap.faxian);
        fragmentList.add(homeFragment);

        ProductFragment productFragment = new ProductFragment();
        productFragment.setTitle(R.string.community);
        productFragment.setIcon(R.mipmap.shequ);
        fragmentList.add(productFragment);

        CalendarFragment calendarFragment = new CalendarFragment();
        calendarFragment.setTitle(R.string.follow);
        calendarFragment.setIcon(R.mipmap.wodeguanzhu);
        fragmentList.add(calendarFragment);

        MyFragment myFragment = new MyFragment();
        myFragment.setTitle(R.string.my);
        myFragment.setIcon(R.mipmap.wodeguanzhu);
        fragmentList.add(myFragment);


        state.fragmentList.set(fragmentList);
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initViewModel() {
//
        state = getActivityScopeViewModel(MainActivityState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.vm, state);
    }

    public static class MainActivityState extends StateHolder {
        public State<List<BaseViewPagerFragment>> fragmentList = new State<>(new ArrayList<>());
        public State<Boolean> scrollEnabled = new State<>(false);
    }

}
