package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.types.MineNan;

@NodeInfo(language = "MineLang", shortName = "nan", description = "Nan literal node.")
public abstract class NanLiteralNode extends AbstractLiteralNode {
    @Specialization
    public MineNan get() {
        return MineNan.SINGLETON;
    }

    @Override
    abstract public MineNan executeNan(VirtualFrame frame);
}
