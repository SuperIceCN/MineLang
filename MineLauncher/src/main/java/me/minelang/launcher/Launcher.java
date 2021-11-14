package me.minelang.launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static me.minelang.launcher.I18NUtil.get;
import static me.minelang.launcher.PrintUtil.error;
import static me.minelang.launcher.PrintUtil.info;

public final class Launcher {
    public static final String VERSION = "0.0.1-beta";

    public static void main(String[] args) {
        var infos = new InfoCollector();
        I18NUtil.init();
        var programArgs = new ArrayList<String>();
        var wellPrepared = true;
        if (args.length == 0) {
            info(get("launcher_info", VERSION, I18NUtil.locale, infos.RunningPath, infos.GraalPath, infos.GraalVersion, infos.JavaVersion, infos.MineLangPath));
        }
        if (infos.GraalPath == null) {
            error(get("graalvm_not_found"));
            wellPrepared = false;
        }
        if (infos.MineLangPath == null) {
            error(get("minelang_not_found"));
            wellPrepared = false;
        }
        if (wellPrepared)
            for (var each : args) {
                if (each.equals("-launcherInfo")) {
                    info(get("launcher_info", VERSION, I18NUtil.locale, I18NUtil.locale, infos.RunningPath, infos.GraalPath, infos.GraalVersion, infos.JavaVersion, infos.MineLangPath));
                } else if (each.equals("-refreshCache")) {
                    infos.collectAllInfos(true);
                    info(get("refresh_cache"));
                } else {
                    programArgs.add(each);
                    var cmdList = new ArrayList<String>();
                    cmdList.add(infos.GraalPath+"/bin/java");
                    cmdList.add("-Dfile.encoding=UTF-8");
                    cmdList.add("-Dgraalvm.locatorDisabled=true");
                    cmdList.add("--upgrade-module-path=\"" + (infos.MineLangPath.replace("\\", "/") + ("/runtime/") + infos.TruffleApiFileName).replace("/./", "/") + "\"");
                    cmdList.add("--add-opens");
                    cmdList.add("org.graalvm.sdk/org.graalvm.polyglot=ALL-UNNAMED");
                    cmdList.add("--add-exports");
                    cmdList.add("java.base/jdk.internal.module=ALL-UNNAMED");
                    cmdList.add("-classpath");
                    var cps = new StringBuilder();
                    for (var jarFile : Objects.requireNonNull(new File(infos.MineLangPath + "/runtime").list((dir, name) -> name.endsWith(".jar")))) {
                        cps.append(infos.MineLangPath.replace("\\", "/")).append("/runtime/").append(jarFile).append(";");
                    }
                    cps.append(infos.MineLangPath.replace("\\", "/")).append("/runtime/").append(infos.MineLangFileName);
                    cmdList.add(cps.toString().replace("/./", "/"));
                    cmdList.add("-Dtruffle.class.path.append=\"" + (infos.MineLangPath.replace("\\", "/") + ("/runtime/") + infos.MineLangFileName).replace("/./", "/") + "\"");
                    cmdList.add("me.minelang.compiler.Main");
                    cmdList.addAll(programArgs);
                    try {
                        var process = new ProcessBuilder(cmdList.toArray(new String[0]))
                                .directory(new File("./")).inheritIO().start();
                        process.waitFor();
                    } catch (IOException | InterruptedException e) {
                        error(get("fail_to_launch_minelang"));
                        e.printStackTrace();
                    }
                }
            }
        else
            infos.collectAllInfos(true);
    }
}
