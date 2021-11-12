package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

/**
 * 数据格式
 * byte 种类
 * ......
 */
public final class BadPacket extends Packet {
    public BadPacket(CompilerServer compilerServer) {
        super(ProtocolInfo.BadPacket, compilerServer);
    }

    @Override
    public void exec() {
        System.out.println("Bad packet received! Src: " + new String(this.getNoHeadContent()));
    }
}
