package com.example.template.ui.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.template.R;
import com.example.template.data.bean.Article;
import com.example.template.data.bean.Music;
import com.example.template.databinding.ArticleItemBinding;
import com.example.template.databinding.MusicItem1Binding;
import com.example.template.ui.components.calendarview.MyGroupRecyclerAdapter;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ArticleAdapter extends SimpleDataBindingAdapter<Article, ArticleItemBinding> implements MyGroupRecyclerAdapter {

    private Context context;
    private LinkedHashMap<String, List<Article>> groups;
    private List<String> groupTitles;

    public ArticleAdapter(Context context) {
        super(context, R.layout.article_item, DiffUtils.getInstance().getArticleItemCallback());
        this.context = context;
        groups = new LinkedHashMap<>();
        groupTitles = new ArrayList<>();
        initData();
        resetGroups(groups, groupTitles);
    }

    private void initData() {
        List<Article> list = new ArrayList<>();
        Article article1 = new Article();
        article1.setTitle("新西兰克马德克群岛发生5.7级地震 震源深度10千米");
        article1.setContent("#地震快讯#中国地震台网正式测定：12月04日08时08分在克马德克群岛（南纬32.82度，西经178.73度）发生5.7级地震，震源深度10千米。");
        article1.setImgUrl("https://img-s-msn-com.akamaized.net/tenant/amp/entityid/AA1c1OCe.img?w=640&h=422&m=6");
        list.add(article1);
        article1 = new Article();
        article1.setTitle("一些事情");
        article1.setContent("你猜发生了什么");
        list.add(article1);
        LinkedHashMap<String, List<Article>> groups = new LinkedHashMap<>();
        groups.put("今日推荐", list);
        List<String> groupTitles = new ArrayList<>();
        groupTitles.add("今日推荐");
        resetGroups(groups, groupTitles);
    }

    @Override
    protected void onBindItem(ArticleItemBinding binding, Article item, RecyclerView.ViewHolder holder) {
        binding.setItem(item);
//        binding.title.setText(item.getTitle());
//        binding.title.setText(item.getTitle());
        Glide.with(context)
                .load(item.getImgUrl())
                .into(binding.image);
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupTitles.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groupTitles.size();
    }

    @Override
    public int getChildCount(int groupPosition) {
        if (groupTitles == null || groups.size() == 0)
            return 0;
        if (groups.get(groupTitles.get(groupPosition)) == null)
            return 0;
        return groups.get(groupTitles.get(groupPosition)).size();
    }

    @Override
    public void clearGroup() {
        groupTitles.clear();
        groups.clear();
        getCurrentList().clear();
        notifyDataSetChanged();
    }

    @Override
    public boolean removeGroupItem(int position) {
        int group = getGroupIndex(position);
        removeGroupChildren(group);
        int count = getChildCount(group);
        removeItem(position);
        if (count <= 0) {
            groupTitles.remove(group);
            return true;
        }
        return false;
    }

    protected final void removeItem(int position) {
        if (this.getItemCount() > position) {
            getCurrentList().remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public int getGroupIndex(int position) {
        int count = 0;
        if (position <= count)
            return 0;
        int i = 0;
        for (String parent : groups.keySet()) {
            count += groups.get(parent).size();
            if (position < count) {
                return i;
            }
            i++;
        }
        return 0;
    }

    @Override
    public void removeGroupChildren(int groupPosition) {
        if (groupPosition >= groupTitles.size())
            return;
        List<Article> childList = groups.get(groupTitles.get(groupPosition));
        if (childList != null && childList.size() != 0) {
            childList.remove(childList.size() - 1);
        }
    }

    @Override
    public void resetGroups(LinkedHashMap groups, List titles) {
        if (groups == null || titles == null) {
            return;
        }
        this.groups.clear();
        this.groupTitles.clear();
        this.groups.putAll(groups);
        this.groupTitles.addAll(titles);
        for (String key : this.groups.keySet()) {
//            getCurrentList().addAll(this.groups.get(key));
            submitList(this.groups.get(key));
        }
        notifyDataSetChanged();
    }
}
