package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.Instance;

public abstract class Bean<T extends Bean> extends Instance<T> {

    public static Bean bean(String beanName) {
        return new Bean() {
            @Override
            protected String getName() {
                return String.format("@%s", beanName);
            }
        };
    }
}
