package me.minelang.launcher;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Objects;

import static me.minelang.launcher.Utils.ok;

public final class I18NUtil {
    public static String locale = null;
    public static JsonObject languageRes;

    public static void init() {
        if(locale == null)
            locale = Locale.getDefault().toLanguageTag();
        var stream = I18NUtil.class.getResourceAsStream("/languages/" + locale + ".json");
        if (stream == null) {
            stream = I18NUtil.class.getResourceAsStream("/languages/en-US.json");
        }
        var reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(stream), StandardCharsets.UTF_8));
        languageRes = JsonParser.parseReader(reader).getAsJsonObject();
    }

    /**
     * 获取国际化字符串内容
     * @param id 字符串id
     * @param args 参数
     * @return 国际化后内容
     */
    public static String get(String id, Object... args) {
        var str = languageRes.get(id).getAsString();
        for (var i = 0; i < args.length; i++) {
            str = str.replaceAll("%" + i, ok(args[i], e ->
                    e.toString().replace("\\", "\\\\"), "null"));
        }
        return str;
    }
}
