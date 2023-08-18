package com.example.template.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.databinding.LayoutTableItemBinding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

public class TableAdapter extends SimpleDataBindingAdapter<FormItem, LayoutTableItemBinding> {

    public TableAdapter(Context context) {
        super(context, R.layout.layout_table_item, DiffUtils.getInstance().getFormItemCallback());
    }

    @Override
    protected void onBindItem(LayoutTableItemBinding binding, FormItem formItem, RecyclerView.ViewHolder viewHolder) {
        binding.setItem(formItem);
        if (getCurrentList().indexOf(formItem) == getItemCount() - 1) {
            binding.textView.setShowDivider(false);
        }
        if ("workingStatus".equals(formItem.getFieldName())) {
            LinearLayout valueLayout = (LinearLayout) binding.textView.getValueLayout();
            valueLayout.removeAllViews();
            Button button = new Button(binding.textView.getContext());
            button.setText(formItem.getValue());
            valueLayout.addView(button);
        }
    }
}
