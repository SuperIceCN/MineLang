package me.minelang.compiler.utils;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@SuppressWarnings("unused")
public class AnsiUtil implements Appendable {
    private static final char FIRST_ESC_CHAR = '\u001b';
    private static final char SECOND_ESC_CHAR = '[';
    public static final String DISABLE = AnsiUtil.class.getName() + ".disable";
    private static Callable<Boolean> detector = () -> !Boolean.getBoolean(AnsiUtil.DISABLE);
    private static final InheritableThreadLocal<Boolean> holder = new InheritableThreadLocal<>() {
        protected Boolean initialValue() {
            return AnsiUtil.isDetected();
        }
    };
    private final StringBuilder builder;
    private final ArrayList<Integer> attributeOptions;

    public static void setDetector(Callable<Boolean> detector) {
        if (detector == null) {
            throw new IllegalArgumentException();
        } else {
            AnsiUtil.detector = detector;
        }
    }

    public static boolean isDetected() {
        try {
            return detector.call();
        } catch (Exception var1) {
            return true;
        }
    }

    public static void setEnabled(boolean flag) {
        holder.set(flag);
    }

    public static boolean isEnabled() {
        return holder.get();
    }

    public static AnsiUtil ansi() {
        return isEnabled() ? new AnsiUtil() : new NoAnsiUtil();
    }

    public static AnsiUtil ansi(StringBuilder builder) {
        return isEnabled() ? new AnsiUtil(builder) : new NoAnsiUtil(builder);
    }

    public static AnsiUtil ansi(int size) {
        return isEnabled() ? new AnsiUtil(size) : new NoAnsiUtil(size);
    }

    public AnsiUtil() {
        this(new StringBuilder(80));
    }

    public AnsiUtil(AnsiUtil parent) {
        this(new StringBuilder(parent.builder));
        this.attributeOptions.addAll(parent.attributeOptions);
    }

    public AnsiUtil(int size) {
        this(new StringBuilder(size));
    }

    public AnsiUtil(StringBuilder builder) {
        this.attributeOptions = new ArrayList<>(5);
        this.builder = builder;
    }

    public AnsiUtil fg(AnsiUtil.Color color) {
        this.attributeOptions.add(color.fg());
        return this;
    }

    public AnsiUtil fg(int color) {
        this.attributeOptions.add(38);
        this.attributeOptions.add(5);
        this.attributeOptions.add(color & 255);
        return this;
    }

    public AnsiUtil fgRgb(int color) {
        return this.fgRgb(color >> 16, color >> 8, color);
    }

    public AnsiUtil fgRgb(int r, int g, int b) {
        this.attributeOptions.add(38);
        this.attributeOptions.add(2);
        this.attributeOptions.add(r & 255);
        this.attributeOptions.add(g & 255);
        this.attributeOptions.add(b & 255);
        return this;
    }

    public AnsiUtil fgBlack() {
        return this.fg(AnsiUtil.Color.BLACK);
    }

    public AnsiUtil fgBlue() {
        return this.fg(AnsiUtil.Color.BLUE);
    }

    public AnsiUtil fgCyan() {
        return this.fg(AnsiUtil.Color.CYAN);
    }

    public AnsiUtil fgDefault() {
        return this.fg(AnsiUtil.Color.DEFAULT);
    }

    public AnsiUtil fgGreen() {
        return this.fg(AnsiUtil.Color.GREEN);
    }

    public AnsiUtil fgMagenta() {
        return this.fg(AnsiUtil.Color.MAGENTA);
    }

    public AnsiUtil fgRed() {
        return this.fg(AnsiUtil.Color.RED);
    }

    public AnsiUtil fgYellow() {
        return this.fg(AnsiUtil.Color.YELLOW);
    }

    public AnsiUtil bg(AnsiUtil.Color color) {
        this.attributeOptions.add(color.bg());
        return this;
    }

    public AnsiUtil bg(int color) {
        this.attributeOptions.add(48);
        this.attributeOptions.add(5);
        this.attributeOptions.add(color & 255);
        return this;
    }

    public AnsiUtil bgRgb(int color) {
        return this.bgRgb(color >> 16, color >> 8, color);
    }

    public AnsiUtil bgRgb(int r, int g, int b) {
        this.attributeOptions.add(48);
        this.attributeOptions.add(2);
        this.attributeOptions.add(r & 255);
        this.attributeOptions.add(g & 255);
        this.attributeOptions.add(b & 255);
        return this;
    }

    public AnsiUtil bgCyan() {
        return this.bg(AnsiUtil.Color.CYAN);
    }

