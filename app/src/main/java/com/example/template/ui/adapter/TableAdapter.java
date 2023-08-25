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
import com.example.template.data.bean.Staff;
import com.example.template.databinding.LayoutTableItemBinding;
import com.example.template.util.FormUtil;
import com.example.template.util.MyDateUtil;
import com.example.template.util.ResUtil;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import cn.hutool.core.util.NumberUtil;

public class TableAdapter extends SimpleDataBindingAdapter<FormItem, LayoutTableItemBinding> {

    private Staff staff;

    public TableAdapter(Context context, Staff staff) {
        super(context, R.layout.layout_table_item, DiffUtils.getInstance().getFormItemCallback());
        this.staff = staff;
    }

    @Override
    protected void onBindItem(LayoutTableItemBinding binding, FormItem item, RecyclerView.ViewHolder viewHolder) {
        binding.setItem(item);
        if (getCurrentList().indexOf(item) == getItemCount() - 1) {
            binding.textView.setShowDivider(false);
        }

        TextView valueView = binding.textView.getValueView();
        valueView.setTextColor(ResUtil.getColor(R.color.C_333333));
        switch (item.getFieldName()) {
            case "name":
                valueView.setText(staff.getName());
                break;
            case "gender":
                valueView.setText(FormUtil.formatGender(staff.getGender()));
                break;
            case "birthDate":
                valueView.setText(FormUtil.appendBirthDateStr(staff.getBirthDate()));
                break;
            case "idNumber":
                valueView.setText(staff.getIdNumber());
                break;
            case "phoneNumber":
                valueView.setText(staff.getPhoneNumber());
                break;
            case "email":
                valueView.setText(staff.getEmail());
                break;
            case "address":
                valueView.setText(staff.getAddress());
                break;
            case "departmentName":
                valueView.setText(staff.getDepartmentName());
                break;
            case "positionName":
                valueView.setText(staff.getPositionName());
                break;
            case "jobNumber":
                valueView.setText(staff.getJobNumber());
                break;
            case "hireDate":
                valueView.setText(MyDateUtil.format(staff.getHireDate()));
                break;
            case "workingStatus":
                if (staff.getWorkingStatus() == 0) {
                    valueView.setTextColor(ResUtil.getColor(R.color.successful));
                } else {
                    valueView.setTextColor(ResUtil.getColor(R.color.error));
                }
                valueView.setText(FormUtil.formatWorkStatus(staff.getWorkingStatus()));
                break;
            case "leaveDate":
                valueView.setText(MyDateUtil.format(staff.getLeaveDate()));
                break;
            case "workLocation":
                valueView.setText(staff.getWorkLocation());
                break;
            case "weeklyWorkingHours":
                valueView.setText(staff.getWeeklyWorkingHours() + ResUtil.getString(R.string.hour));
                break;
            case "salary":
                valueView.setText(NumberUtil.decimalFormat("###,###.00" + ResUtil.getString(R.string.yuan), staff.getSalary()));
                break;
            case "annualLeaveDays":
                valueView.setText(staff.getAnnualLeaveDays() + ResUtil.getString(R.string.day));
                break;
            case "healthStatus":
                valueView.setText(staff.getHealthStatus() + "");
                break;
        }
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
