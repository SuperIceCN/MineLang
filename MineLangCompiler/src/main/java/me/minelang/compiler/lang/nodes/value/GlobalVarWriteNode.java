package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.MineContext;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.utils.FrameSlotKindUtil;

@NodeInfo(language = "MineLang", shortName = "globalVarWrite", description = "Write/create a value into a global variable.")
@NodeChild(value = "value", type = MineNode.class)
public abstract class GlobalVarWriteNode extends AbstractVarNode {
    private MaterializedFrame globalFrame = null;

    private MaterializedFrame getFrame() {
        return globalFrame == null ? globalFrame = MineContext.get(this).getRootFrame() : globalFrame;
    }

    @Specialization(guards = "isByteKind()")
    byte writeByte(VirtualFrame frame, byte value) {
        getFrame().setByte(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isIntKind()")
    short writeInt(VirtualFrame frame, short value) {
        getFrame().setInt(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isIntKind()")
    int writeInt(VirtualFrame frame, int value) {
        getFrame().setInt(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isLongKind()")
    long writeLong(VirtualFrame frame, long value) {
        getFrame().setLong(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isBooleanKind()")
    boolean writeBoolean(VirtualFrame frame, boolean value) {
        getFrame().setBoolean(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isFloatKind()")
    float writeFloat(VirtualFrame frame, float value) {
        getFrame().setFloat(this.getSlot(), value);
        return value;
    }

    @Specialization(guards = "isDoubleKind()")
    double writeDouble(VirtualFrame frame, double value) {
        getFrame().setDouble(this.getSlot(), value);
        return value;
    }

    @Specialization(replaces = {"writeByte", "writeInt", "writeLong", "writeBoolean", "writeFloat", "writeDouble"})
    Object write(VirtualFrame frame, Object value) {
        var slot = this.getSlot();
        var currentKind = getFrame().getFrameDescriptor().getFrameSlotKind(slot);
        var expectSlotKind = FrameSlotKindUtil.calcForValue(value);
        if (currentKind != expectSlotKind) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            getFrame().getFrameDescriptor().setFrameSlotKind(slot, expectSlotKind);
            return this.replace(FrameVarWriteNodeFactory.create(slot, value, getFrame())).execute(frame);
        }
        getFrame().setObject(slot, value);
        return value;
    }

    boolean isByteKind() {
        return getFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Byte;
    }

    boolean isIntKind() {
        return getFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Int;
    }

    boolean isLongKind() {
        return getFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Long;
    }

    boolean isBooleanKind() {
        return getFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Long;
    }

    boolean isFloatKind() {
        return getFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Float;
    }

    boolean isDoubleKind() {
        return getFrame().getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Double;
    }
}