    public AnsiUtil bgDefault() {
        return this.bg(AnsiUtil.Color.DEFAULT);
    }

    public AnsiUtil bgGreen() {
        return this.bg(AnsiUtil.Color.GREEN);
    }

    public AnsiUtil bgMagenta() {
        return this.bg(AnsiUtil.Color.MAGENTA);
    }

    public AnsiUtil bgRed() {
        return this.bg(AnsiUtil.Color.RED);
    }

    public AnsiUtil bgYellow() {
        return this.bg(AnsiUtil.Color.YELLOW);
    }

    public AnsiUtil fgBright(AnsiUtil.Color color) {
        this.attributeOptions.add(color.fgBright());
        return this;
    }

    public AnsiUtil fgBrightBlack() {
        return this.fgBright(AnsiUtil.Color.BLACK);
    }

    public AnsiUtil fgBrightBlue() {
        return this.fgBright(AnsiUtil.Color.BLUE);
    }

    public AnsiUtil fgBrightCyan() {
        return this.fgBright(AnsiUtil.Color.CYAN);
    }

    public AnsiUtil fgBrightDefault() {
        return this.fgBright(AnsiUtil.Color.DEFAULT);
    }

    public AnsiUtil fgBrightGreen() {
        return this.fgBright(AnsiUtil.Color.GREEN);
    }

    public AnsiUtil fgBrightMagenta() {
        return this.fgBright(AnsiUtil.Color.MAGENTA);
    }

    public AnsiUtil fgBrightRed() {
        return this.fgBright(AnsiUtil.Color.RED);
    }

    public AnsiUtil fgBrightYellow() {
        return this.fgBright(AnsiUtil.Color.YELLOW);
    }

    public AnsiUtil bgBright(AnsiUtil.Color color) {
        this.attributeOptions.add(color.bgBright());
        return this;
    }

    public AnsiUtil bgBrightCyan() {
        return this.bgBright(AnsiUtil.Color.CYAN);
    }

    public AnsiUtil bgBrightDefault() {
        return this.bgBright(AnsiUtil.Color.DEFAULT);
    }

    public AnsiUtil bgBrightGreen() {
        return this.bgBright(AnsiUtil.Color.GREEN);
    }

    public AnsiUtil bgBrightMagenta() {
        return this.bgBright(AnsiUtil.Color.MAGENTA);
    }

    public AnsiUtil bgBrightRed() {
        return this.bgBright(AnsiUtil.Color.RED);
    }

    public AnsiUtil bgBrightYellow() {
        return this.bgBright(AnsiUtil.Color.YELLOW);
    }

    public AnsiUtil a(AnsiUtil.Attribute attribute) {
        this.attributeOptions.add(attribute.value());
        return this;
    }

    public AnsiUtil cursor(int row, int column) {
        return this.appendEscapeSequence('H', Math.max(1, row), Math.max(1, column));
    }

    public AnsiUtil cursorToColumn(int x) {
        return this.appendEscapeSequence('G', Math.max(1, x));
    }

    public AnsiUtil cursorUp(int y) {
        return y > 0 ? this.appendEscapeSequence('A', y) : (y < 0 ? this.cursorDown(-y) : this);
    }

    public AnsiUtil cursorDown(int y) {
        return y > 0 ? this.appendEscapeSequence('B', y) : (y < 0 ? this.cursorUp(-y) : this);
    }

    public AnsiUtil cursorRight(int x) {
        return x > 0 ? this.appendEscapeSequence('C', x) : (x < 0 ? this.cursorLeft(-x) : this);
    }

    public AnsiUtil cursorLeft(int x) {
        return x > 0 ? this.appendEscapeSequence('D', x) : (x < 0 ? this.cursorRight(-x) : this);
    }

    public AnsiUtil cursorMove(int x, int y) {
        return this.cursorRight(x).cursorDown(y);
    }

    public AnsiUtil cursorDownLine() {
        return this.appendEscapeSequence('E');
    }

    public AnsiUtil cursorDownLine(int n) {
        return n < 0 ? this.cursorUpLine(-n) : this.appendEscapeSequence('E', n);
    }

    public AnsiUtil cursorUpLine() {
        return this.appendEscapeSequence('F');
    }

    public AnsiUtil cursorUpLine(int n) {
        return n < 0 ? this.cursorDownLine(-n) : this.appendEscapeSequence('F', n);
    }

    public AnsiUtil eraseScreen() {
        return this.appendEscapeSequence('J', AnsiUtil.Erase.ALL.value());
    }

    public AnsiUtil eraseScreen(AnsiUtil.Erase kind) {
        return this.appendEscapeSequence('J', kind.value());
    }

