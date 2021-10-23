package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.exceptions.LoopBreakException;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "break", description = "Break current loop.")
public abstract class BreakNode extends MineNode {
    @Specialization
    Object get(){
        throw LoopBreakException.create();
    }
}
