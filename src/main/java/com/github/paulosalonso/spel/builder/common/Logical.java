package com.github.paulosalonso.spel.builder.common;

public abstract class Logical extends Expression {

    public Group group() {
        return Group.group(this);
    }
}
