package me.minelang.compiler.parser;

import me.minelang.compiler.lang.nodes.MineNode;

import java.util.Arrays;
import java.util.List;

public final class VisitResult<T> {
    private final MineNode singleNode;
    private final List<MineNode> multiNodes;
    private final T value;

    private VisitResult(MineNode singleNode, List<MineNode> multiNodes, T value) {
        this.singleNode = singleNode;
        this.multiNodes = multiNodes;
        this.value = value;
    }

    public static VisitResult<Void> of(MineNode singleNode) {
        return new VisitResult<>(singleNode, null, null);
    }

    public static VisitResult<Void> of(MineNode node, MineNode... nodes) {
        if (nodes.length == 0) {
            return new VisitResult<>(node, null, null);
        } else {
            var tmp = Arrays.asList(nodes);
            tmp.add(0, node);
            return new VisitResult<>(null, tmp, null);
        }
    }

    public static <T> VisitResult<T> of(T extraValue, MineNode node, MineNode... nodes) {
        if (nodes.length == 0) {
            return new VisitResult<>(node, null, extraValue);
        } else {
            var tmp = Arrays.asList(nodes);
            tmp.add(0, node);
            return new VisitResult<>(null, tmp, extraValue);
        }
    }

    public static VisitResult<Void> of(List<MineNode> nodes) {
        return new VisitResult<>(null, nodes, null);
    }

    public static <T> VisitResult<T> of(T extraValue, List<MineNode> nodes) {
        return new VisitResult<>(null, nodes, extraValue);
    }

    public static <T> VisitResult<T> of(T value) {
        return new VisitResult<>(null, null, value);
    }

    public MineNode singleNode() {
        assert singleNode != null;
        assert multiNodes == null;
        return singleNode;
    }

    public List<MineNode> multiNode() {
        assert singleNode == null;
        assert multiNodes != null;
        return multiNodes;
    }

    public T extraValue() {
        return value;
    }
}
