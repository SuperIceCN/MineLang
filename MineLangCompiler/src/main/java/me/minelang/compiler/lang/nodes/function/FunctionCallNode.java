package me.minelang.compiler.lang.nodes.function;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.exceptions.runtime.InvalidFunctionArgsException;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineFunction;

@NodeInfo(language = "MineLang", shortName = "call", description = "Call a function.")
@NodeChild(value = "func", type = MineNode.class)
public abstract class FunctionCallNode extends MineNode {
    @Children
    MineNode[] args;

    public FunctionCallNode(MineNode[] args){
        this.args = args;
    }

    @Specialization
    @ExplodeLoop
    Object invoke(VirtualFrame frame, MineFunction func, @CachedLibrary("library") InteropLibrary library) {
        var argNodes = args;
        CompilerAsserts.compilationConstant(args.length);

        var argumentValues = new Object[argNodes.length];
        for (int i = 0; i < argNodes.length; i++) {
            argumentValues[i] = argNodes[i].execute(frame);
        }

        try {
            return library.execute(func, argumentValues);
        } catch (ArityException | UnsupportedTypeException | UnsupportedMessageException e) {
            var source = func.getCallTarget().getRootNode().getSourceSection();
            throw new InvalidFunctionArgsException(func.getName(), func.getArgNames(), argumentValues, source.getStartLine(), source.getStartColumn());
        }
    }
}