    public AnsiUtil eraseLine() {
        return this.appendEscapeSequence('K');
    }

    public AnsiUtil eraseLine(AnsiUtil.Erase kind) {
        return this.appendEscapeSequence('K', kind.value());
    }

    public AnsiUtil scrollUp(int rows) {
        return rows > 0 ? this.appendEscapeSequence('S', rows) : (rows < 0 ? this.scrollDown(-rows) : this);
    }

    public AnsiUtil scrollDown(int rows) {
        return rows > 0 ? this.appendEscapeSequence('T', rows) : (rows < 0 ? this.scrollUp(-rows) : this);
    }

    public AnsiUtil saveCursorPosition() {
        return this.appendEscapeSequence('s');
    }

    /**
     * @deprecated
     */
    @Deprecated
    public AnsiUtil restorCursorPosition() {
        return this.appendEscapeSequence('u');
    }

    public AnsiUtil restoreCursorPosition() {
        return this.appendEscapeSequence('u');
    }

    public AnsiUtil reset() {
        return this.a(AnsiUtil.Attribute.RESET);
    }

    public AnsiUtil bold() {
        return this.a(AnsiUtil.Attribute.INTENSITY_BOLD);
    }

    public AnsiUtil boldOff() {
        return this.a(AnsiUtil.Attribute.INTENSITY_BOLD_OFF);
    }

