package com.github.paulosalonso.spel.builder.common;

public abstract class Group extends Expression {

    private Group() {}

    public static Group group(Expression expression) {
        return new Group() {
            @Override
            protected String getPrefix() {
                return "(";
            }

            @Override
            protected String getSuffix() {
                return ")";
            }

            @Override
            protected String getName() {
                return expression.build();
            }
        };
    }

}
