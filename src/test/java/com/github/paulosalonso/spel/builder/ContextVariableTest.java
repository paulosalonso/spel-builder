package com.github.paulosalonso.spel.builder;

import org.junit.Test;

import static com.github.paulosalonso.spel.builder.AnyEnum.ENUM_CONSTANT_A;
import static com.github.paulosalonso.spel.builder.AnyEnum.ENUM_CONSTANT_B;
import static com.github.paulosalonso.spel.builder.ContextVariable.contextVariable;
import static com.github.paulosalonso.spel.builder.common.EndpointParameter.endpointParameter;
import static com.github.paulosalonso.spel.builder.common.StringParameter.stringParameter;
import static org.junit.Assert.assertEquals;

public class ContextVariableTest {

    @Test
    public void testContextVariableBuild() {
        String spel = contextVariable("someContextVariableName").build();
        assertEquals("#someContextVariableName", spel);
    }

    @Test
    public void testMethodCallFromContextVariableWithoutParametersBuild() {
        String spel = contextVariable("someContextVariableName").method("someInstanceMethod")
                .build();

        assertEquals("#someContextVariableName.someInstanceMethod()", spel);
    }

    @Test
    public void testMethodCallFromContextVariableWithOneEndpointParameterBuild() {
        String spel = contextVariable("someContextVariableName").method(
                "someInstanceMethod", endpointParameter("parameter")).build();

        assertEquals("#someContextVariableName.someInstanceMethod(#parameter)", spel);
    }

    @Test
    public void testMethodCallFromContextVariableWithMoreThanOneEndpointParameterBuild() {
        String spel = contextVariable("someContextVariableName").method("someInstanceMethod",
                endpointParameter("parameterA"), endpointParameter("parameterB")).build();

        assertEquals("#someContextVariableName.someInstanceMethod(#parameterA, #parameterB)", spel);
    }

    @Test
    public void testMethodCallFromContextVariableWithOneStringParameterBuild() {
        String spel = contextVariable("someContextVariableName").method(
                "someInstanceMethod", stringParameter("parameter")).build();

        assertEquals("#someContextVariableName.someInstanceMethod('parameter')", spel);
    }

    @Test
    public void testMethodCallFromContextVariableWithMoreThanOneStringParameterBuild() {
        String spel = contextVariable("someContextVariableName").method("someInstanceMethod",
                stringParameter("parameterA"), stringParameter("parameterB")).build();

        assertEquals("#someContextVariableName.someInstanceMethod('parameterA', 'parameterB')", spel);
    }

    @Test
    public void testMethodCallFromContextVariableWithOneEnumBasedStringParameterBuild() {
        String spel = contextVariable("someContextVariableName").method(
                "someInstanceMethod", stringParameter(ENUM_CONSTANT_A)).build();

        assertEquals("#someContextVariableName.someInstanceMethod('ENUM_CONSTANT_A')", spel);
    }

    @Test
    public void testMethodCallFromContextVariableWithMoreThanOneEnumBasedStringParameterBuild() {
        String spel = contextVariable("someContextVariableName").method("someInstanceMethod",
                stringParameter(ENUM_CONSTANT_A), stringParameter(ENUM_CONSTANT_B)).build();

        assertEquals("#someContextVariableName.someInstanceMethod('ENUM_CONSTANT_A', 'ENUM_CONSTANT_B')", spel);
    }

}
