package me.minelang.compiler.lang.types;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.object.Shape;

//@ExportLibrary(InteropLibrary.class)
public abstract class MineDynamicObject extends DynamicObject implements TruffleObject{
    protected MineDynamicObject(@Cached Shape shape){
        super(shape);
    }


}
