package com.example.template.ui.calendar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.template.BR;
import com.example.template.R;
import com.example.template.databinding.FragmentCalendarBinding;
import com.example.template.ui.base.BaseViewPagerFragment;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.kunminx.architecture.ui.page.BaseFragment;
import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.kunminx.architecture.ui.page.StateHolder;
import com.kunminx.architecture.ui.state.State;

import java.util.HashMap;
import java.util.Map;

public class CalendarFragment extends BaseViewPagerFragment implements
        CalendarView.OnCalendarSelectListener,
        CalendarView.OnYearChangeListener {

    private CalendarState state;
    private FragmentCalendarBinding binding;
    @Override
    protected void initViewModel() {
        state = getFragmentScopeViewModel(CalendarState.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        Log.d("xxx", "calendar");
        return new DataBindingConfig(R.layout.fragment_calendar, BR.vm, state);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = (FragmentCalendarBinding) getBinding();

        initCalendarView();

    }

    private void initCalendarView() {
        state.year.set(binding.calendarView.getCurYear() + "年");

        int year = binding.calendarView.getCurYear();
        int month = binding.calendarView.getCurMonth();

//        Map<String, Calendar> map = new HashMap<>();
//        map.put(getSchemeCalendar(year, month, 3, 0xFF40db25, "假").toString(),
//                getSchemeCalendar(year, month, 3, 0xFF40db25, "假"));
//        map.put(getSchemeCalendar(year, month, 6, 0xFFe69138, "事").toString(),
//                getSchemeCalendar(year, month, 6, 0xFFe69138, "事"));
//        map.put(getSchemeCalendar(year, month, 9, 0xFFdf1356, "议").toString(),
//                getSchemeCalendar(year, month, 9, 0xFFdf1356, "议"));
//        map.put(getSchemeCalendar(year, month, 13, 0xFFedc56d, "记").toString(),
//                getSchemeCalendar(year, month, 13, 0xFFedc56d, "记"));
//        map.put(getSchemeCalendar(year, month, 14, 0xFFedc56d, "记").toString(),
//                getSchemeCalendar(year, month, 14, 0xFFedc56d, "记"));
//        map.put(getSchemeCalendar(year, month, 15, 0xFFaacc44, "假").toString(),
//                getSchemeCalendar(year, month, 15, 0xFFaacc44, "假"));
//        map.put(getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记").toString(),
//                getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记"));
//        map.put(getSchemeCalendar(year, month, 25, 0xFF13acf0, "假").toString(),
//                getSchemeCalendar(year, month, 25, 0xFF13acf0, "假"));
//        map.put(getSchemeCalendar(year, month, 27, 0xFF13acf0, "多").toString(),
//                getSchemeCalendar(year, month, 27, 0xFF13acf0, "多"));
//        //此方法在巨大的数据量上不影响遍历性能，推荐使用
//        binding.calendarView.setSchemeDate(map);

//        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        binding.recyclerView.addItemDecoration(new GroupItemDecoration<String, Article>());
//        binding.recyclerView.setAdapter(new ArticleAdapter(this));
//        binding.recyclerView.notifyDataSetChanged();

        binding.monthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                binding.calendarView.showYearSelectLayout(2022);
            }
        });
        binding.calendarView.setOnCalendarSelectListener(this);
        binding.calendarView.setOnYearChangeListener(this);
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800, "假");
        calendar.addScheme(0xFF008800, "节");
        return calendar;
    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

        Log.e("xxxa", "xxaw");
    }

    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        Log.e("xxxa", "xxaw");
    }

    @Override
    public void onYearChange(int year) {

    }

    public static class CalendarState extends StateHolder {

        public final State<String> year = new State<String>("");
//        public final State<String>
    }
}
