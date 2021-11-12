package me.minelang.intepreterServer;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;

public class CompilerServer extends WebSocketServer {
    public static void main(String[] args) {
        var compilerServer = create(args);
        compilerServer.run();
    }

    public static final int DEFAULT_SOCKET_PORT = 42133;

    private String[] compilerArgs;
    private String rootPath;
    private WebSocket connection = null;

    private Engine.Builder engineBuilder = null;
    private Context.Builder contextBuilder = null;
    private Engine execEngine = null;
    private Context execContext = null;

    private CompilerServer(int port) {
        super(InetSocketAddress.createUnresolved("localhost", port));
    }

    public static CompilerServer create(String[] compilerArgs) {
        var port = DEFAULT_SOCKET_PORT;
        var rootPath = new File("./").getAbsolutePath();
        var engineBuilder = Engine.newBuilder();
        var contextBuilder = Context.newBuilder("MineLang");
        for (var arg : compilerArgs) {
            if (arg.startsWith("-wsPort=")) {
                port = Integer.parseInt(arg.substring(8));
            } else if (arg.startsWith("-rootPath=")) {
                rootPath = arg.substring(10);
            }
        }
        return new CompilerServer(port).setRootPath(rootPath)
                .setEngineBuilder(engineBuilder)
                .setContextBuilder(contextBuilder);
    }

    /**
     * 刷新运行环境，将在全新的上下文中运行代码
     */
    public void refreshEnv() {
        if (this.execEngine == null) {
            this.execEngine = this.engineBuilder.build();
        }
        this.execContext = this.contextBuilder.engine(this.execEngine).build();
    }

    public void execFile(String filePath) {
        try {
            var code = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            // TODO: 2021/11/12 发送错误包
            e.printStackTrace();
        }
    }


    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        if (this.connection == null) {
            conn.close(403, "This server has already been occupied!");
        } else {
            this.connection = conn;
        }
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        assert conn == this.connection;
        this.connection = null;
        System.out.println("Connection closed with status code " + code + " because " + reason);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {

    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message) {

    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

    @Override
    public void onStart() {
        System.out.println("Server started.");
    }

    public String[] getCompilerArgs() {
        return compilerArgs;
    }

    public CompilerServer setCompilerArgs(String[] compilerArgs) {
        this.compilerArgs = compilerArgs;
        return this;
    }

    public String getRootPath() {
        return rootPath;
    }

    public CompilerServer setRootPath(String rootPath) {
        this.rootPath = rootPath;
        return this;
    }

    public WebSocket getConnection() {
        return connection;
    }

    public CompilerServer setConnection(WebSocket connection) {
        this.connection = connection;
        return this;
    }

    public Engine.Builder getEngineBuilder() {
        return engineBuilder;
    }

    public CompilerServer setEngineBuilder(Engine.Builder engineBuilder) {
        this.engineBuilder = engineBuilder;
        return this;
    }

    public Context.Builder getContextBuilder() {
        return contextBuilder;
    }

    public CompilerServer setContextBuilder(Context.Builder contextBuilder) {
        this.contextBuilder = contextBuilder;
        return this;
    }

    public Engine getExecEngine() {
        return execEngine;
    }

    public CompilerServer setExecEngine(Engine execEngine) {
        this.execEngine = execEngine;
        return this;
    }

    public Context getExecContext() {
        return execContext;
    }

    public CompilerServer setExecContext(Context execContext) {
        this.execContext = execContext;
        return this;
    }
}
