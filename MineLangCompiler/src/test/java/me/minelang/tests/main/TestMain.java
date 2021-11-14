package me.minelang.tests.main;

import me.minelang.compiler.Main;
import org.junit.Test;

import java.io.File;

public class TestMain {
    @Test
    public void testMain1() {
        System.out.println(new File("./").getAbsolutePath());
        Main.main(new File("./").getAbsolutePath().replace("\\", "/").replace(".", "")
                +"src/test/resources/simpleFunc.ml");
    }
}
