package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

public final class CloseServerPacket extends Packet {
    public CloseServerPacket(CompilerServer compilerServer) {
        super(ProtocolInfo.CloseServer, compilerServer);
    }

    @Override
    public void exec() {

    }
}
