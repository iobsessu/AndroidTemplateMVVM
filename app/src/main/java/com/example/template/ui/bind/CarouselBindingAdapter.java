package com.example.template.ui.bind;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarouselBindingAdapter {

    @BindingAdapter(value = {"nestedScrollingEnabled"}, requireAll = false)
    public static void nestedScrollingEnabled(RecyclerView recyclerView, boolean b) {
        recyclerView.setNestedScrollingEnabled(b);
    }

}
