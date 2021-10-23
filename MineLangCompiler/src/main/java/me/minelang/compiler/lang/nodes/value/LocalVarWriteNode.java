package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "localVarWrite", description = "Write/create a value into a variable.")
@NodeChild(value = "value", type = MineNode.class)
@NodeField(name = "varName", type = String.class)
public abstract class LocalVarWriteNode extends AbstractVarNode {
    public abstract String getVarName();

    @Specialization
    byte writeByte(VirtualFrame frame, byte value) {
        frame.setByte(frame.getFrameDescriptor().findOrAddFrameSlot(getVarName(), FrameSlotKind.Byte), value);
        return value;
    }

    @Specialization
    short writeInt(VirtualFrame frame, short value) {
        frame.setInt(frame.getFrameDescriptor().findOrAddFrameSlot(getVarName(), FrameSlotKind.Int), value);
        return value;
    }

    @Specialization
    int writeInt(VirtualFrame frame, int value) {
        frame.setInt(frame.getFrameDescriptor().findOrAddFrameSlot(getVarName(), FrameSlotKind.Int), value);
        return value;
    }

    @Specialization
    long writeLong(VirtualFrame frame, long value) {
        frame.setLong(frame.getFrameDescriptor().findOrAddFrameSlot(getVarName(), FrameSlotKind.Long), value);
        return value;
    }

    @Specialization
    boolean writeBoolean(VirtualFrame frame, boolean value) {
        frame.setBoolean(frame.getFrameDescriptor().findOrAddFrameSlot(getVarName(), FrameSlotKind.Boolean), value);
        return value;
    }

    @Specialization
    float writeFloat(VirtualFrame frame, float value) {
        frame.setFloat(frame.getFrameDescriptor().findOrAddFrameSlot(getVarName(), FrameSlotKind.Float), value);
        return value;
    }

    @Specialization
    double writeDouble(VirtualFrame frame, double value) {
        frame.setDouble(frame.getFrameDescriptor().findOrAddFrameSlot(getVarName(), FrameSlotKind.Double), value);
        return value;
    }

    @Specialization(replaces = {"writeByte", "writeInt", "writeLong", "writeBoolean", "writeFloat", "writeDouble"})
    Object write(VirtualFrame frame, Object value) {
        frame.setObject(frame.getFrameDescriptor().findOrAddFrameSlot(getVarName(), FrameSlotKind.Object), value);
        return value;
    }
}
