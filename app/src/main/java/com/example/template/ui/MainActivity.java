package com.example.template.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.template.R;
import com.example.template.ui.adapter.FragmentAdapter;
import com.example.template.ui.home.HomeFragment;
import com.example.template.ui.product.ProductFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.kunminx.architecture.ui.page.BaseActivity;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private List<BaseFragment> fragmentList = new ArrayList<>();
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab_layout);
        initFragments();
        initTabs();
    }

    private void initFragments() {
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ProductFragment());
        fragmentAdapter = new FragmentAdapter(this, fragmentList);
        viewPager.setAdapter(fragmentAdapter);
    }

    private void initTabs() {
        new TabLayoutMediator(tabLayout, viewPager, ((tab, position) -> {
            if (position == 0) {
                tab.setText(R.string.home);
            } else if (position == 1) {
                tab.setText(R.string.reservation);
            }
        })).attach();
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
