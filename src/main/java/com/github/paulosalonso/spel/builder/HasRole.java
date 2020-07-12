package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.BuiltInMethod;
import com.github.paulosalonso.spel.builder.common.Parameter;

import java.util.List;

import static com.github.paulosalonso.spel.builder.common.StringParameter.stringParameter;
import static java.util.Collections.singletonList;

public abstract class HasRole extends BuiltInMethod {

    private HasRole() {}

    public static HasRole hasRole(Enum role) {
        return hasRole(role.name());
    }

    public static HasRole hasRole(String role) {
        return new HasRole() {
            @Override
            public List<Parameter> getParameters() {
                return singletonList(stringParameter(role));
            }

            @Override
            public String getName() {
                return "hasRole";
            }
        };
    }
}
