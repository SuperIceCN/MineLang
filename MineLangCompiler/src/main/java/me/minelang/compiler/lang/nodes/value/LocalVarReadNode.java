package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "localVarRead"
        , description = "Read the value stored in a local variable in the current scope.")
public abstract class LocalVarReadNode extends AbstractVarNode {
    @Specialization(rewriteOn = FrameSlotTypeException.class)
    byte readByte(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getByte(getSlot());
    }

    @Specialization(rewriteOn = FrameSlotTypeException.class)
    int readInt(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getInt(getSlot());
    }

    @Specialization(rewriteOn = FrameSlotTypeException.class)
    long readLong(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getLong(getSlot());
    }

    @Specialization(rewriteOn = FrameSlotTypeException.class)
    boolean readBoolean(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getBoolean(getSlot());
    }

    @Specialization(rewriteOn = FrameSlotTypeException.class)
    float readFloat(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getFloat(getSlot());
    }

    @Specialization(rewriteOn = FrameSlotTypeException.class)
    double readDouble(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getDouble(getSlot());
    }

    @Specialization(rewriteOn = FrameSlotTypeException.class)
    Object readObject(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getObject(getSlot());
    }

    @Specialization(replaces = {"readByte", "readInt", "readLong", "readBoolean", "readFloat", "readDouble", "readObject"})
    Object read(VirtualFrame virtualFrame) {
        return virtualFrame.getValue(getSlot());
    }
}