package me.minelang.compiler.lang;

import com.oracle.truffle.api.TruffleLanguage;

public final class MineContext {
    TruffleLanguage.Env env;
    public MineContext(TruffleLanguage.Env env) {
        this.env = env;
    }
}
