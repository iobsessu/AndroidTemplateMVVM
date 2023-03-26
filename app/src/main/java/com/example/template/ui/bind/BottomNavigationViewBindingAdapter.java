package com.example.template.ui.bind;

import android.app.Activity;
import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.template.R;
import com.example.template.ui.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationViewBindingAdapter {

    @BindingAdapter(value = {"navController"}, requireAll = false)
    public static void navController(BottomNavigationView navView, NavController navController) {
        NavigationUI.setupWithNavController(navView, navController);
    }



}
