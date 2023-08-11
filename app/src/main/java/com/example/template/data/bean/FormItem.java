package com.example.template.data.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.template.BR;

import java.io.Serializable;
import java.util.Objects;

public class FormItem extends BaseObservable implements Serializable {

    public static final int INPUT_HORIZONTAL = 0;
    public static final int INPUT_VERTICAL = 1;
    public static final int SWITCH = 2;
    public static final int DATE = 3;
    public static final int SINGLE_SELECT = 4;

    public String label;
    private String value;
    private String fieldName;
    private boolean visible;
    private int type;
    private int maxLength;
    private boolean required;
    private boolean showError;
    private String errorMessage;
    private String hint;

    public FormItem(String label, String value, String fieldName) {
        this.label = label;
        this.value = value;
        this.fieldName = fieldName;
    }

    public FormItem(String label, String fieldName) {
        this.label = label;
        this.fieldName = fieldName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Bindable
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isShowError() {
        return showError;
    }

    public void setShowError(boolean showError) {
        this.showError = showError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormItem formItem = (FormItem) o;
        return visible == formItem.visible && type == formItem.type && maxLength == formItem.maxLength && required == formItem.required && showError == formItem.showError && Objects.equals(label, formItem.label) && Objects.equals(value, formItem.value) && Objects.equals(fieldName, formItem.fieldName) && Objects.equals(errorMessage, formItem.errorMessage) && Objects.equals(hint, formItem.hint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, value, fieldName, visible, type, maxLength, required, showError, errorMessage, hint);
    }
}
