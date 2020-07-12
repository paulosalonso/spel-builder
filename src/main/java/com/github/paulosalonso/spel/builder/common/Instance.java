package com.github.paulosalonso.spel.builder.common;

import static com.github.paulosalonso.spel.builder.common.InstanceMethod.instanceMethod;

public abstract class Instance extends Expression {

    public Method method(String methodName, Parameter... parameters) {
        return instanceMethod(this, methodName, parameters);
    }

    @Override
    protected String getSuffix() {
        return "";
    }
}
