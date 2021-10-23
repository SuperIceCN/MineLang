package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.types.MineNone;

@NodeInfo(language = "MineLang", shortName = "none", description = "None literal node.")
public abstract class NoneLiteralNode extends AbstractLiteralNode {
    @Specialization
    MineNone get() {
        return MineNone.SINGLETON;
    }
}
