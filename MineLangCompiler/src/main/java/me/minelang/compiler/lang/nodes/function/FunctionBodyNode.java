package me.minelang.compiler.lang.nodes.function;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.profiles.BranchProfile;
import me.minelang.compiler.lang.exceptions.control.FunctionReturnException;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.nodes.control.BlockNode;
import me.minelang.compiler.utils.FrameSlotKindUtil;

@NodeInfo(language = "MineLang", shortName = "functionBody", description = "A body of a function.")
public final class FunctionBodyNode extends MineNode {
    @Child
    MineNode bodyNode;
    @CompilationFinal
    String[] argNames;
    @CompilationFinal
    Object[] argValues;
    @CompilationFinal
    FrameSlot[] argSlots = null;

    /**
     * 用于收集该函数是否通过 {@link ReturnNode} 被提前返回的信息收集器
     * jit编译器可以通过这里的信息生成更好的机器码。
     */
    private final BranchProfile exceptionTaken = BranchProfile.create();
    private final BranchProfile returnLastTaken = BranchProfile.create();

    FunctionBodyNode(MineNode bodyNode) {
        this.bodyNode = bodyNode;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        CompilerAsserts.partialEvaluationConstant(argNames.length);
        CompilerAsserts.partialEvaluationConstant(argValues.length);

        try {
            if (bodyNode instanceof BlockNode blockNode) {
                var descriptor = blockNode.descriptor;
                var blockFrame = Truffle.getRuntime().createVirtualFrame(new Object[]{frame.materialize()}, descriptor);

                // 如果是第一次运行，那么初始化参数变量，此时需要告知原来的null是错误的
                if (argSlots == null) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    var currentSlots = new FrameSlot[argNames.length];
                    for (var i = 0; i < argNames.length; i++) {
                        var value = argValues[i];
                        var name = argNames[i];
                        var slotKind = FrameSlotKindUtil.calcForValue(value);
                        var slot = descriptor.findOrAddFrameSlot(name, slotKind);
                        currentSlots[i] = slot;
                        FrameSlotKindUtil.autoSetInFrame(blockFrame, slot, slotKind, value);
                    }
                    argSlots = currentSlots;
                } else {
                    for (var i = 0; i < argNames.length; i++) {
                        var value = argValues[i];
                        var slotKind = FrameSlotKindUtil.calcForValue(value);
                        var slot = argSlots[i];
                        FrameSlotKindUtil.autoSetInFrame(blockFrame, slot, slotKind, value);
                    }
                }

                return bodyNode.execute(blockFrame);
            } else {
                returnLastTaken.enter();

                // 如果是第一次运行，那么初始化参数变量，此时需要告知原来的null是错误的
                if (argSlots == null) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    var currentSlots = new FrameSlot[argNames.length];
                    for (var i = 0; i < argNames.length; i++) {
                        var value = argValues[i];
                        var name = argNames[i];
                        var slotKind = FrameSlotKindUtil.calcForValue(value);
                        var slot = frame.getFrameDescriptor().findOrAddFrameSlot(name, slotKind);
                        currentSlots[i] = slot;
                        FrameSlotKindUtil.autoSetInFrame(frame, slot, slotKind, value);
                    }
                    argSlots = currentSlots;
                } else {
                    for (var i = 0; i < argNames.length; i++) {
                        var value = argValues[i];
                        var slotKind = FrameSlotKindUtil.calcForValue(value);
                        var slot = argSlots[i];
                        FrameSlotKindUtil.autoSetInFrame(frame, slot, slotKind, value);
                    }
                }

                return bodyNode.execute(frame);
            }
        } catch (FunctionReturnException ex) {
            exceptionTaken.enter();
            return ex.getReturnValue();
        }
    }

    public FunctionBodyNode setArgNames(String[] argNames) {
        this.argNames = argNames;
        return this;
    }

    public FunctionBodyNode setArgValues(Object[] argValues) {
        this.argValues = argValues;
        return this;
    }
}
