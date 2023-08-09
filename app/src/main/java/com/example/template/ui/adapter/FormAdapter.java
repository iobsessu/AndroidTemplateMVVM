package com.example.template.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.databinding.LayoutFormDateBinding;
import com.example.template.databinding.LayoutFormInputBinding;
import com.example.template.databinding.LayoutFormSwitchBinding;
import com.kunminx.binding_recyclerview.adapter.BaseDataBindingAdapter;

public class FormAdapter extends BaseDataBindingAdapter {


    public FormAdapter(Context context) {
        super(context, DiffUtils.getInstance().getFormItemCallback());
    }

    @Override
    protected int getLayoutResId(int viewType) {
        if (viewType == FormItem.SWITCH) {
            return R.layout.layout_form_switch;
        } else if (viewType == FormItem.DATE) {
            return R.layout.layout_form_date;
        } else {
            return R.layout.layout_form_input;
        }
    }

    @Override
    protected void onBindItem(ViewDataBinding binding, Object item, RecyclerView.ViewHolder holder) {

        if (binding instanceof LayoutFormInputBinding) {
            ((LayoutFormInputBinding) binding).setItem((FormItem) item);
        } else if (binding instanceof LayoutFormSwitchBinding) {
            ((LayoutFormSwitchBinding) binding).setItem((FormItem) item);
        } else if (binding instanceof LayoutFormDateBinding) {
            ((LayoutFormDateBinding) binding).setItem((FormItem) item);
        }
    }

    @Override
    public int getItemViewType(int position) {
        FormItem formItem = (FormItem) getCurrentList().get(position);
        return formItem.getType();
    }
}
