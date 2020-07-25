package com.github.paulosalonso.spel.builder.common;

import static com.github.paulosalonso.spel.builder.common.InstanceMethod.instanceMethod;

public abstract class Instance<T extends Instance> extends Expression {
    private String methodChain = "";
    protected ChainState chainState = ChainState.STARTING;

    public InstanceMethod<T> method(String methodName, Parameter... parameters) {
        InstanceMethod<T> method = instanceMethod(this, methodName, parameters);
        methodChain = method.build();
        chainState = ChainState.IDLE;
        return method;
    }

    @Override
    protected String getPrefix() {
        return String.format("%s%s", methodChain, chainState.operator);
    }

    @Override
    protected String getSuffix() {
        return "";
    }

    @Override
    public String build() {
        if(ChainState.IDLE.equals(chainState)) {
            return methodChain;
        }

        return super.build();
    }

    protected T and() {
        chainState = ChainState.WAITING_AND;
        return (T) this;
    }

    protected T or() {
        chainState = ChainState.WAITING_OR;
        return (T) this;
    }

    enum ChainState {
        STARTING(""),
        IDLE(""),
        WAITING_AND(" and "),
        WAITING_OR(" or ");

        private final String operator;

        ChainState(String operator) {
            this.operator = operator;
        }
    }
}
