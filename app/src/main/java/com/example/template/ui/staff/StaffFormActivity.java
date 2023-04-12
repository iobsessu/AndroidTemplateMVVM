package com.example.template.ui.staff;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.staff.vm.StaffFormState;
import com.example.template.util.StaffFormValidator;
import com.kunminx.architecture.ui.page.BaseActivity;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.xuexiang.xui.utils.XToastUtils;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.lang.RegexPool;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ReUtil;

public class StaffFormActivity extends BaseActivity {

    private StaffFormState state;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, StaffFormActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentList();
    }

    private void initFragmentList() {
        List<BaseViewPagerFragment> fragmentList = new ArrayList<>();
        StaffBasicFormFragment basicFormFragment = new StaffBasicFormFragment();
        basicFormFragment.setTitle(R.string.basic_info);
        fragmentList.add(basicFormFragment);
        StaffAdditionalFormFragment additionalFormFragment = new StaffAdditionalFormFragment();
        additionalFormFragment.setTitle(R.string.additional_info);
        fragmentList.add(additionalFormFragment);
        state.fragmentList.set(fragmentList);
    }

    @Override
    protected void initViewModel() {
        state = getActivityScopeViewModel(StaffFormState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_staff_form, BR.vm, state)
                .addBindingParam(BR.click, new StaffFormClickProxy());
    }

    public class StaffFormClickProxy {

        public void submit() {
            if (!StaffFormValidator.isValid(state)) {
                return;
            }
            XToastUtils.info("执行提交数据的操作");
        }

    }

}
