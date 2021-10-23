package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.ConditionProfile;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineNone;

@NodeInfo(language = "MineLang", shortName = "ifElse", description = "A if-else condition node.")
public final class IfElseNode extends MineNode {
    @Children final MineNode[] conditions;
    @Children final BlockNode[] branches;

    // Truffle期望通过这个玩意来收集运行时优化信息
    private final ConditionProfile profile = ConditionProfile.createCountingProfile();

    IfElseNode(MineNode[] condition, BlockNode[] branches) {
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

        for(var i=0; i< branches.length; i++) {
            if(i >= conditions.length || profile.profile(testResult(conditions[i], frame))){
                var branchBlock = branches[i];
                var descriptor = branchBlock.descriptor;
                var blockFrame = Truffle.getRuntime().createVirtualFrame(new Object[]{frame.materialize()}, descriptor);
                return branchBlock.execute(blockFrame);
            }
        }

        return MineNone.SINGLETON;
    }

    /**
     * 测试条件节点是否为真，
     * bool: true/false，
     * MineNone: false，
     * String: 非空字符串为真，
     * 其余: 非零为真
     * @param conditionNode 条件节点
     * @param frame 当前栈帧
     * @return 是否为真
     */
    private boolean testResult(MineNode conditionNode, VirtualFrame frame) {
        try {
            return conditionNode.executeBool(frame);
        } catch (UnexpectedResultException e1) {
            try {
                return conditionNode.executeNone(frame) == MineNone.SINGLETON;
            } catch (UnexpectedResultException e2) {
                try {
                    return conditionNode.executeString(frame).length() != 0;
                } catch (UnexpectedResultException e) {
                    var tmp =  conditionNode.execute(frame);
                    return tmp != null && !tmp.equals(0);
                }
            }
        }
    }


}
