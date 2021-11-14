package me.minelang.launcher;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static me.minelang.launcher.Utils.isWindows;
import static me.minelang.launcher.Utils.ok;

public final class InfoCollector {
    public static List<String> jarList = List.of("MineLang", "fastutil", "gson", "antlr4-runtime", "commons-math3"
            , "truffle-api", "hamcrest-core", "Java-WebSocket", "slf4j-api");

    public String RunningPath;
    public String GraalPath = null;
    public String GraalVersion = null;
    public String JavaVersion = null;
    public String MineLangPath = null;
    public String MineLangFileName = null;
    public boolean cached = false;

    public InfoCollector(String runningPath) {
        this.RunningPath = runningPath;
        this.loadCache();
        this.collectAllInfos();
    }

    public InfoCollector() {
        this(new File("./").getAbsolutePath());
    }

    public void collectAllInfos(boolean force) {
        if (!cached || force) {
            collectLocaleOnWindows();
            collectGraalInfos();
            collectJavaVersion();
            collectMineLangInfos();
            doCache();
        }
    }

    public void collectAllInfos() {
        collectAllInfos(false);
    }

    public void loadCache() {
        var cachePath = this.RunningPath + "/caches/launcherCache.json";
        var cacheFile = new File(cachePath);
        if (cacheFile.exists() && cacheFile.isFile() && cacheFile.canRead()) {
            try {
                var json = JsonParser.parseReader(new FileReader(cacheFile)).getAsJsonObject();
                this.cached = true;
                this.GraalPath = ok(json.get("GraalPath"), JsonElement::getAsString, null);
                this.GraalVersion = ok(json.get("GraalVersion"), JsonElement::getAsString, null);
                this.JavaVersion = ok(json.get("JavaVersion"), JsonElement::getAsString, null);
                this.MineLangPath = ok(json.get("MineLangPath"), JsonElement::getAsString, null);
                this.MineLangFileName = ok(json.get("MineLangFileName"), JsonElement::getAsString, null);
                I18NUtil.locale = ok(json.get("LocaleTag"), JsonElement::getAsString, "en-US");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void doCache() {
        var cachePath = this.RunningPath + "/caches/launcherCache.json";
        var cacheFile = new File(cachePath);
        if (!cacheFile.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                new File(this.RunningPath + "/caches").mkdirs();
                //noinspection ResultOfMethodCallIgnored
                cacheFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        var json = new JsonObject();
        ok(GraalPath, e -> json.addProperty("GraalPath", e));
        ok(GraalVersion, e -> json.addProperty("GraalVersion", e));
        ok(JavaVersion, e -> json.addProperty("JavaVersion", e));
        ok(MineLangPath, e -> json.addProperty("MineLangPath", e));
        ok(MineLangFileName, e -> json.addProperty("MineLangFileName", e));
        ok(I18NUtil.locale, e -> json.addProperty("LocaleTag", e));
        var str = new GsonBuilder().setPrettyPrinting().create().toJson(json);
        try {
            var writer = new FileWriter(cacheFile);
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void collectGraalInfos() {
        var current = new File(RunningPath).getAbsolutePath();
        if (checkGraalPath(current)) return;
        var sub = new File(current + "/Graal");
        if (sub.exists() && checkGraalPath(sub.getAbsolutePath())) return;
        var env = System.getenv("GRAAL_HOME");
        if (env != null && new File(env).exists() && checkGraalPath(env)) return;
        env = System.getenv("GRAALVM_HOME");
        if (env != null && new File(env).exists() && checkGraalPath(env)) return;
        env = System.getenv("JAVA_HOME");
        if (env != null && new File(env).exists()) {
            checkGraalPath(env);
        }
    }

    private void collectJavaVersion() {
        if (this.GraalPath != null) {
            try {
                var process = new ProcessBuilder().command(this.GraalPath + "/bin/java", "-version")
                        .redirectErrorStream(true).start();
                var reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                process.waitFor(1000, TimeUnit.MILLISECONDS);
                var s = "";
                while ((s = reader.readLine()) != null) {
                    if (s.contains("version")) {
                        var t = s.split("\"");
                        if (t.length == 3) {
                            this.JavaVersion = t[1];
                            break;
                        }
                    }
                }
            } catch (IOException | InterruptedException e) {
                //ignore
            }
        }
    }

    private void collectLocaleOnWindows() {
        if (!isWindows()) {
            return;
        }
        System.out.println("收集信息中......");
        try {
            var cmd = """
                    @echo off
                    reg query "HKEY_LOCAL_MACHINE\\SYSTEM\\ControlSet001\\Control\\Nls\\Language" /v InstallLanguage|find "0804">nul&&echo;zh-CN>>"%s/caches/out.txt"||echo;en-US>>"%s/caches/out.txt"
                    """.formatted(RunningPath, RunningPath);
            var cmdFile = new File(this.RunningPath + "/caches/locale.cmd");
            //noinspection ResultOfMethodCallIgnored
            cmdFile.getParentFile().mkdirs();
            if(!cmdFile.exists()) {
                //noinspection ResultOfMethodCallIgnored
                cmdFile.createNewFile();
                var writer = new FileWriter(cmdFile);
                writer.write(cmd);
                writer.close();
            }
            var outFile = new File(RunningPath + "/caches/out.txt");
            if(outFile.exists()) //noinspection ResultOfMethodCallIgnored
                outFile.delete();
            var process = new ProcessBuilder().command(cmdFile.getAbsolutePath()).start();
            process.waitFor(2500, TimeUnit.MILLISECONDS);
            var reader = new BufferedReader(new InputStreamReader(new FileInputStream(outFile)));
            I18NUtil.locale = reader.readLine();
        } catch (IOException | InterruptedException e) {
            //ignore
        }
    }

    private boolean checkGraalPath(String path) {
        //检查是否包含bin目录
        var binFolder = new File(path + "/bin");
        if (!binFolder.exists() || !binFolder.isDirectory()) {
            return false;
        }
        //检查是否存在java可执行文件
        var javaExecutable = new File(path + "/bin/java" + platformSuffix());
        if (!javaExecutable.exists() || !javaExecutable.isFile() || !javaExecutable.canExecute()) {
            return false;
        }
        //检查是否是GraalVM
        try {
            var process = new ProcessBuilder().command(javaExecutable.getAbsolutePath(), "-version")
                    .redirectErrorStream(true).start();
            var reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            process.waitFor(1000, TimeUnit.MILLISECONDS);
            var s = "";
            while ((s = reader.readLine()) != null) {
                if (s.contains("GraalVM")) {
                    var t = s.indexOf("GraalVM CE ");
                    if (t == -1) {
                        t = s.indexOf("GraalVM EE ");
                    }
                    if (t == -1) {
                        t = s.indexOf("GraalVM SE ");
                    }
                    this.GraalVersion = s.substring(t + 11, t + 11 + 6);
                    this.GraalPath = path;
                    return true;
                }
            }
        } catch (IOException | InterruptedException e) {
            return false;
        }
        return false;
    }

    private void collectMineLangInfos() {
        var current = new File(RunningPath).getAbsolutePath();
        if (checkMineLangPath(current)) return;
        var env = System.getenv("MINELANG_HOME");
        if (env != null && new File(env).exists()) {
            checkMineLangPath(env);
        }
    }

    private boolean checkMineLangPath(String path) {
        var runtimeFolder = new File(path + "/runtime");
        if (!runtimeFolder.exists() || !runtimeFolder.isDirectory()) {
            return false;
        }
        //检查是否存在java可执行文件
        var files = runtimeFolder.list((dir, name) -> name.endsWith(".jar"));
        if (files == null) return false;
        // TODO: 2021/11/13 优化算法复杂度
        for (var each : files) {
            var found = false;
            for (var jar : jarList) {
                if (each.contains(jar)) {
                    found = true;
                    if (jar.equals("MineLang")) {
                        this.MineLangFileName = each;
                    }
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    public static String platformSuffix() {
        if (System.getProperties().getProperty("os.name").toUpperCase().contains("WINDOWS")) {
            return ".exe";
        } else {
            return "";
        }
    }
}
