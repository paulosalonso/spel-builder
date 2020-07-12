package com.github.paulosalonso.spel.builder.common;

public abstract class StringParameter extends Parameter {

    private StringParameter() {}

    public static StringParameter stringParameter(String parameter) {
        return new StringParameter() {
            @Override
            public String getPrefix() {
                return "'";
            }

            @Override
            public String getSuffix() {
                return "'";
            }

            @Override
            public String getName() {
                return parameter.toString();
            }
        };
    }

    public static StringParameter stringParameter(Enum parameter) {
        return stringParameter(parameter.name());
    }
}
