package me.minelang.intepreterServer.protocol;

public enum ProtocolInfo {
    BadPacket((byte) 0x00),
    Message((byte) 0x01),
    ExecFile((byte) 0x02),
    ExecString((byte) 0x03),
    JVMException((byte) 0x04),
    MineLangException((byte) 0x05),
    StdOut((byte) 0x06),
    StdIn((byte) 0x07),
    RefreshEnv((byte) 0x08),
    CloseServer((byte) 0x09);

    public final byte identity;

    ProtocolInfo(byte identity){
        this.identity = identity;
    }
}
