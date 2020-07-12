package com.github.paulosalonso.spel.builder.common;

import java.util.List;

public abstract class InstanceMethod extends Method {

    private InstanceMethod() {}

    public static InstanceMethod instanceMethod(Instance instance, String methodName, Parameter... parameters) {
        return new InstanceMethod() {
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
}
