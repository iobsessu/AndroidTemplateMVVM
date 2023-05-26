package com.example.template.ui.components.calendarview;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 因无法继承多个类，所以用该接口替代GroupRecyclerAdapter
 * @param <Parent>
 * @param <Child>
 */
public interface MyGroupRecyclerAdapter<Parent, Child> {

    /**
     * 返回特定的标题
     */
    Parent getGroup(int groupPosition);

    /**
     * 获得分组的数量
     */
    int getGroupCount();

    /**
     * 获取某一组的数量
     */
    int getChildCount(int groupPosition);

    /**
     * 重置分组数据
     */
    void resetGroups(LinkedHashMap<Parent, List<Child>> groups, List<Parent> titles);

    /**
     * 清除分组数据
     */
    void clearGroup();

    /**
     * 从分组移除数据
     * @param position
     * @return
     */
    boolean removeGroupItem(int position);

    /**
     * 获取所在分组
     * @param position
     * @return
     */
    int getGroupIndex(int position);

    void removeGroupChildren(int groupPosition);
}
