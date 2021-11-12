package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

public final class RefreshEnvPacket extends Packet {
    public RefreshEnvPacket(CompilerServer compilerServer) {
        super(ProtocolInfo.RefreshEnv, compilerServer);
    }

    @Override
    public void exec() {

    }
}
