package com.github.paulosalonso.spel.builder.common;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Method extends Expression {

    protected abstract List<Parameter> getParameters();

    @Override
    protected String getSuffix() {
        return String.format("(%s)", getParameters().stream()
                .map(Parameter::build)
                .collect(Collectors.joining(", ")));
    }
}
