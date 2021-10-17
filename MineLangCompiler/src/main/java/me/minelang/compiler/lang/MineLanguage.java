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

    /**
     * 用于转储错误
     * @param error 错误信息
     */
    public void err(String error) {
        // TODO: 2021/10/17 完善转储错误信息机制
        System.out.println(error);
    }
}
