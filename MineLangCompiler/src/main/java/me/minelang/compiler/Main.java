package me.minelang.compiler;

import me.minelang.compiler.lang.MineLanguage;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Source;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static me.minelang.compiler.utils.I18NUtil.get;
import static me.minelang.compiler.utils.PrintUtil.*;

public class Main {
    public static void main(String... args) {
        var fileName = "eval";
        var code = "";
        var each = "";
        var stdin = System.in;
        var stdout = System.out;
        var stderr = System.err;
        var programArgs = new ArrayList<String>();
        System.out.println(org.antlr.v4.runtime.CharStream.class);
        var a = org.antlr.v4.runtime.CharStream.class;

        var fileMode = true;

        for (var i = 0; i < args.length; i++) {
            each = args[i];
            if (each.equals("-version")) {
                info(get("version_info", MineLanguage.VERSION));
                return;
            } else if (each.equals("-stdin")) {
                var inFile = args[++i];
                try {
                    stdin = new FileInputStream(inFile);
                } catch (FileNotFoundException e) {
                    error(get("fail_to_load_file", inFile));
                }
            } else if (each.equals("-stdout")) {
                try {
                    stdout = createFilePrintStream(args[++i]);
                } catch (IOException e) {
                    error(get("fail_to_load_file", each));
                }
            } else if (each.equals("-stderr")) {
                try {
                    stderr = createFilePrintStream(args[++i]);
                } catch (IOException e) {
                    error(get("fail_to_load_file", each));
                }
            } else if (fileMode && each.endsWith(".ml")) {
                fileName = each;
                fileMode = false;
                try {
                    code = Files.readString(Path.of(each), StandardCharsets.UTF_8);
                } catch (IOException e) {
                    error(get("fail_to_load_file", each));
                }
            } else {
                programArgs.add(each);
            }
        }

        var engine = Engine.newBuilder().build();
        var context = Context.newBuilder("MineLang")
                .arguments("MineLang", programArgs.toArray(new String[0]))
                .engine(engine)
                .allowAllAccess(true)
                .in(stdin).out(stdout).err(stderr)
                .build();
        try {
            var returnValue = context.eval(Source.newBuilder("MineLang", code, fileName).build());
            print(get("program_exit", returnValue));
        } catch (IOException e) {
            error(get("fail_to_process_source", fileName));
            e.printStackTrace();
        }
    }

    private static PrintStream createFilePrintStream(String path) throws IOException {
        var outFile = new File(path);
        if (!outFile.exists()) {
            var result = outFile.createNewFile();
            if (!result) {
                error(get("fail_to_create_file", outFile.getPath()));
            }
        }
        return new PrintStream(new FileOutputStream(outFile));
    }
}
