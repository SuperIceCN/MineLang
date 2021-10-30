package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "lookUpVarWrite", description = "Store a value into a outer-frame variable.")
@NodeField(name = "val", type = Object.class)
@NodeField(name = "targetFrame", type = MaterializedFrame.class)
public abstract class FrameVarWriteNode extends AbstractVarNode{
    abstract Object getVal();
    abstract MaterializedFrame getTargetFrame();

    @Specialization(guards = "isByteKind(getVal())")
    byte writeByte(VirtualFrame frame) {
        var value = (byte) getVal();
        getTargetFrame().setByte(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isShortKind(getVal())")
    short writeShort(VirtualFrame frame) {
        var value = (short) getVal();
        getTargetFrame().setInt(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isIntKind(getVal())")
    int writeInt(VirtualFrame frame) {
        var value = (int) getVal();
        getTargetFrame().setInt(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isLongKind(getVal())")
    long writeLong(VirtualFrame frame) {
        var value = (long) getVal();
        getTargetFrame().setLong(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isBooleanKind(getVal())")
    boolean writeBoolean(VirtualFrame frame) {
        var value = (boolean) getVal();
        getTargetFrame().setBoolean(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isFloatKind(getVal())")
    float writeFloat(VirtualFrame frame) {
        var value = (float) getVal();
        getTargetFrame().setFloat(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isDoubleKind(getVal())")
    double writeDouble(VirtualFrame frame) {
        var value = (double) getVal();
        getTargetFrame().setDouble(this.getSlot(), value);
        return value;
    }

    @Specialization(replaces = {"writeByte", "writeShort", "writeInt", "writeLong", "writeBoolean", "writeFloat", "writeDouble"})
    Object write(VirtualFrame frame) {
        var value = getVal();
        getTargetFrame().setObject(getSlot(), value);
        return value;
    }

    boolean isByteKind(Object value) {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Byte && value instanceof Byte;
    }

    boolean isShortKind(Object value) {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Int && value instanceof Short;
    }

    boolean isIntKind(Object value) {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Int && value instanceof Integer;
    }

    boolean isLongKind(Object value) {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Long && value instanceof Long;
    }

    boolean isBooleanKind(Object value) {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Long && value instanceof Boolean;
    }

    boolean isFloatKind(Object value) {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Float && value instanceof Float;
    }

    boolean isDoubleKind(Object value) {
        return getTargetFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Double && value instanceof Double;
    }
}
