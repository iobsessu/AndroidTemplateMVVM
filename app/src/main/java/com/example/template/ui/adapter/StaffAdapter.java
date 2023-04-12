package com.example.template.ui.adapter;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.data.bean.Staff;
import com.example.template.databinding.RecommendPlayItemBinding;
import com.example.template.databinding.StaffListItemBinding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import java.util.List;

public class StaffAdapter extends SimpleDataBindingAdapter<Staff, StaffListItemBinding> {

    private Context context;

    public StaffAdapter(Context context) {
        super(context, R.layout.staff_list_item, DiffUtils.getInstance().getStaffItemCallback());
        this.context = context;
    }
    @Override
    protected void onBindItem(StaffListItemBinding binding, Staff item, RecyclerView.ViewHolder holder) {
        binding.setItem(item);

//        Glide.with(context)
//                .load(item.getImageUrl())
//                .into(binding.image);
//        setLastItemMargin(binding, item);
    }

    private void setLastItemMargin(RecommendPlayItemBinding binding, Staff item) {
        List<Staff> list = getCurrentList();
        Staff lastItem = list.get(getItemCount() - 1);
        if (item.equals(lastItem)) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            int margin = AppApplication.getInstance().getResources().getDimensionPixelSize(R.dimen.margin_medium);
            params.setMargins(margin, 0, margin, 0);
            binding.wrapper.setLayoutParams(params);
        }
    }
}
