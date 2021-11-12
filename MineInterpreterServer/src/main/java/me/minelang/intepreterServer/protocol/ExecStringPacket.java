package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

public final class ExecStringPacket extends Packet {
    public ExecStringPacket(CompilerServer compilerServer) {
        super(ProtocolInfo.ExecString, compilerServer);
    }

    @Override
    public void exec() {

    }
}
