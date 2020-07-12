package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.BuiltInMethod;
import com.github.paulosalonso.spel.builder.common.Parameter;

import java.util.List;

import static com.github.paulosalonso.spel.builder.common.StringParameter.stringParameter;
import static java.util.Collections.singletonList;

public abstract class HasScope extends BuiltInMethod {

    private HasScope() {}

    public static HasScope hasScope(Enum scope) {
        return hasScope(scope.name());
    }

    public static HasScope hasScope(String scope) {
        return new HasScope() {
            @Override
            public List<Parameter> getParameters() {
                return singletonList(stringParameter(scope));
            }

            @Override
            public String getName() {
                return "hasScope";
            }
        };
    }
}
