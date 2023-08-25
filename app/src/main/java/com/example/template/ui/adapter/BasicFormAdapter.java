package com.example.template.ui.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.R;
import com.example.template.data.bean.FormItem;
import com.example.template.data.bean.Staff;
import com.example.template.databinding.LayoutFormDateBinding;
import com.example.template.databinding.LayoutFormInputBinding;
import com.example.template.databinding.LayoutFormInputHorizontalBinding;
import com.example.template.databinding.LayoutFormSelectBinding;
import com.example.template.databinding.LayoutFormSwitchBinding;
import com.example.template.util.FormUtil;
import com.example.template.util.ResUtil;
import com.kunminx.architecture.ui.state.State;
import com.kunminx.binding_recyclerview.adapter.BaseDataBindingAdapter;

public class BasicFormAdapter extends BaseDataBindingAdapter<FormItem, ViewDataBinding> {

    private Staff staff;

    public BasicFormAdapter(Context context, Staff staff) {
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
        } else {
            return R.layout.layout_form_input;
        }
    }

    @Override
    protected void onBindItem(ViewDataBinding dataBinding, FormItem formItem, RecyclerView.ViewHolder holder) {
        if (dataBinding instanceof LayoutFormInputBinding) {
            LayoutFormInputBinding binding = ((LayoutFormInputBinding) dataBinding);
            renderInput(binding, formItem, holder);
        } else if (dataBinding instanceof LayoutFormSwitchBinding) {
            ((LayoutFormSwitchBinding) dataBinding).setItem(formItem);
        } else if (dataBinding instanceof LayoutFormDateBinding) {
            LayoutFormDateBinding binding = (LayoutFormDateBinding) dataBinding;
            renderDate(binding, formItem, holder);
        } else if (dataBinding instanceof LayoutFormSelectBinding) {
            LayoutFormSelectBinding binding = ((LayoutFormSelectBinding) dataBinding);
            renderSelect(binding, formItem, holder);
        }
    }

    @Override
    public int getItemViewType(int position) {
        FormItem formItem = (FormItem) getCurrentList().get(position);
        return formItem.getType();
    }

    private void renderInput(LayoutFormInputBinding binding, FormItem formItem, RecyclerView.ViewHolder holder) {
        binding.setItem(formItem);
        switch (formItem.getFieldName()) {
            case "name":
                binding.value.setText(staff.getName());
                break;
            case "idNumber":
                binding.value.setText(staff.getIdNumber());
                break;
            case "phoneNumber":
                binding.value.setText(staff.getPhoneNumber());
                break;
            case "email":
                binding.value.setText(staff.getEmail());
                break;
            case "address":
                binding.value.setText(staff.getAddress());
                break;
            case "departmentName":
                binding.value.setText(staff.getDepartmentName());
                break;
            case "positionName":
                binding.value.setText(staff.getPositionName());
                break;
            case "jobNumber":
                binding.value.setText(staff.getJobNumber());
                break;
            case "workLocation":
                binding.value.setText(staff.getWorkLocation());
                break;
        }
        bindTextChangeListener(binding, formItem.getFieldName());
        binding.value.setError(formItem.getErrorMessage());
        binding.value.setErrorColor(ResUtil.getColor(R.color.successful));
    }

    private void bindTextChangeListener(LayoutFormInputBinding binding, String fieldName) {
        binding.value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String value = editable.toString();
                switch (fieldName) {
                    case "name":
                        staff.setName(value);
                        break;
                    case "idNumber":
                        staff.setIdNumber(value);
                        break;
                }
            }
        });
    }

    private void renderDate(LayoutFormDateBinding binding, FormItem formItem, RecyclerView.ViewHolder holder) {
        binding.setItem(formItem);
        switch (formItem.getFieldName()) {
            case "birthDate":
                binding.value.setText(FormUtil.appendBirthDateStr(staff.getBirthDate()));
                break;
        }
        binding.value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view.getId(), formItem, getCurrentList().indexOf(formItem));
            }
        });
    }

    private void renderSelect(LayoutFormSelectBinding binding, FormItem formItem, RecyclerView.ViewHolder holder) {
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
