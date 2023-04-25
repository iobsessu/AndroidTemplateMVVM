package com.example.template.ui.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.template.R;
import com.example.template.data.bean.Article;
import com.example.template.data.bean.Music;
import com.example.template.databinding.ArticleItemBinding;
import com.example.template.databinding.MusicItem1Binding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

public class ArticleAdapter extends SimpleDataBindingAdapter<Article, ArticleItemBinding> {

    private Context context;

    public ArticleAdapter(Context context) {
        super(context, R.layout.article_item, DiffUtils.getInstance().getArticleItemCallback());
        this.context = context;
    }
    @Override
    protected void onBindItem(ArticleItemBinding binding, Article item, RecyclerView.ViewHolder holder) {
        binding.setItem(item);

        Glide.with(context)
                .load(item.getImgUrl())
                .into(binding.image);
    }

}
