package com.github.zulhilmizainuddin.logcatreflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Log {
    private Log() {}

    public static void v(String tag, String log) {
        log("v", tag, log);
    }

    public static void d(String tag, String log) {
        log("d", tag, log);
    }

    public static void i(String tag, String log) {
        log("i", tag, log);
    }

    public static void w(String tag, String log) {
        log("w", tag, log);
    }

    public static void e(String tag, String log) {
        log("e", tag, log);
    }

    private static void log(String method, String tag, String log) {
        try {
            Class<?> logClass = Class.forName("android.util.Log");
            Method logMethod = logClass.getDeclaredMethod(method, String.class, String.class);

            logMethod.invoke(null, tag, log);
        }
        catch (ClassNotFoundException |
                NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
