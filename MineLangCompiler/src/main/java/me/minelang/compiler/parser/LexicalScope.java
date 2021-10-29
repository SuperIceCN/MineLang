package me.minelang.compiler.parser;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import me.minelang.compiler.lang.nodes.literial.*;
import me.minelang.compiler.lang.nodes.value.AbstractVarNode;

import java.util.HashMap;
import java.util.Objects;

public final class LexicalScope {
    private final LexicalScope parent;
    private final FrameDescriptor fd;
    public final HashMap<String, FrameSlot> cacheSlots = new HashMap<>(8, 0.875f);

    private LexicalScope(LexicalScope parent, FrameDescriptor fd) {
        this.parent = parent;
        this.fd = fd;
    }

    public static LexicalScope of(LexicalScope parent, FrameDescriptor fd) {
        return new LexicalScope(parent, fd);
    }

    public LexicalScope getParent() {
        return parent;
    }

    public FrameDescriptor getFrameDescriptor() {
        return fd;
    }

    public FrameSlotWithDescriptor find(String name) {
        var tmp = cacheSlots.get(name);
        if (tmp == null) return new FrameSlotWithDescriptor(fd.findFrameSlot(name), fd);
        if (parent != null) return parent.find(name);
        return null;
    }

    public FrameSlotWithDescriptor directFind(String name) {
        var tmp = cacheSlots.get(name);
        if (tmp == null) return new FrameSlotWithDescriptor(fd.findFrameSlot(name), fd);
        return null;
    }

    public FrameSlot declare(String name, VisitResult<?> expect) {
        var expectNode = expect.singleNode();
        if (expectNode instanceof AbstractVarNode node && expect.extraValue() instanceof FrameDescriptor descriptor) {
            return fd.addFrameSlot(name, descriptor.getFrameSlotKind(node.getSlot()));
        } else if (expectNode instanceof ByteLiteralNode) {
            return fd.addFrameSlot(name, FrameSlotKind.Byte);
        } else if (expectNode instanceof ShortLiteralNode || expectNode instanceof IntLiteralNode) {
            return fd.addFrameSlot(name, FrameSlotKind.Int);
        } else if (expectNode instanceof LongLiteralNode) {
            return fd.addFrameSlot(name, FrameSlotKind.Long);
        } else if (expectNode instanceof BoolLiteralNode) {
            return fd.addFrameSlot(name, FrameSlotKind.Boolean);
        } else if (expectNode instanceof FloatLiteralNode) {
            return fd.addFrameSlot(name, FrameSlotKind.Float);
        } else if (expectNode instanceof DoubleLiteralNode) {
            return fd.addFrameSlot(name, FrameSlotKind.Double);
        } else {
            return fd.addFrameSlot(name, FrameSlotKind.Object);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (LexicalScope) obj;
        return Objects.equals(this.parent, that.parent) &&
                Objects.equals(this.fd, that.fd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, fd);
    }

    @Override
    public String toString() {
        return "LexicalScope[" +
                "parent=" + parent + ", " +
                "fd=" + fd + ']';
    }

    public static record FrameSlotWithDescriptor(FrameSlot frameSlot, FrameDescriptor frameDescriptor) {
    }
}
