package me.minelang.launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
                    info(get("launcher_info", VERSION, infos.RunningPath, infos.GraalPath, infos.GraalVersion, infos.JavaVersion, infos.MineLangPath));
                } else if (each.equals("-refreshCache")) {
                    infos.collectAllInfos(true);
                    info(get("refresh_cache"));
                } else {
                    programArgs.add(each);
                    var command = infos.GraalPath + "/bin/java -cp " + infos.MineLangPath + "/*.jar -jar " +
                            infos.MineLangPath + '/' +
                            infos.MineLangFileName + ' ';
                    try {
                        var list = new ArrayList<String>(1 + programArgs.size());
                        list.add(command);
                        list.addAll(programArgs);
                        var process = new ProcessBuilder(list.toArray(new String[0]))
                                .directory(new File("./")).inheritIO().start();
                        process.waitFor();
                    } catch (IOException | InterruptedException e) {
                        error(get("fail_to_launch_minelang"));
                        e.printStackTrace();
                    }
                }
            }
    }
}
