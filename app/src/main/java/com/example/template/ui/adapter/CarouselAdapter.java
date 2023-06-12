package com.example.template.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.template.R;
import com.example.template.data.bean.Carousel;
import com.example.template.databinding.CarouselItemBinding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

public class CarouselAdapter extends SimpleDataBindingAdapter<Carousel, CarouselItemBinding> {

    private Context context;

    public CarouselAdapter(Context context) {
        super(context, R.layout.carousel_item, DiffUtils.getInstance().getCarouselItemCallback());
        this.context = context;
    }

    @Override
    protected void onBindItem(CarouselItemBinding binding, Carousel item, RecyclerView.ViewHolder holder) {
        binding.setItem(item);
        Glide.with(context).load(item.imgUrl2).centerCrop().into(binding.carouselImageView);
//        binding.carouselItemContainer.setOnClickListener(view -> listener.onItemClicked(item, item));
    }

}
