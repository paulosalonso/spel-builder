package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.BuiltInMethod;
import com.github.paulosalonso.spel.builder.common.Parameter;

import java.util.List;

import static java.util.Collections.emptyList;

public abstract class IsAuthenticated extends BuiltInMethod {

    private IsAuthenticated() {}

    public static IsAuthenticated isAuthenticated() {
        return new IsAuthenticated() {
            @Override
            public List<Parameter> getParameters() {
                return emptyList();
            }

            @Override
            public String getName() {
                return "isAuthenticated";
            }
        };
    }
}
