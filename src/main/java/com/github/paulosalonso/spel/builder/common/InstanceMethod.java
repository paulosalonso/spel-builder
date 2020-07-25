package com.github.paulosalonso.spel.builder.common;

import com.github.paulosalonso.spel.builder.common.Instance.ChainState;

import java.util.List;

public abstract class InstanceMethod<T extends Instance> extends Method {

    protected T instance;

    private InstanceMethod(T instance) {
        this.instance = instance;
    }

    public static InstanceMethod instanceMethod(Instance instance, String methodName, Parameter... parameters) {
        return new InstanceMethod(instance) {
            @Override
            public List<Parameter> getParameters() {
                return List.of(parameters);
            }

            @Override
            public String getPrefix() {
                return String.format("%s.", instance.build());
            }

            @Override
            public String getName() {
                return methodName;
            }
        };
    }

    public T and() {
        return (T) instance.and();
    }

    public T or() {
        return (T) instance.or();
    }

    @Override
    public String build() {
        if (ChainState.IDLE.equals(instance.chainState)) {
            return instance.build();
        }

        return super.build();
    }

}
