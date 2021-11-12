package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

public final class ExecFilePacket extends Packet {
    public ExecFilePacket(CompilerServer compilerServer) {
        super(ProtocolInfo.ExecFile, compilerServer);
    }

    @Override
    public void exec() {

    }
}
