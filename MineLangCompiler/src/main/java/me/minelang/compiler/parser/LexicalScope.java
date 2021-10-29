package me.minelang.compiler.parser;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import me.minelang.compiler.lang.nodes.value.AbstractVarNode;
import me.minelang.compiler.utils.FrameSlotKindUtil;

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
        } else {
            return fd.addFrameSlot(name, FrameSlotKindUtil.calcForNode(expectNode));
        }
    }

    public FrameSlot declare(String name) {
        return fd.addFrameSlot(name);
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
