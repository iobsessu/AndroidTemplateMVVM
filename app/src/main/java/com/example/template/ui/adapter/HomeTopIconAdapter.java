package com.example.template.ui.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.template.R;
import com.example.template.data.bean.Icon;
import com.example.template.databinding.HomeTopIconItemBinding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

public class HomeTopIconAdapter extends SimpleDataBindingAdapter<Icon, HomeTopIconItemBinding> {

    private Context context;

    public HomeTopIconAdapter(Context context) {
        super(context, R.layout.home_top_icon_item, DiffUtils.getInstance().getIconItemCallback());
        this.context = context;
    }
    @Override
    protected void onBindItem(HomeTopIconItemBinding binding, Icon item, RecyclerView.ViewHolder holder) {
        binding.setItem(item);

        Glide.with(context)
                .load(item.getIconRes())
                .into(binding.image);
    }

}
