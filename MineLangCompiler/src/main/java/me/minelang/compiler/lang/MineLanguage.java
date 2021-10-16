package me.minelang.compiler.lang;

import com.oracle.truffle.api.TruffleLanguage;
import me.minelang.compiler.lang.types.MineLanguageView;

@TruffleLanguage.Registration(id = "MineLang", name = "MineLang")
public final class MineLanguage extends TruffleLanguage<MineContext> {
    @Override
    protected MineContext createContext(Env env) {
        return new MineContext(env);
    }

    @Override
    protected Object getLanguageView(MineContext context, Object value) {
        return MineLanguageView.create(value);
    }
}
