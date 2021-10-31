package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.utils.FrameSlotKindUtil;

@NodeInfo(language = "MineLang", shortName = "localVarWrite", description = "Write/create a value into a variable.")
@NodeChild(value = "value", type = MineNode.class)
public abstract class LocalVarWriteNode extends AbstractVarNode {
    abstract MineNode getValue();

    @Specialization(guards = "isByteKind(frame)")
    byte writeByte(VirtualFrame frame, byte value) {
        frame.setByte(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isIntKind(frame)")
    short writeInt(VirtualFrame frame, short value) {
        frame.setInt(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isIntKind(frame)")
    int writeInt(VirtualFrame frame, int value) {
        frame.setInt(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isLongKind(frame)")
    long writeLong(VirtualFrame frame, long value) {
        frame.setLong(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isBooleanKind(frame)")
    boolean writeBoolean(VirtualFrame frame, boolean value) {
        frame.setBoolean(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isFloatKind(frame)")
    float writeFloat(VirtualFrame frame, float value) {
        frame.setFloat(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isDoubleKind(frame)")
    double writeDouble(VirtualFrame frame, double value) {
        frame.setDouble(this.getSlot(), value);
        return value;
    }

    @Specialization(replaces = {"writeByte", "writeInt", "writeLong", "writeBoolean", "writeFloat", "writeDouble"})
    Object write(VirtualFrame frame, Object value) {
        var slot = this.getSlot();
        var currentKind = frame.getFrameDescriptor().getFrameSlotKind(slot);
        var expectSlotKind = FrameSlotKindUtil.calcForValue(value);
        if (currentKind != expectSlotKind) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            frame.getFrameDescriptor().setFrameSlotKind(slot, expectSlotKind);
            return this.replace(FrameVarWriteNodeFactory.create(getValue(), slot, frame.materialize())).execute(frame);
        }
        frame.setObject(slot, value);
        return value;
    }

    boolean isByteKind(VirtualFrame frame) {
        return frame.getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Byte;
    }

    boolean isIntKind(VirtualFrame frame) {
        return frame.getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Int;
    }

    boolean isLongKind(VirtualFrame frame) {
        return frame.getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Long;
    }

    boolean isBooleanKind(VirtualFrame frame) {
        return frame.getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Long;
    }

    boolean isFloatKind(VirtualFrame frame) {
        return frame.getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Float;
    }

    boolean isDoubleKind(VirtualFrame frame) {
        return frame.getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Double;
    }
}