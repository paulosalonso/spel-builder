package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.Instance;

public abstract class Bean extends Instance {

    public static Bean bean(String beanName) {
        return new Bean() {
            @Override
            protected String getName() {
                return beanName;
            }
        };
    }

    @Override
    protected String getPrefix() {
        return "@";
    }
}
