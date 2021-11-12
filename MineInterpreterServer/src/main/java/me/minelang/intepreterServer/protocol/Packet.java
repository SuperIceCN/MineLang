package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

import java.nio.ByteBuffer;

public abstract sealed class Packet
        permits BadPacket, CloseServerPacket, ExecFilePacket, ExecStringPacket, JVMExceptionPacket, MessagePacket, MineLangExceptionPacket, RefreshEnvPacket, StdInPacket, StdOutPacket {
    public final ProtocolInfo protocolInfo;
    public final CompilerServer compilerServer;
    public ByteBuffer sourceContent;

    Packet(ProtocolInfo protocolInfo, CompilerServer compilerServer){
        this.protocolInfo = protocolInfo;
        this.compilerServer = compilerServer;
    }

    public ProtocolInfo getProtocolInfo() {
        return protocolInfo;
    }

    public ByteBuffer getSourceContent() {
        return sourceContent;
    }

    public Packet setSourceContent(ByteBuffer sourceContent) {
        this.sourceContent = sourceContent;
        return this;
    }

    public byte[] getNoHeadContent() {
        var src = this.sourceContent.array();
        var tmp = new byte[src.length - 1];
        System.arraycopy(src, 1, tmp, 0, tmp.length);
        return tmp;
    }

    public abstract void exec();

    public static Packet decode(CompilerServer server, ByteBuffer byteBuffer) {
        var protocolFlag = byteBuffer.get(0);
        var protocolInfo = switch (protocolFlag) {
            case 0x01 -> ProtocolInfo.Message;
            case 0x02 -> ProtocolInfo.ExecFile;
            case 0x03 -> ProtocolInfo.ExecString;
            case 0x04 -> ProtocolInfo.JVMException;
            case 0x05 -> ProtocolInfo.MineLangException;
            case 0x06 -> ProtocolInfo.StdIn;
            case 0x07 -> ProtocolInfo.StdOut;
            case 0x08 -> ProtocolInfo.RefreshEnv;
            case 0x09 -> ProtocolInfo.CloseServer;
            default -> ProtocolInfo.BadPacket;
        };
        return (switch (protocolInfo) {
            case BadPacket -> new BadPacket(server);
            case Message -> new MessagePacket(server);
            case ExecFile -> new ExecFilePacket(server);
            case ExecString -> new ExecStringPacket(server);
            case JVMException -> new JVMExceptionPacket(server);
            case MineLangException -> new MineLangExceptionPacket(server);
            case StdOut -> new StdOutPacket(server);
            case StdIn -> new StdInPacket(server);
            case RefreshEnv -> new RefreshEnvPacket(server);
            case CloseServer -> new CloseServerPacket(server);
        }).setSourceContent(byteBuffer.position(0));
    }
}
