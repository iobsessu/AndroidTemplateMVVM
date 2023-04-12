package com.example.template.ui.staff.vm;

import com.example.template.data.bean.OptionItem;
import com.example.template.data.bean.Staff;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;

import java.util.ArrayList;
import java.util.List;

public class StaffFormState extends StateHolder {

    public State<List<BaseViewPagerFragment>> fragmentList = new State<>(new ArrayList<>());
    public State<String> searchValue = new State<>("测试");
    public State<Staff> staff = new State<>(new Staff());
    public State<List<OptionItem>> genderOptionList = new State<>(new ArrayList<>());

    public State<String> idNumberError = new State<>("");
    public State<String> emailError = new State<>("");

}
