package me.minelang.compiler.utils;

import com.oracle.truffle.api.frame.FrameSlotKind;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.nodes.literial.*;

public class FrameSlotKindUtil {
    /**
     * 计算节点对应的变量槽种类
     *
     * @param mineNode 节点
     * @return 种类
     */
    public static FrameSlotKind calcForNode(MineNode mineNode) {
        if (mineNode instanceof ByteLiteralNode) {
            return FrameSlotKind.Byte;
        } else if (mineNode instanceof ShortLiteralNode || mineNode instanceof IntLiteralNode) {
            return FrameSlotKind.Int;
        } else if (mineNode instanceof LongLiteralNode) {
            return FrameSlotKind.Long;
        } else if (mineNode instanceof BoolLiteralNode) {
            return FrameSlotKind.Boolean;
        } else if (mineNode instanceof FloatLiteralNode) {
            return FrameSlotKind.Float;
        } else if (mineNode instanceof DoubleLiteralNode) {
            return FrameSlotKind.Double;
        } else {
            return FrameSlotKind.Object;
        }
    }

    /**
     * 计算值对应的变量槽种类
     *
     * @param object 节点
     * @return 种类
     */
    public static FrameSlotKind calcForValue(Object object) {
        if (object instanceof Byte) {
            return FrameSlotKind.Byte;
        } else if (object instanceof Short || object instanceof Integer) {
            return FrameSlotKind.Int;
        } else if (object instanceof Long) {
            return FrameSlotKind.Long;
        } else if (object instanceof Boolean) {
            return FrameSlotKind.Boolean;
        } else if (object instanceof Float) {
            return FrameSlotKind.Float;
        } else if (object instanceof Double) {
            return FrameSlotKind.Double;
        } else {
            return FrameSlotKind.Object;
        }
    }
}
