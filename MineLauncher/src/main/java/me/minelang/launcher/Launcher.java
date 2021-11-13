package me.minelang.launcher;

public final class Launcher {
    public static final String VERSION = "0.0.1-beta";
    public static void main(String[] args) {
        var infos = new InfoCollector();
        System.out.printf("""
                MineLang Launcher %s
                ---------------------------
                Running on: %s
                Found VM: %s
                VM Version: %s - Java%s
                Found MineLang: %s
                %n""", VERSION, infos.RunningPath, infos.GraalPath, infos.GraalVersion, infos.JavaVersion, infos.MineLangPath);
    }
}
