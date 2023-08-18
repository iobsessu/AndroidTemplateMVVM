package com.example.template.ui.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.data.bean.Staff;
import com.example.template.databinding.LayoutFormDateBinding;
import com.example.template.databinding.LayoutFormInputHorizontalBinding;
import com.example.template.databinding.LayoutFormSelectBinding;
import com.example.template.databinding.LayoutFormSwitchBinding;
import com.example.template.util.FormUtil;
import com.kunminx.architecture.ui.state.State;
import com.kunminx.binding_recyclerview.adapter.BaseDataBindingAdapter;

public class FormAdapter extends BaseDataBindingAdapter {

    Staff staff;

    public FormAdapter(Context context, Staff staff) {
        super(context, DiffUtils.getInstance().getFormItemCallback());
        this.staff = staff;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        if (viewType == FormItem.SWITCH) {
            return R.layout.layout_form_switch;
        } else if (viewType == FormItem.DATE) {
            return R.layout.layout_form_date;
        } else if (viewType == FormItem.SINGLE_SELECT) {
            return R.layout.layout_form_select;
        } else if (viewType == FormItem.INPUT_VERTICAL) {
            return R.layout.layout_form_input_horizontal;
        } else {
            return R.layout.layout_form_input_horizontal;
        }
    }

    @Override
    protected void onBindItem(ViewDataBinding dataBinding, Object item, RecyclerView.ViewHolder holder) {
        FormItem formItem = (FormItem) item;
        if (dataBinding instanceof LayoutFormInputHorizontalBinding) {
            LayoutFormInputHorizontalBinding binding = ((LayoutFormInputHorizontalBinding) dataBinding);
            (binding).setItem(formItem);
            bindTextChangeListener(binding, formItem.getFieldName());
            bindTextFilter(binding, formItem.getFieldName());
        } else if (dataBinding instanceof LayoutFormSwitchBinding) {
            ((LayoutFormSwitchBinding) dataBinding).setItem((FormItem) item);
        } else if (dataBinding instanceof LayoutFormDateBinding) {
            ((LayoutFormDateBinding) dataBinding).setItem((FormItem) item);
        } else if (dataBinding instanceof LayoutFormSelectBinding) {
            LayoutFormSelectBinding binding = ((LayoutFormSelectBinding) dataBinding);
            (binding).setItem(formItem);
            switch (formItem.getFieldName()) {
                case "gender":
                    binding.value.setText(FormUtil.formatGender(staff.getGender()));
                    break;
                case "workingStatus":
                    binding.value.setText(FormUtil.formatWorkStatus(staff.getWorkingStatus()));
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        FormItem formItem = (FormItem) getCurrentList().get(position);
        return formItem.getType();
    }

    private void bindTextChangeListener(LayoutFormInputHorizontalBinding binding, String fieldName) {
        binding.value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                switch (fieldName) {
                    case "name":
                        staff.setName(editable.toString());
                        break;
                }
            }
        });
    }

    private void bindTextFilter(LayoutFormInputHorizontalBinding binding, String fieldName) {
        switch (fieldName) {
            case "idNumber":
                InputFilter[] filters = new InputFilter[2];
                filters[0] = new InputFilter.LengthFilter(18);
                filters[1] =  (CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) -> {
                    // 如果输入的是X，且已经输入了17位数字，允许输入
                    if (spanned.length() == 17 && (charSequence.equals("X") || charSequence.equals("x"))) {
                        return charSequence;
                    }
                    // 如果输入的是数字，且没有超过18位，允许输入
                    if (charSequence.toString().matches("[0-9]") && spanned.length() < 18) {
                        return charSequence;
                    }
                    // 其他情况，不允许输入
                    return "";
                };
                binding.value.setFilters(filters);
                break;
            default:
                binding.value.setFilters(new InputFilter[]{});

        }


    }
}
