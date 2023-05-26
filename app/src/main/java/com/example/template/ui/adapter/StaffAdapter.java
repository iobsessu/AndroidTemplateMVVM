package com.example.template.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.data.bean.Staff;
import com.example.template.databinding.RecommendPlayItemBinding;
import com.example.template.databinding.StaffListItemBinding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import java.util.Collections;
import java.util.List;

public class StaffAdapter extends SimpleDataBindingAdapter<Staff, StaffListItemBinding> implements ListPreloader.PreloadModelProvider<Staff> {

    private Context context;
    private ViewPreloadSizeProvider preloadSizeProvider;

    public StaffAdapter(Context context, ViewPreloadSizeProvider preloadSizeProvider) {
        super(context, R.layout.staff_list_item, DiffUtils.getInstance().getStaffItemCallback());
        this.context = context;
        this.preloadSizeProvider = preloadSizeProvider;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StaffListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), this.getLayoutResId(viewType), parent, false);
        preloadSizeProvider.setView(binding.avatar);
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    protected void onBindItem(StaffListItemBinding binding, Staff item, RecyclerView.ViewHolder holder) {
        binding.setItem(item);
        Glide.with(context)
                .load(item.getAvatar())
                .into(binding.avatar);
    }

    @NonNull
    @Override
    public List<Staff> getPreloadItems(int position) {
        return getCurrentList().subList(position, position + 1);
    }

    @Nullable
    @Override
    public RequestBuilder<?> getPreloadRequestBuilder(@NonNull Staff item) {
        return Glide.with(context)
                .load(item.getAvatar());
    }
}
