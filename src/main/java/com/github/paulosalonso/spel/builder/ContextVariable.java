package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.Instance;

public abstract class ContextVariable extends Instance {

    public static ContextVariable contextVariable(String variableName) {
        return new ContextVariable() {
            @Override
            protected String getName() {
                return variableName;
            }
        };
    }

    @Override
    protected String getPrefix() {
        return "#";
    }
}
