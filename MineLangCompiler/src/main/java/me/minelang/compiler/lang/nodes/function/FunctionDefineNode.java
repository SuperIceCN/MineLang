package me.minelang.compiler.lang.nodes.function;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.MineLanguage;
import me.minelang.compiler.lang.nodes.MineFunctionRootNode;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineFunction;

@NodeInfo(language = "MineLang", shortName = "def", description = "Define a function.")
@NodeField(name = "functionName", type = String.class)
@NodeField(name = "argNames", type = String[].class)
public abstract class FunctionDefineNode extends MineNode {
    @Child
    FunctionBodyNode bodyNode;

    abstract String getFunctionName();

    abstract String[] getArgNames();

    FunctionDefineNode(FunctionBodyNode bodyNode) {
        this.bodyNode = bodyNode;
    }

    @Specialization
    MineFunction define(VirtualFrame frame
            , @Cached("frame.getFrameDescriptor().findOrAddFrameSlot(getFunctionName())") FrameSlot funcSlot) {
        var funcRootNode = new MineFunctionRootNode(MineLanguage.get(this), frame, getFunctionName(), getArgNames(), this.getSourceSection(), bodyNode);
        var func = new MineFunction(funcRootNode).setArgNames(getArgNames());
        frame.setObject(funcSlot, func);
        return func;
    }
}
