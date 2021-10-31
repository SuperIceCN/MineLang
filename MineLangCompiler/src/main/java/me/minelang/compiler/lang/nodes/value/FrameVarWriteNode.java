package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "lookUpVarWrite", description = "Store a value into a outer-frame variable.")
@NodeChild(value = "value", type = MineNode.class)
@NodeField(name = "targetFrame", type = MaterializedFrame.class)
public abstract class FrameVarWriteNode extends AbstractVarNode{
    abstract MaterializedFrame getTargetFrame();

    @Specialization(guards = "isByteKind()")
    byte writeByte(VirtualFrame frame, byte value) {
        getTargetFrame().setByte(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isShortKind()")
    short writeShort(VirtualFrame frame, short value) {
        getTargetFrame().setInt(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isIntKind()")
    int writeInt(VirtualFrame frame, int value) {
        getTargetFrame().setInt(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isLongKind()")
    long writeLong(VirtualFrame frame, long value) {
        getTargetFrame().setLong(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isBooleanKind()")
    boolean writeBoolean(VirtualFrame frame, boolean value) {
        getTargetFrame().setBoolean(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isFloatKind()")
    float writeFloat(VirtualFrame frame, float value) {
        getTargetFrame().setFloat(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isDoubleKind()")
    double writeDouble(VirtualFrame frame, double value) {
        getTargetFrame().setDouble(this.getSlot(), value);
        return value;
    }

    @Specialization(replaces = {"writeByte", "writeShort", "writeInt", "writeLong", "writeBoolean", "writeFloat", "writeDouble"})
    Object write(VirtualFrame frame, Object value) {
        getTargetFrame().setObject(getSlot(), value);
        return value;
    }

    boolean isByteKind() {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Byte;
    }

    boolean isShortKind() {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Int;
    }

    boolean isIntKind() {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Int;
    }

    boolean isLongKind() {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Long;
    }

    boolean isBooleanKind() {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Long;
    }

    boolean isFloatKind() {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Float;
    }

    boolean isDoubleKind() {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Double;
    }
}
