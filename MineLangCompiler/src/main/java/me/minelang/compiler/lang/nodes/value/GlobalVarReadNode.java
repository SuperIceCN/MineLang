package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.MineContext;
import me.minelang.compiler.lang.exceptions.runtime.GlobalVarNotFoundException;

@NodeInfo(language = "MineLang", shortName = "globalVarRead"
        , description = "Read the value stored in a global variable.")
public abstract class GlobalVarReadNode extends AbstractVarNode {
    private MaterializedFrame globalFrame = null;

    private MaterializedFrame getFrame() {
        return globalFrame == null ? globalFrame = MineContext.get(this).getRootFrame() : globalFrame;
    }
    
    @Specialization(rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    byte readByte(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getByte(getSlot());
    }

    @Specialization(rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    int readInt(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getInt(getSlot());
    }

    @Specialization(rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    long readLong(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getLong(getSlot());
    }

    @Specialization(rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    boolean readBoolean(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getBoolean(getSlot());
    }

    @Specialization(rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    float readFloat(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getFloat(getSlot());
    }

    @Specialization(rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    double readDouble(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getDouble(getSlot());
    }

    @Specialization(rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    Object readObject(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getObject(getSlot());
    }

    @Specialization(replaces = {"readByte", "readInt", "readLong", "readBoolean", "readFloat", "readDouble", "readObject"})
    Object read(VirtualFrame virtualFrame) {
        throw new GlobalVarNotFoundException(this);
    }
}
