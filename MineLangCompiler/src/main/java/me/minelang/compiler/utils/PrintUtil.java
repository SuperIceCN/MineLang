package me.minelang.compiler.utils;

public final class PrintUtil {
    public static void print(String str) {
        System.out.println(str);
    }

    public static void info(String str) {
        System.out.println(I18NUtil.get("print_info") + " " + str);
    }

    public static void warning(String str) {
        System.out.println(I18NUtil.get("print_warning") + " " + str);
    }

    public static void error(String str) {
        System.out.println(I18NUtil.get("print_error") + " " + str);
    }
}
