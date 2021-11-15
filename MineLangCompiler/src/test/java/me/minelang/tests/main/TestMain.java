package me.minelang.tests.main;

import me.minelang.compiler.Main;
import org.junit.Test;

import java.io.File;

public class TestMain {
    @Test
    public void testMain1() {
        Main.main(new File("./").getAbsolutePath().replace("\\", "/").replace(".", "")
                +"src/test/resources/simpleFunc.me");
    }

    @Test
    public void testMain2() {
        Main.main(new File("./").getAbsolutePath().replace("\\", "/").replace(".", "")
                +"src/test/resources/helloworld.me");
    }
}
