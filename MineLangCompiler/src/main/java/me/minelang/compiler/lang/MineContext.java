package me.minelang.compiler.lang;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.nodes.Node;
import me.minelang.compiler.lang.types.MineNone;

public final class MineContext {
    private final MineLanguage language;
    private final TruffleLanguage.Env env;

    private final FrameDescriptor rootFrameDescriptor;
    private MaterializedFrame rootFrame = null;

    private static final ContextReference<MineContext> REFERENCE = ContextReference.create(MineLanguage.class);

    public MineContext(MineLanguage language, TruffleLanguage.Env env) {
        this.language = language;
        this.env = env;
        this.rootFrameDescriptor = new FrameDescriptor(MineNone.SINGLETON);
    }

    public MineLanguage getLanguage() {
        return language;
    }

    public TruffleLanguage.Env getEnv() {
        return env;
    }

    public FrameDescriptor getRootFrameDescriptor() {
        return rootFrameDescriptor;
    }

    public MaterializedFrame getRootFrame() {
        return rootFrame;
    }

    public void setRootFrame(MaterializedFrame rootFrame) {
        this.rootFrame = rootFrame;
    }

    public void initersImplement() {
        this.language.initers.forEach(e -> e.implement(this));
    }

    public static MineContext get(Node node) {
        return REFERENCE.get(node);
    }
}
