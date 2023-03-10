/*
 * Copyright 2018-present KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.template.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.template.data.bean.Icon;
import com.example.template.data.bean.Music;
import com.example.template.data.bean.PlayList;


/**
 * Create by KunMinX at 2020/7/19
 */
public class DiffUtils {

    private DiffUtil.ItemCallback<Icon> iconItemCallback;

    private DiffUtil.ItemCallback<PlayList> playListItemCallback;

    private DiffUtil.ItemCallback<Music> musicItemCallback;

    private DiffUtils() {
    }

    private static final DiffUtils S_DIFF_UTILS = new DiffUtils();

    public static DiffUtils getInstance() {
        return S_DIFF_UTILS;
    }

    public DiffUtil.ItemCallback<Icon> getIconItemCallback() {
        if (iconItemCallback == null) {
            iconItemCallback = new DiffUtil.ItemCallback<Icon>() {
                @Override
                public boolean areItemsTheSame(@NonNull Icon oldItem, @NonNull Icon newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull Icon oldItem, @NonNull Icon newItem) {
                    return oldItem.equals(newItem);
                }
            };
        }
        return iconItemCallback;
    }

    public DiffUtil.ItemCallback<PlayList> getPlayListItemCallback() {
        if (playListItemCallback == null) {
            playListItemCallback = new DiffUtil.ItemCallback<PlayList>() {
                @Override
                public boolean areItemsTheSame(@NonNull PlayList oldItem, @NonNull PlayList newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull PlayList oldItem, @NonNull PlayList newItem) {
                    return oldItem.equals(newItem);
                }
            };
        }
        return playListItemCallback;
    }

    public DiffUtil.ItemCallback<Music> getMusicItemCallback() {
        if (musicItemCallback == null) {
            musicItemCallback = new DiffUtil.ItemCallback<Music>() {
                @Override
                public boolean areItemsTheSame(@NonNull Music oldItem, @NonNull Music newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull Music oldItem, @NonNull Music newItem) {
                    return oldItem.equals(newItem);
                }
            };
        }
        return musicItemCallback;
    }

}
