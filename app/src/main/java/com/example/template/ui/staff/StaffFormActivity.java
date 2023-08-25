package com.example.template.ui.staff;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.data.bean.Staff;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.example.template.ui.staff.vm.StaffFormState;
import com.example.template.util.CloneUtils;
import com.example.template.util.StaffFormValidator;
import com.kunminx.architecture.ui.page.BaseActivity;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.utils.ToastUtils;

import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.bean.BeanUtil;
import es.dmoral.toasty.Toasty;

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
//        registerForActivityResult()

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
        state = getApplicationScopeViewModel(StaffFormState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        state.editingStaff.set(CloneUtils.deepClone(state.originStaff.get()));
        return new DataBindingConfig(R.layout.activity_staff_form, BR.vm, state)
                .addBindingParam(BR.click, new StaffFormClickProxy());
    }

    public class StaffFormClickProxy {

        public void onSave() {
            if (!StaffFormValidator.isValid(state)) {
                Toasty.error(StaffFormActivity.this, R.string.save_failed);
                StaffBasicFormFragment basicFormFragment = (StaffBasicFormFragment) state.fragmentList.get().get(0);
                basicFormFragment.refresh();
                return;
            }
            Toasty.success(StaffFormActivity.this, R.string.save_successfully);
            Intent intent = new Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

    }

}
