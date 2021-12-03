package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.profiles.ConditionProfile;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineUndefined;
import me.minelang.compiler.utils.ConditionUtil;

@NodeInfo(language = "MineLang", shortName = "ifElse", description = "A if-else condition node.")
public final class IfElseNode extends MineNode {
    @Children
    final MineNode[] conditions;
    @Children
    final MineNode[] branches;

    // Truffle期望通过这个玩意来收集运行时优化信息
    private final ConditionProfile profile = ConditionProfile.createCountingProfile();

    IfElseNode(MineNode[] condition, MineNode[] branches) {
        this.conditions = condition;
        this.branches = branches;
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        // TODO: 2021/10/23 优化处理此处断言，如不成立通知Truffle并传到错误处理机制
        assert branches.length >= conditions.length;
        assert branches.length - conditions.length <= 1;
        CompilerAsserts.partialEvaluationConstant(branches.length);
        CompilerAsserts.partialEvaluationConstant(conditions.length);

        for (var i = 0; i < branches.length; i++) {
            if (i >= conditions.length || profile.profile(ConditionUtil.testCondition(conditions[i], frame))) {
                var branchNode = branches[i];
                if (branchNode instanceof BlockNode branchBlock) {
                    var descriptor = branchBlock.descriptor;
                    var blockFrame = Truffle.getRuntime().createVirtualFrame(new Object[]{frame.materialize()}, descriptor);
                    return branchBlock.execute(blockFrame);
                } else {
                    return branchNode.execute(frame);
                }
            }
        }

        return MineUndefined.SINGLETON;
    }
}
