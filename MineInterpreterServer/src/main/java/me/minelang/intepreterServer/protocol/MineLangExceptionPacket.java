package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

public final class MineLangExceptionPacket extends Packet {
    public MineLangExceptionPacket(CompilerServer compilerServer) {
        super(ProtocolInfo.MineLangException, compilerServer);
    }

    @Override
    public void exec() {

    }
}
