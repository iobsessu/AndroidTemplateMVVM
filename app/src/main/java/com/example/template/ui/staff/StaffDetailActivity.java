package com.example.template.ui.staff;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.common.Constants;
import com.example.template.data.bean.Staff;
import com.example.template.ui.adapter.TableAdapter;
import com.example.template.ui.staff.vm.StaffFormState;
import com.example.template.util.CloneUtils;
import com.example.template.util.FormUtil;
import com.kunminx.architecture.ui.page.BaseActivity;
import com.kunminx.architecture.ui.page.DataBindingConfig;

import cn.hutool.core.bean.BeanUtil;

public class StaffDetailActivity extends BaseActivity {

    private StaffFormState state;
    public TableAdapter tableAdapter;
    private ActivityResultLauncher<Intent> startForFormResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        state.originStaff.set(CloneUtils.deepClone(state.editingStaff.get()));
                        tableAdapter.setStaff(state.originStaff.get());
                        tableAdapter.notifyDataSetChanged();
                    }
                }
            });

    public static void actionStart(Context context, Staff staff) {
        Intent intent = new Intent(context, StaffDetailActivity.class);
        intent.putExtra(Constants.STAFF_KEY, staff);
        context.startActivity(intent);
    }

    @Override
    protected void initViewModel() {
        state = getApplicationScopeViewModel(StaffFormState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        getParameters();
        tableAdapter = new TableAdapter(this, state.originStaff.get());
        state.basicFormList.set(FormUtil.generateBasicFormItemListByStaff(state.originStaff.get()));
        return new DataBindingConfig(R.layout.activity_staff_detail, BR.vm, state)
                .addBindingParam(BR.click, new StaffDetailActivity.ClickProxy())
                .addBindingParam(BR.tableAdapter, tableAdapter);
    }

    private void getParameters() {
        Intent intent = getIntent();
        Staff staff = (Staff) intent.getSerializableExtra(Constants.STAFF_KEY);
        if (staff != null) {
            state.originStaff.set(staff);
            state.formStatus.set(Constants.FORM_STATUS_EDIT);
        }
    }

    public class ClickProxy {

        public void edit() {
            startForFormResult.launch(new Intent(StaffDetailActivity.this, StaffFormActivity.class));
        }

    }
}
