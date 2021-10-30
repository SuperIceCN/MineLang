package me.minelang.compiler.parser;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import me.minelang.compiler.lang.nodes.value.AbstractVarNode;
import me.minelang.compiler.utils.FrameSlotKindUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class LexicalScope {
    private final LexicalScope root;
    private final LexicalScope parent;
    private final FrameDescriptor fd;
    public final Map<String, FrameSlotWithDescriptor> cacheSlots = new HashMap<>(8, 0.875f);
    public final Set<String> availableGlobals = new ObjectOpenHashSet<>();

    private LexicalScope(LexicalScope parent, FrameDescriptor fd) {
        this.parent = parent;
        this.fd = fd;
        if (parent == null) {
            this.root = this;
        } else {
            this.root = parent.root;
        }
    }

    public static LexicalScope of(LexicalScope parent, FrameDescriptor fd) {
        return new LexicalScope(parent, fd);
    }

    public LexicalScope getParent() {
        return parent;
    }

    public boolean isRoot() {
        return this.root == this;
    }

    public FrameDescriptor getFrameDescriptor() {
        return fd;
    }

    /**
     * 声明一个变量是全局的
     *
     * @param name 全局变量名称
     */
    public void global(String name) {
        this.availableGlobals.add(name);
    }

    public boolean isGlobal(String name) {
        return this.availableGlobals.contains(name);
    }

    public FrameSlotWithDescriptor find(String name) {
        // 如果是全局变量就直接查找根作用域
        if (!this.isRoot() && this.isGlobal(name)) {
            return this.root.directFind(name);
        }
        var tmp = cacheSlots.get(name);
        if (tmp == null) {
            var fr = fd.findFrameSlot(name);
            FrameSlotWithDescriptor ret = null;
            if (fr == null) {
                if (parent != null)
                    ret = parent.find(name);
            } else {
                ret = new FrameSlotWithDescriptor(fr, fd, this.isRoot());
            }
            if (ret != null) {
                cacheSlots.put(name, ret);
                return ret;
            }
            return new FrameSlotWithDescriptor(null, null, this.isRoot());
        } else {
            return tmp;
        }
    }

    public FrameSlotWithDescriptor directFind(String name) {
        // 如果是全局变量就直接查找根作用域
        if (!this.isRoot() && this.isGlobal(name)) {
            return this.root.directFind(name);
        }
        var tmp = cacheSlots.get(name);
        if (tmp == null) {
            var fr = fd.findFrameSlot(name);
            FrameSlotWithDescriptor ret = null;
            if (fr != null) {
                ret = new FrameSlotWithDescriptor(fr, fd, this.isRoot());
            }
            if (ret != null) {
                cacheSlots.put(name, ret);
                return ret;
            }
            return new FrameSlotWithDescriptor(null, null, this.isRoot());
        } else {
            return tmp;
        }
    }

    public FrameSlot declare(String name, VisitResult<?> expect) {
        if(!this.isRoot() && this.isGlobal(name)) {
            return this.root.declare(name, expect);
        }
        var expectNode = expect.singleNode();
        if (expectNode instanceof AbstractVarNode node && expect.extraValue() instanceof FrameDescriptor descriptor) {
            return fd.addFrameSlot(name, descriptor.getFrameSlotKind(node.getSlot()));
        } else {
            return fd.addFrameSlot(name, FrameSlotKindUtil.calcForNode(expectNode));
        }
    }

    public FrameSlot declare(String name) {
        if (!this.isRoot() && this.isGlobal(name)) {
            return this.root.declare(name);
        }
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

    public static record FrameSlotWithDescriptor(FrameSlot frameSlot, FrameDescriptor frameDescriptor,
                                                 boolean isGlobal) {
    }
}
