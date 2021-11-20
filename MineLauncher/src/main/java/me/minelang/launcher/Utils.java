package me.minelang.launcher;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public final class Utils {
    public static <t, r> r ok(t obj, Function<t, r> function, r ifNull) {
        return obj == null ? ifNull : function.apply(obj);
    }

    public static <t> void ok(t obj, Function<t, Boolean> guard, Consumer<t> consumer) {
        if (guard.apply(obj)) {
            consumer.accept(obj);
        }
    }

    public static <t> void ok(t obj, Consumer<t> consumer) {
        if (obj != null) {
            consumer.accept(obj);
        }
    }

    public static boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().contains("WINDOWS");
    }

    /**
     * 比较版本号的大小
     *
     * @param version1 版本号
     * @param version2 版本号
     * @return 前者大则返回一个正数, 后者大返回一个负数, 相等则返回0
     */
    public static int compareVersion(String version1, String version2) {
        assert version1 != null;
        assert version2 != null;
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
            ++idx;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }

    public static <T> boolean arrayContains(T[] array, T obj) {
        for (var each : array) {
            if (Objects.equals(each, obj)) {
                return true;
            }
        }
        return false;
    }

    public static String bytes2MB(long bytes) {
        return "%.2f".formatted((bytes / (1024.0 * 1024)));
    }

    public static class Store<T> {
        private T data;

        public Store() {
            this.data = null;
        }

        public Store(T init) {
            this.data = init;
        }

        public T get() {
            return data;
        }

        public void set(T data) {
            this.data = data;
        }
    }
}
