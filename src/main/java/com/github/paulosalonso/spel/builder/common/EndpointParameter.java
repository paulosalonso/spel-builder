package com.github.paulosalonso.spel.builder.common;

public abstract class EndpointParameter extends Parameter {

    private EndpointParameter() {}

    public static EndpointParameter endpointParameter(String parameterName) {
        return new EndpointParameter() {
            @Override
            public String getPrefix() {
                return "#";
            }

            @Override
            public String getSuffix() {
                return "";
            }

            @Override
            public String getName() {
                return parameterName;
            }
        };
    }
}
