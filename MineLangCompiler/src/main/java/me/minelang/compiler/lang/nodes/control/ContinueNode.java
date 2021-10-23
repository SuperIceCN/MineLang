package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineNone;

@NodeInfo(language = "MineLang", shortName = "continue", description = "Continue current loop.")
public abstract class ContinueNode extends MineNode {
    @Specialization
    MineNone exe() {
        return MineNone.SINGLETON;
    }
}
