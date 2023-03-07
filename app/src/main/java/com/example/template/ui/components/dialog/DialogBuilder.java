package com.example.template.ui.components.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.example.template.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DialogBuilder {

    public static void showWarningDialog(Context context, int message) {
        new MaterialAlertDialogBuilder(context)
                .setTitle(R.string.warning)
                .setMessage(message)
                .setIcon(R.mipmap.warning)
                .setPositiveButton(R.string.ok, null)
                .show();
    }

    public static void showSimpleDialog(Context context, int message) {
        new MaterialAlertDialogBuilder(context)
                .setMessage(message)
                .show();
    }

    public static void showSimpleDialog(Context context, int title, int message, int positiveButtonText) {
        new MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, null)
                .show();
    }

    public static void showSimpleDialog(Context context, int title, int message, int positiveButtonText, DialogInterface.OnClickListener positiveButtonListener) {
        new MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, positiveButtonListener)
                .show();
    }

    public static void showSimpleDialog(Context context, int title, int message, int positiveButtonText, int negativeButtonText, DialogInterface.OnClickListener positiveButtonListener, DialogInterface.OnClickListener negativeButtonListener) {
        new MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, positiveButtonListener)
                .setNegativeButton(negativeButtonText, negativeButtonListener)
                .show();
    }

    public static void showListDialog(Context context, int title, int positiveButtonText, DialogInterface.OnClickListener positiveButtonListener, CharSequence[] items, DialogInterface.OnClickListener onSelectListener) {
        new MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setPositiveButton(positiveButtonText, positiveButtonListener)
                .setItems(items, onSelectListener)
                .show();
    }

    /**
     * @param items     CharSequence[] choices = {"Choice1", "Choice2", "Choice3"};
     */
    public static void showSingleSelectDialog(Context context, int title, int positiveButtonText, DialogInterface.OnClickListener positiveButtonListener, CharSequence[] items, int selectedPosition, DialogInterface.OnClickListener onSelectListener) {
        new MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setPositiveButton(positiveButtonText, positiveButtonListener)
                .setSingleChoiceItems(items, selectedPosition, onSelectListener)
                .show();
    }

    /**
     * 可以创建一个Adapter实现ListAdapter接口来实现自定义item的样式
     */
    public static void showSingleSelectDialog(Context context, int title, int positiveButtonText, DialogInterface.OnClickListener positiveButtonListener, ListAdapter adapter, int selectedPosition, DialogInterface.OnClickListener onSelectListener) {
        new MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setPositiveButton(positiveButtonText, positiveButtonListener)
                .setSingleChoiceItems(adapter, selectedPosition, onSelectListener)
                .show();
    }

    /**
     * @param items         CharSequence[] choices = {"Choice1", "Choice2", "Choice3"};
     * @param checkedItems  boolean[] selectStatus={true, false, true};
     */
    public static void showMultiSelectDialog(Context context, int title, int positiveButtonText, DialogInterface.OnClickListener positiveButtonListener, CharSequence[] items, boolean[] checkedItems, DialogInterface.OnMultiChoiceClickListener onSelectListener) {
        new MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setPositiveButton(positiveButtonText, positiveButtonListener)
                .setMultiChoiceItems(items, checkedItems, onSelectListener)
                .show();
    }

}
