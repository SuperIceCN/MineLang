package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

public final class StdInPacket extends Packet {
    public StdInPacket(CompilerServer compilerServer) {
        super(ProtocolInfo.StdIn, compilerServer);
    }

    @Override
    public void exec() {

    }
}
