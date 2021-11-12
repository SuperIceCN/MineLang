package me.minelang.intepreterServer.protocol;

import me.minelang.intepreterServer.CompilerServer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * 数据格式
 * byte 包头
 * int 消息字节长度
 * byte[] 消息字符串
 */
public final class MessagePacket extends Packet {
    public final String message;

    public MessagePacket(CompilerServer compilerServer) {
        super(ProtocolInfo.Message, compilerServer);
        var buffer = this.getSourceContent();
        buffer.position(1);
        var len = buffer.getInt();
        var tmp = new byte[len];
        buffer.get(tmp);
        this.message = new String(tmp);
    }

    public MessagePacket(CompilerServer compilerServer, String message) {
        super(ProtocolInfo.Message, compilerServer);
        this.message = message;
        var tmp = message.getBytes(StandardCharsets.UTF_8);
        var buffer = ByteBuffer.allocate(1 + 4 + tmp.length);
        buffer.put(ProtocolInfo.Message.identity);
        buffer.putInt(tmp.length);
        buffer.put(tmp);
    }

    @Override
    public void exec() {
        System.out.println("Remote message: " + this.message);
    }
}
