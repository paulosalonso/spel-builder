package com.github.paulosalonso.spel.builder.common;

public abstract class Or extends Logical {

    private Or() {}

    public static Or or(Expression expressionA, Expression expressionB) {
        return new Or() {
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
                return " || ";
            }
        };
    }
}