    public AnsiUtil a(String value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(boolean value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(char value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(char[] value, int offset, int len) {
        this.flushAttributes();
        this.builder.append(value, offset, len);
        return this;
    }

    public AnsiUtil a(char[] value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(CharSequence value, int start, int end) {
        this.flushAttributes();
        this.builder.append(value, start, end);
        return this;
    }

    public AnsiUtil a(CharSequence value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(double value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(float value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(int value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(long value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(Object value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil a(StringBuffer value) {
        this.flushAttributes();
        this.builder.append(value);
        return this;
    }

    public AnsiUtil newline() {
        this.flushAttributes();
        this.builder.append(System.getProperty("line.separator"));
        return this;
    }

    public AnsiUtil format(String pattern, Object... args) {
        this.flushAttributes();
        this.builder.append(String.format(pattern, args));
        return this;
    }

    public AnsiUtil apply(AnsiUtil.Consumer fun) {
        fun.apply(this);
        return this;
    }

    public String toString() {
        this.flushAttributes();
        return this.builder.toString();
    }

    private AnsiUtil appendEscapeSequence(char command) {
        this.flushAttributes();
        this.builder.append('\u001b');
        this.builder.append('[');
        this.builder.append(command);
        return this;
    }

    private AnsiUtil appendEscapeSequence(char command, int option) {
        this.flushAttributes();
        this.builder.append('\u001b');
        this.builder.append('[');
        this.builder.append(option);
        this.builder.append(command);
        return this;
    }

    private AnsiUtil appendEscapeSequence(char command, Object... options) {
        this.flushAttributes();
        return this._appendEscapeSequence(command, options);
    }

    private void flushAttributes() {
        if (!this.attributeOptions.isEmpty()) {
            if (this.attributeOptions.size() == 1 && this.attributeOptions.get(0) == 0) {
                this.builder.append('\u001b');
                this.builder.append('[');
                this.builder.append('m');
            } else {
                this._appendEscapeSequence('m', this.attributeOptions.toArray());
            }

            this.attributeOptions.clear();
        }
    }

    private AnsiUtil _appendEscapeSequence(char command, Object... options) {
        this.builder.append('\u001b');
        this.builder.append('[');
        int size = options.length;

        for (int i = 0; i < size; ++i) {
            if (i != 0) {
                this.builder.append(';');
            }

            if (options[i] != null) {
                this.builder.append(options[i]);
            }
        }

        this.builder.append(command);
        return this;
    }

    public AnsiUtil append(CharSequence csq) {
        this.builder.append(csq);
        return this;
    }

    public AnsiUtil append(CharSequence csq, int start, int end) {
        this.builder.append(csq, start, end);
        return this;
    }

    public AnsiUtil append(char c) {
        this.builder.append(c);
        return this;
    }

    private static class NoAnsiUtil extends AnsiUtil {
        public NoAnsiUtil() {
        }

        public NoAnsiUtil(int size) {
            super(size);
        }

        public NoAnsiUtil(StringBuilder builder) {
            super(builder);
        }

        public AnsiUtil fg(AnsiUtil.Color color) {
            return this;
        }

        public AnsiUtil bg(AnsiUtil.Color color) {
            return this;
        }

        public AnsiUtil fgBright(AnsiUtil.Color color) {
            return this;
        }

        public AnsiUtil bgBright(AnsiUtil.Color color) {
            return this;
        }

        public AnsiUtil fg(int color) {
            return this;
        }

        public AnsiUtil fgRgb(int r, int g, int b) {
            return this;
        }

        public AnsiUtil bg(int color) {
            return this;
        }

        public AnsiUtil bgRgb(int r, int g, int b) {
            return this;
        }

        public AnsiUtil a(AnsiUtil.Attribute attribute) {
            return this;
        }

        public AnsiUtil cursor(int row, int column) {
            return this;
        }

        public AnsiUtil cursorToColumn(int x) {
            return this;
        }

        public AnsiUtil cursorUp(int y) {
            return this;
        }

        public AnsiUtil cursorRight(int x) {
            return this;
        }

        public AnsiUtil cursorDown(int y) {
            return this;
        }

        public AnsiUtil cursorLeft(int x) {
            return this;
        }

        public AnsiUtil cursorDownLine() {
            return this;
        }

        public AnsiUtil cursorDownLine(int n) {
            return this;
        }

        public AnsiUtil cursorUpLine() {
            return this;
        }

        public AnsiUtil cursorUpLine(int n) {
            return this;
        }

        public AnsiUtil eraseScreen() {
            return this;
        }

        public AnsiUtil eraseScreen(AnsiUtil.Erase kind) {
            return this;
        }

        public AnsiUtil eraseLine() {
            return this;
        }

        public AnsiUtil eraseLine(AnsiUtil.Erase kind) {
            return this;
        }

        public AnsiUtil scrollUp(int rows) {
            return this;
        }

        public AnsiUtil scrollDown(int rows) {
            return this;
        }

        public AnsiUtil saveCursorPosition() {
            return this;
        }

        /**
         * @deprecated
         */
        @Deprecated
        public AnsiUtil restorCursorPosition() {
            return this;
        }

        public AnsiUtil restoreCursorPosition() {
            return this;
        }

        public AnsiUtil reset() {
            return this;
        }
    }

    public interface Consumer {
        void apply(AnsiUtil var1);
    }

    public enum Erase {
        FORWARD(0, "FORWARD"),
        BACKWARD(1, "BACKWARD"),
        ALL(2, "ALL");

        private final int value;
        private final String name;

        Erase(int index, String name) {
            this.value = index;
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public int value() {
            return this.value;
        }
    }

    public enum Attribute {
        RESET(0, "RESET"),
        INTENSITY_BOLD(1, "INTENSITY_BOLD"),
        INTENSITY_FAINT(2, "INTENSITY_FAINT"),
        ITALIC(3, "ITALIC_ON"),
        UNDERLINE(4, "UNDERLINE_ON"),
        BLINK_SLOW(5, "BLINK_SLOW"),
        BLINK_FAST(6, "BLINK_FAST"),
        NEGATIVE_ON(7, "NEGATIVE_ON"),
        CONCEAL_ON(8, "CONCEAL_ON"),
        STRIKETHROUGH_ON(9, "STRIKETHROUGH_ON"),
        UNDERLINE_DOUBLE(21, "UNDERLINE_DOUBLE"),
        INTENSITY_BOLD_OFF(22, "INTENSITY_BOLD_OFF"),
        ITALIC_OFF(23, "ITALIC_OFF"),
        UNDERLINE_OFF(24, "UNDERLINE_OFF"),
        BLINK_OFF(25, "BLINK_OFF"),
        NEGATIVE_OFF(27, "NEGATIVE_OFF"),
        CONCEAL_OFF(28, "CONCEAL_OFF"),
        STRIKETHROUGH_OFF(29, "STRIKETHROUGH_OFF");

        private final int value;
        private final String name;

        Attribute(int index, String name) {
            this.value = index;
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public int value() {
            return this.value;
        }
    }

    public enum Color {
        BLACK(0, "BLACK"),
        RED(1, "RED"),
        GREEN(2, "GREEN"),
        YELLOW(3, "YELLOW"),
        BLUE(4, "BLUE"),
        MAGENTA(5, "MAGENTA"),
        CYAN(6, "CYAN"),
        WHITE(7, "WHITE"),
        DEFAULT(9, "DEFAULT");

        private final int value;
        private final String name;

        Color(int index, String name) {
            this.value = index;
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public int value() {
            return this.value;
        }

        public int fg() {
            return this.value + 30;
        }

        public int bg() {
            return this.value + 40;
        }

        public int fgBright() {
            return this.value + 90;
        }

        public int bgBright() {
            return this.value + 100;
        }
    }
}
