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
import me.minelang.compiler.lang.exceptions.runtime.ForeignFunctionCallFailedException;
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

    @Specialization(guards = "library.isExecutable(func)", limit = "4") //在4次调用失败之后就直接不再进行尝试了，说明这个节点逻辑彻底错误，此时去优化性价比太低
    @ExplodeLoop
    Object invoke(VirtualFrame frame, Object func, @CachedLibrary("func") InteropLibrary library) { //func用Object是为了兼容js和java的函数(WIP)
        var argNodes = args;
        CompilerAsserts.compilationConstant(args.length);

        var argumentValues = new Object[argNodes.length];
        for (int i = 0; i < argNodes.length; i++) {
            argumentValues[i] = argNodes[i].execute(frame);
        }

        try {
            return library.execute(func, argumentValues);
        } catch (ArityException | UnsupportedTypeException | UnsupportedMessageException e) {
            var source = this.getSourceSection();
            if (func instanceof MineFunction mineFunc) {
                throw new InvalidFunctionArgsException(mineFunc.getName(), mineFunc.getArgNames(), argumentValues, source.getStartLine(), source.getStartColumn());
            }else {
                if (library.hasExecutableName(func)) {
                    try {
                        throw new ForeignFunctionCallFailedException(library.getExecutableName(func).toString(), argumentValues, source.getStartLine(), source.getStartColumn());
                    } catch (UnsupportedMessageException ex) {
                        throw new ForeignFunctionCallFailedException(library.toDisplayString(func).toString(), argumentValues, source.getStartLine(), source.getStartColumn());
                    }
                }else {
                    throw new ForeignFunctionCallFailedException(library.toDisplayString(func).toString(), argumentValues, source.getStartLine(), source.getStartColumn());
                }
            }
        }
    }
}
