package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

public final class StdOutPacket extends Packet {
    public StdOutPacket(CompilerServer compilerServer) {
        super(ProtocolInfo.StdOut, compilerServer);
    }

    @Override
    public void exec() {

    }
}
