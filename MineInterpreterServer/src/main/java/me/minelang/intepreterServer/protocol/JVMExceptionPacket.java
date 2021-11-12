package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

/**
 * 数据格式
 * byte 包头
 * int 异常
 */
public final class JVMExceptionPacket extends Packet {
    public JVMExceptionPacket(CompilerServer compilerServer) {
        super(ProtocolInfo.JVMException, compilerServer);
    }

    @Override
    public void exec() {

    }
}
