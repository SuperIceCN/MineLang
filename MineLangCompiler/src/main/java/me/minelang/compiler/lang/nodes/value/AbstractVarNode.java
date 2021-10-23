package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "abstractVar", description = "Base class for variable operate.")
public abstract class AbstractVarNode extends MineNode {

}
