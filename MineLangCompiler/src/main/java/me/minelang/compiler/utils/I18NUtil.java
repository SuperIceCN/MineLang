package me.minelang.compiler.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;

public final class I18NUtil {
    public static Locale locale = Locale.getDefault();
    public static Properties languageRes = new Properties();

    static {
        var stream = I18NUtil.class.getResourceAsStream("languages/" + locale.toLanguageTag() + ".properties");
        if (stream == null) {
            stream = I18NUtil.class.getResourceAsStream("languages/en-US.properties");
        }
        var reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(stream), StandardCharsets.UTF_8));
        try {
            languageRes.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取国际化字符串内容
     * @param id 字符串id
     * @param args 参数
     * @return 国际化后内容
     */
    public static String get(String id, Object... args) {
        var str = languageRes.getProperty(id);
        for (var i = 0; i < args.length; i++) {
            str = str.replaceAll("%" + i, args[i].toString());
        }
        return str;
    }
}
