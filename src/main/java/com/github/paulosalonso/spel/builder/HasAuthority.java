package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.BuiltInMethod;
import com.github.paulosalonso.spel.builder.common.Parameter;

import java.util.List;

import static com.github.paulosalonso.spel.builder.common.StringParameter.stringParameter;
import static java.util.Collections.singletonList;

public abstract class HasAuthority extends BuiltInMethod {

    private HasAuthority() {}

    public static HasAuthority hasAuthority(Enum authority) {
        return hasAuthority(authority.name());
    }

    public static HasAuthority hasAuthority(String authority) {
        return new HasAuthority() {
            @Override
            public List<Parameter> getParameters() {
                return singletonList(stringParameter(authority));
            }

            @Override
            public String getName() {
                return "hasAuthority";
            }
        };
    }
}
