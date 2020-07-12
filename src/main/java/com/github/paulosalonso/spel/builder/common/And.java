package com.github.paulosalonso.spel.builder.common;

public abstract class And extends Logical {

    private And() {}

    public static And and(Expression expressionA, Expression expressionB) {
        return new And() {
            @Override
            protected String getPrefix() {
                return expressionA.build();
            }

            @Override
            protected String getSuffix() {
                return expressionB.build();
            }

            @Override
            protected String getName() {
                return " && ";
            }
        };
    }
}
