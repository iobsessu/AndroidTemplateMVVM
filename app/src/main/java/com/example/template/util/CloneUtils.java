package com.example.template.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CloneUtils {

    private CloneUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T> T deepClone(Serializable data) {
        return data == null ? null : (T) bytes2Object(serializable2Bytes(data));
    }

    private static byte[] serializable2Bytes(Serializable serializable) {
        if (serializable == null) {
            return null;
        } else {
            ObjectOutputStream oos = null;

            Object var4;
            try {
                ByteArrayOutputStream baos;
                oos = new ObjectOutputStream(baos = new ByteArrayOutputStream());
                oos.writeObject(serializable);
                byte[] var3 = baos.toByteArray();
                return var3;
            } catch (Exception var8) {
                var8.printStackTrace();
                var4 = null;
            } finally {
                closeIO(new Closeable[]{oos});
            }

            return (byte[])var4;
        }
    }

    private static Object bytes2Object(byte[] bytes) {
        if (bytes == null) {
            return null;
        } else {
            ObjectInputStream ois = null;

            Object var3;
            try {
                ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
                Object var2 = ois.readObject();
                return var2;
            } catch (Exception var7) {
                var7.printStackTrace();
                var3 = null;
            } finally {
                closeIO(new Closeable[]{ois});
            }

            return var3;
        }
    }

    public static void closeIO(Closeable... closeables) {
        if (closeables != null) {
            Closeable[] var1 = closeables;
            int var2 = closeables.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Closeable closeable = var1[var3];
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException var6) {
                        var6.printStackTrace();
                    }
                }
            }

        }
    }

    public static void closeIOQuietly(Closeable... closeables) {
        if (closeables != null) {
            Closeable[] var1 = closeables;
            int var2 = closeables.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Closeable closeable = var1[var3];
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException var6) {
                    }
                }
            }

        }
    }
}
