package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "abstractVar", description = "Base class for variable operate.")
@NodeField(name = "slot", type = FrameSlot.class)
public abstract class AbstractVarNode extends MineNode {
    protected abstract FrameSlot getSlot();

    @Override
    public String toString() {
        CompilerAsserts.neverPartOfCompilation("do not call toString from compiled code");
        return "var: " + this.getSlot().getIdentifier();
    }
}