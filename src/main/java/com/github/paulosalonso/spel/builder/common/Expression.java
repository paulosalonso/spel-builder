package com.github.paulosalonso.spel.builder.common;

public abstract class Expression {

    protected abstract String getPrefix();
    protected abstract String getSuffix();
    protected abstract String getName();

    public Logical and(Expression expression) {
        return And.and(this, expression);
    }

    public Logical or(Expression expression) {
        return Or.or(this, expression);
    }

    public String build() {
        return String.format("%s%s%s", getPrefix(), getName(), getSuffix());
    }

    @Override
    public String toString() {
        return build();
    }
}
