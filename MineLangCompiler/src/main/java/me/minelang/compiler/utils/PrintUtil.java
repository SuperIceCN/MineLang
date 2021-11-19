package me.minelang.compiler.utils;

import java.util.regex.Pattern;

import static me.minelang.compiler.utils.AnsiUtil.Attribute.*;
import static me.minelang.compiler.utils.AnsiUtil.ansi;

public final class PrintUtil {
    public static Pattern color = null;

    private static String processColor(String str) {
        if (!str.contains("§")) {
            return str;
        }
        if (color == null) {
            color = Pattern.compile("(?<!\\\\)(\\\\{2})*(§_?(nn|[0-9a-gl-r]))");
        }
        var matcher = color.matcher(str);
        return matcher.replaceAll((matchResult -> (switch (matchResult.group(2)) {
            case "§0" -> ansi().fgBlack();
            case "§1" -> ansi().fgRgb(0, 0, 170);
            case "§2" -> ansi().fgRgb(0, 170, 0);
            case "§3" -> ansi().fgRgb(0, 170, 170);
            case "§4" -> ansi().fgRgb(170, 0, 0);
            case "§5" -> ansi().fgRgb(170, 0, 170);
            case "§6" -> ansi().fgRgb(255, 170, 0);
            case "§7" -> ansi().fgRgb(170, 170, 170);
            case "§8" -> ansi().fgRgb(85, 85, 85);
            case "§9" -> ansi().fgRgb(85, 85, 255);
            case "§a" -> ansi().fgRgb(85, 255, 85);
            case "§b" -> ansi().fgRgb(85, 255, 255);
            case "§c" -> ansi().fgRgb(255, 85, 85);
            case "§d" -> ansi().fgRgb(255, 85, 255);
            case "§e" -> ansi().fgRgb(255, 255, 85);
            case "§f" -> ansi().fgRgb(255, 255, 255);
            case "§g" -> ansi().fgRgb(221, 214, 5);
            case "§_0" -> ansi().bgRgb(0, 0, 0);
            case "§_1" -> ansi().bgRgb(0, 0, 170);
            case "§_2" -> ansi().bgRgb(0, 170, 0);
            case "§_3" -> ansi().bgRgb(0, 170, 170);
            case "§_4" -> ansi().bgRgb(170, 0, 0);
            case "§_5" -> ansi().bgRgb(170, 0, 170);
            case "§_6" -> ansi().bgRgb(255, 170, 0);
            case "§_7" -> ansi().bgRgb(170, 170, 170);
            case "§_8" -> ansi().bgRgb(85, 85, 85);
            case "§_9" -> ansi().bgRgb(85, 85, 255);
            case "§_a" -> ansi().bgRgb(85, 255, 85);
            case "§_b" -> ansi().bgRgb(85, 255, 255);
            case "§_c" -> ansi().bgRgb(255, 85, 85);
            case "§_d" -> ansi().bgRgb(255, 85, 255);
            case "§_e" -> ansi().bgRgb(255, 255, 85);
            case "§_f" -> ansi().bgRgb(255, 255, 255);
            case "§_g" -> ansi().bgRgb(221, 214, 5);
            case "§l" -> ansi().bold();
            case "§m" -> ansi().a(STRIKETHROUGH_ON);
            case "§n" -> ansi().a(UNDERLINE);
            case "§nn" -> ansi().a(UNDERLINE_DOUBLE);
            case "§o" -> ansi().a(ITALIC);
            case "§r" -> ansi().reset();
            case "§p" -> ansi().eraseLine();
            case "§q" -> ansi().eraseScreen();
            default -> matchResult.group(2);
        }).toString()));
    }

    public static void print(String str) {
        System.out.println(processColor(str));
    }

    public static void info(String str) {
        System.out.println(processColor(I18NUtil.get("print_info") + " " + str));
    }

    public static void warning(String str) {
        System.out.println(processColor(I18NUtil.get("print_warning") + " " + str));
    }

    public static void error(String str) {
        System.out.println(processColor(I18NUtil.get("print_error") + " " + str));
    }
}
