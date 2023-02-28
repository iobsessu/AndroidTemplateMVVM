package com.example.template.util;

import android.content.Context;
import android.os.Parcelable;

import com.tencent.mmkv.MMKV;

import java.util.Set;

/**
 * MMKV工具类
 */
public class MMKVUtil {

    private static MMKV mmkv;

    public static void init(Context context) {
        MMKV.initialize(context);
        mmkv = MMKV.defaultMMKV();
    }

    public static MMKV getMMKV() {
        if (mmkv == null) {
            mmkv = MMKV.defaultMMKV();
        }
        return mmkv;
    }

    public static boolean put(String key, Object value) {
        if (value instanceof Integer) {
            return getMMKV().encode(key, (Integer)value);
        } else if (value instanceof Float) {
            return getMMKV().encode(key, (Float) value);
        } else if (value instanceof String) {
            return getMMKV().encode(key, (String) value);
        } else if (value instanceof Boolean) {
            return getMMKV().encode(key, (Boolean) value);
        } else if (value instanceof Long) {
            return getMMKV().encode(key, (Long) value);
        } else if (value instanceof Double) {
            return getMMKV().encode(key, (Double) value);
        } else if (value instanceof Parcelable) {
            return getMMKV().encode(key, (Parcelable) value);
        } else if (value instanceof byte[]) {
            return getMMKV().encode(key, (byte[]) value);
        } else if (value instanceof Set) {
            return getMMKV().encode(key, (Set<String>) value);
        }
        return false;
    }

    public static Object get(String key, Object defaultValue) {
        if (defaultValue instanceof Integer) {
            return getMMKV().decodeInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Float) {
            return getMMKV().decodeFloat(key, (Float) defaultValue);
        } else if (defaultValue instanceof String) {
            return getMMKV().decodeString(key, (String) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return getMMKV().decodeBool(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Long) {
            return getMMKV().decodeLong(key, (Long) defaultValue);
        } else if (defaultValue instanceof Double) {
            return getMMKV().decodeDouble(key, (Double) defaultValue);
        } else if (defaultValue instanceof byte[]) {
            return getMMKV().decodeBytes(key);
        } else if (defaultValue instanceof Set) {
            return getMMKV().decodeStringSet(key, (Set<String>) defaultValue);
        }
        return null;
    }

    public static boolean getBoolean(String key, boolean defValue) {
        try {
            return getMMKV().getBoolean(key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;
    }

    public static long getLong(String key, long defValue) {
        try {
            return getMMKV().getLong(key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;
    }

    public static float getFloat(String key, float defValue) {
        try {
            return getMMKV().getFloat(key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;
    }

    public static String getString(String key, String defValue) {
        try {
            return getMMKV().getString(key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;
    }

    public static int getInt(String key, int defValue) {
        try {
            return getMMKV().getInt(key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;
    }

    public static double getDouble(String key, double defValue) {
        try {
            return getMMKV().decodeDouble(key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;
    }

    public static boolean containsKey(String key) {
        return getMMKV().containsKey(key);
    }

    public static void remove(String key) {
        getMMKV().remove(key).apply();
    }

}
