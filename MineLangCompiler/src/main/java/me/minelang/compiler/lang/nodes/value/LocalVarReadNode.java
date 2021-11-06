package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "localVarRead"
        , description = "Read the value stored in a local variable in the current scope.")
public abstract class LocalVarReadNode extends AbstractVarNode {
    private boolean hasOwnership = false;
    private boolean ownershipChecked = false;

    @Specialization(guards = "checkOwnership(virtualFrame)", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    byte readByte(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getByte(getSlot());
    }

    @Specialization(guards = "checkOwnership(virtualFrame)", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    int readInt(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getInt(getSlot());
    }

    @Specialization(guards = "checkOwnership(virtualFrame)", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    long readLong(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getLong(getSlot());
    }

    @Specialization(guards = "checkOwnership(virtualFrame)", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    boolean readBoolean(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getBoolean(getSlot());
    }

    @Specialization(guards = "checkOwnership(virtualFrame)", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    float readFloat(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getFloat(getSlot());
    }

    @Specialization(guards = "checkOwnership(virtualFrame)", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    double readDouble(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getDouble(getSlot());
    }

    @Specialization(guards = "checkOwnership(virtualFrame)", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    Object readObject(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return virtualFrame.getObject(getSlot());
    }

    @Specialization(replaces = {"readByte", "readInt", "readLong", "readBoolean", "readFloat", "readDouble", "readObject"})
    Object read(VirtualFrame virtualFrame) {
        if (virtualFrame.getArguments().length > 0) {
            if (virtualFrame.getArguments()[0] instanceof MaterializedFrame outerFrame) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                var newReadNode = FrameVarReadNodeFactory.create(getSlot(), outerFrame);
                return this.replace(newReadNode).execute(virtualFrame);
            }
        }
        return virtualFrame.getValue(getSlot());
    }

    boolean checkOwnership(VirtualFrame virtualFrame) {
        if (!ownershipChecked) {
            ownershipChecked = true;
            try {
                virtualFrame.getFrameDescriptor().getFrameSlotKind(getSlot());
                hasOwnership = true;
            } catch (AssertionError e) {
                hasOwnership = false;
            }
        }
        return hasOwnership;
    }
}