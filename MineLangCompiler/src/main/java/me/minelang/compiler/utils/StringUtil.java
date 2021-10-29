package me.minelang.compiler.utils;

public final class StringUtil {
    /**
     * 去除字符串首尾的成对单双引号
     *
     * @param str 字符串
     * @return 无首尾引号字符串
     */
    public static String removeQuote(String str) {
        if ((str.startsWith("\"") && str.endsWith("\"")) || (str.startsWith("'") && str.endsWith("'"))) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }
}
