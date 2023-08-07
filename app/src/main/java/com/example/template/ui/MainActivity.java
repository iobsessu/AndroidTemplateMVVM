package com.example.template.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.global.PlayerState;
import com.example.template.ui.home.HomeFragment;
import com.example.template.ui.my.MyFragment;
import com.example.template.ui.play.PlayingActivity;
import com.example.template.ui.staff.StaffListFragment;
import com.example.template.ui.calendar.CalendarFragment;
import com.example.template.util.StatusBarUtil;
import com.kunminx.architecture.ui.page.BaseActivity;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private MainActivityState state;
    private PlayerState playerState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentList();
    }

    private void initFragmentList() {
        List<BaseViewPagerFragment> fragmentList = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setTitle(R.string.discover);
        homeFragment.setIcon(R.mipmap.faxian);
        fragmentList.add(homeFragment);

        StaffListFragment staffListFragment = new StaffListFragment();
        staffListFragment.setTitle(R.string.community);
        staffListFragment.setIcon(R.mipmap.shequ);
        fragmentList.add(staffListFragment);

        CalendarFragment calendarFragment = new CalendarFragment();
        calendarFragment.setTitle(R.string.follow);
        calendarFragment.setIcon(R.mipmap.wodeguanzhu);
        fragmentList.add(calendarFragment);

        MyFragment myFragment = new MyFragment();
        myFragment.setTitle(R.string.my);
        myFragment.setIcon(R.mipmap.wodeguanzhu);
        fragmentList.add(myFragment);

        state.fragmentList.set(fragmentList);

        state.navController = new State<>(Navigation.findNavController(this, R.id.nav_host_fragment_activity_main));
    }
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initViewModel() {
        state = getActivityScopeViewModel(MainActivityState.class);
        playerState = getApplicationScopeViewModel(PlayerState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.vm, state)
                .addBindingParam(BR.playerVm, playerState)
                .addBindingParam(BR.click, new ClickProxy());
    }

    public static class MainActivityState extends StateHolder {
        public State<List<BaseViewPagerFragment>> fragmentList = new State<>(new ArrayList<>());
        public State<Boolean> scrollEnabled = new State<>(false);
        public State<NavController> navController ;
    }

    public class ClickProxy {
        public void toPlaying() {
            PlayingActivity.actionStart(MainActivity.this);
        }
    }

}
