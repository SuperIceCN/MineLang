package me.minelang.compiler.lang.nodes;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import me.minelang.compiler.lang.MineTypeSystem;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;
import me.minelang.compiler.lang.types.MineFunction;
import me.minelang.compiler.lang.types.MineNone;
import me.minelang.compiler.lang.MineTypeSystemGen;

@TypeSystemReference(MineTypeSystem.class)
@GenerateNodeFactory
@NodeInfo(language = "MineLang", shortName = "abstract", description = "The abstract base node for all expressions")
public abstract class MineNode extends Node {
    public boolean executeBool(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectBoolean(this.execute(frame));
    }

    public byte executeByte(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectByte(this.execute(frame));
    }

    public short executeShort(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectShort(this.execute(frame));
    }

    public int executeInteger(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectInteger(this.execute(frame));
    }

    public long executeLong(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectLong(this.execute(frame));
    }

    public float executeFloat(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectFloat(this.execute(frame));
    }

    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectDouble(this.execute(frame));
    }

    public MineBigInteger executeMineBigInteger(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectMineBigInteger(this.execute(frame));
    }

    public MineBigDecimal executeMineBigDecimal(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectMineBigDecimal(this.execute(frame));
    }

    public String executeString(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectString(this.execute(frame));
    }

    public MineFunction executeFunction(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectMineFunction(this.execute(frame));
    }

    public MineNone executeNone(VirtualFrame frame) throws UnexpectedResultException {
        return MineTypeSystemGen.expectMineNone(this.execute(frame));
    }

    public abstract Object execute(VirtualFrame frame);
}
