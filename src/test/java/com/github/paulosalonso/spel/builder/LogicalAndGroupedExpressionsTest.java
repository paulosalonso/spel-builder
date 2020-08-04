package com.github.paulosalonso.spel.builder;

import org.junit.Assert;
import org.junit.Test;

import static com.github.paulosalonso.spel.builder.Bean.bean;
import static com.github.paulosalonso.spel.builder.ContextVariable.contextVariable;
import static com.github.paulosalonso.spel.builder.IsAuthenticated.isAuthenticated;
import static org.junit.Assert.assertEquals;

public class LogicalAndGroupedExpressionsTest {

    @Test
    public void testAndBuilder() {
        String spel = bean("someBeanName").method("someMethod")
                .and(contextVariable("someContextVariableName").method("someMethod"))
                .build();

        assertEquals("@someBeanName.someMethod() && #someContextVariableName.someMethod()", spel);
    }

    @Test
    public void testOrBuilder() {
        String spel = bean("someBeanName").method("someMethod")
                .or(contextVariable("someContextVariableName").method("someMethod"))
                .build();

        assertEquals("@someBeanName.someMethod() || #someContextVariableName.someMethod()", spel);
    }

    @Test
    public void testGroupedExpressionBuilder() {
        String spel = isAuthenticated().group().build();

        assertEquals("(isAuthenticated())", spel);
    }

    @Test
    public void testGroupedLogicalBuilder() {
        String spel = bean("someBeanName").method("someMethod")
                .and(bean("someBeanName").method("someOtherMethod")
                        .or(contextVariable("someContextVariableName").method("someMethod"))
                        .group())
                .build();

        String expectedSpel = "@someBeanName.someMethod() && (@someBeanName.someOtherMethod() || #someContextVariableName.someMethod())";

        assertEquals(expectedSpel, spel);
    }

}
