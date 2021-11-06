package me.minelang.compiler.lang.runtime.initers;

import com.oracle.truffle.api.frame.FrameSlot;
import me.minelang.compiler.lang.MineContext;
import me.minelang.compiler.lang.MineLanguage;
import me.minelang.compiler.lang.types.MineFunction;
import me.minelang.compiler.parser.LexicalScope;

import java.util.*;

public abstract class AbstractIniter<T> {
    protected List<Function> builtInFunctions = new ArrayList<>();
    protected Map<String, T> declares = new LinkedHashMap<>();
    protected Map<String, FrameSlot> frameSlots = new HashMap<>();
    protected final LexicalScope globalScope;
    protected final MineLanguage language;
    private boolean declaredOnce = false;
    private boolean implementOnce = false;

    public AbstractIniter(LexicalScope globalScope, MineLanguage language) {
        this.globalScope = globalScope;
        this.language = language;
    }

    protected abstract void initDeclare();

    protected abstract Function processDeclare(String name, T t);

    protected void initImplement() {
        declares.forEach((k, v) -> {
            var processed = this.processDeclare(k, v);
            this.addFunction(processed.name(), processed.function());
        });
    }

    public void declare() {
        if (!declaredOnce) {
            declaredOnce = true;
            initDeclare();
        }
        declares.forEach((k, v) -> frameSlots.put(k, globalScope.declare(k)));
    }

    public void implement(MineContext context) {
        if (!implementOnce) {
            implementOnce = true;
            initImplement();
        }
        var global = context.getRootFrame();
        builtInFunctions.forEach(e -> global.setObject(frameSlots.get(e.name()), e.function()));
    }

    protected void addDeclare(String name, T t) {
        declares.put(name, t);
    }

    protected void addFunction(String name, MineFunction function) {
        builtInFunctions.add(new Function(name, function));
    }

    record Function(String name, MineFunction function) {

    }
}
