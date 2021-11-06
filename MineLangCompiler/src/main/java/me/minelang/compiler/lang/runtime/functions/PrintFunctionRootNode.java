package me.minelang.compiler.lang.runtime.functions;

import com.oracle.truffle.api.frame.VirtualFrame;
import me.minelang.compiler.lang.MineLanguage;

public final class PrintFunctionRootNode extends BuiltInFunctionRootNode {
    public PrintFunctionRootNode(MineLanguage language) {
        super(language, "print", "message");
    }

    @Override
    public Object execute(VirtualFrame frame) {
        var message = frame.getArguments()[0];
        System.out.println(message);
        return message;
    }
}
