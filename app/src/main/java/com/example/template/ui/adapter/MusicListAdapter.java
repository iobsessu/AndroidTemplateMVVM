package com.example.template.ui.adapter;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.template.R;
import com.example.template.app.AppApplication;
import com.example.template.data.bean.Music;
import com.example.template.data.bean.PlayList;
import com.example.template.databinding.MusicItem1Binding;
import com.example.template.databinding.RecommendPlayItemBinding;
import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;

import java.util.List;

public class MusicListAdapter extends SimpleDataBindingAdapter<Music, MusicItem1Binding> {

    private Context context;

    public MusicListAdapter(Context context) {
        super(context, R.layout.music_item_1, DiffUtils.getInstance().getMusicItemCallback());
        this.context = context;
    }
    @Override
    protected void onBindItem(MusicItem1Binding binding, Music item, RecyclerView.ViewHolder holder) {
        binding.setItem(item);

        Glide.with(context)
                .load(item.getImageUrl())
                .into(binding.image);
//        setLastItemMargin(binding, item);
    }

//    private void setLastItemMargin(RecommendPlayItemBinding binding, PlayList item) {
//        List<PlayList> list = getCurrentList();
//        PlayList lastItem = list.get(getItemCount() - 1);
//        if (item.equals(lastItem)) {
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT
//            );
//            int margin = AppApplication.getInstance().getResources().getDimensionPixelSize(R.dimen.margin_medium);
//            params.setMargins(margin, 0, margin, 0);
//            binding.wrapper.setLayoutParams(params);
//        }
//    }
}
