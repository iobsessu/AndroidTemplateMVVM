package com.example.template.ui.layout_manager;

import android.content.Context;

import com.kunminx.binding_recyclerview.layout_manager.WrapContentGridLayoutManager;
import com.kunminx.binding_recyclerview.layout_manager.WrapContentLinearLayoutManager;

public class Layout1 extends WrapContentLinearLayoutManager {
    public Layout1(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

//    public Layout1(Context context, int spanCount, int orientation, boolean reverseLayout) {
//        super(context, spanCount, orientation, reverseLayout);
//    }
}
