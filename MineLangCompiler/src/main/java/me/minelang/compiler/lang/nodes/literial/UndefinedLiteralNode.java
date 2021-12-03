package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.types.MineUndefined;

@NodeInfo(language = "MineLang", shortName = "none", description = "None literal node.")
public abstract class UndefinedLiteralNode extends AbstractLiteralNode {
    @Specialization
    public MineUndefined get() {
        return MineUndefined.SINGLETON;
    }

    @Override
    abstract public MineUndefined executeUndefined(VirtualFrame frame);
}
