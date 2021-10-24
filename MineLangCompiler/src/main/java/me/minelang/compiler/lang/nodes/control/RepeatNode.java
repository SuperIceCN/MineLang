package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RepeatingNode;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.api.profiles.ConditionProfile;
import me.minelang.compiler.lang.exceptions.LoopBreakException;
import me.minelang.compiler.lang.exceptions.LoopContinueException;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.utils.ConditionUtil;

@SuppressWarnings("FieldMayBeFinal")
@NodeInfo(language = "MineLang", shortName = "repeater", description = "The core of loops.")
public final class RepeatNode extends Node implements RepeatingNode {
    @Child
    private MineNode conditionNode;
    @Child
    private MineNode bodyNode;

    /**
     * 用于由解释器收集的分析信息，用于捕获此循环中是否使用了continue语句。
     * 这允许编译器为循环生成更好的代码，而无需继续分析解释代码。
     */
    private final BranchProfile continueTaken = BranchProfile.create();
    private final BranchProfile breakTaken = BranchProfile.create();
    private final ConditionProfile conditionProfile = ConditionProfile.createCountingProfile();

    private LoopStatus LOOP_RETURN_VALUE = LoopStatus.Continue;

    public RepeatNode(MineNode conditionNode, MineNode bodyNode) {
        this.conditionNode = conditionNode;
        this.bodyNode = bodyNode;
    }

    @Override
    public boolean executeRepeating(VirtualFrame frame) {
        if (!conditionProfile.profile(ConditionUtil.testCondition(conditionNode, frame))) {
            LOOP_RETURN_VALUE = new LoopStatus(true, null);
            return false;
        }
        try {
            bodyNode.execute(frame);
            return true;
        } catch (LoopContinueException ex) {
            // 记录continue造成的控制流更改
            continueTaken.enter();
            return true;
        } catch (LoopBreakException ex) {
            // 记录break造成的控制流更改
            breakTaken.enter();
            LOOP_RETURN_VALUE = new LoopStatus(false, ex.getReturnValue());
            return false;
        }
    }

    @Override
    public Object executeRepeatingWithValue(VirtualFrame frame) {
        if (executeRepeating(frame)) {
            return LoopStatus.Continue;
        } else {
            return LOOP_RETURN_VALUE;
        }
    }

    @Override
    public Object initialLoopStatus() {
        return LoopStatus.Continue;
    }
}
