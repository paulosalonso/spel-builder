package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.Instance;

public abstract class ContextVariable<T extends ContextVariable> extends Instance<T> {

    public static ContextVariable contextVariable(String variableName) {
        return new ContextVariable() {
            @Override
            protected String getName() {
                return String.format("#%s", variableName);
            }
        };
    }
}
