package com.github.paulosalonso.spel.builder;

import org.junit.Test;

import static com.github.paulosalonso.spel.builder.AnyEnum.ENUM_CONSTANT_A;
import static com.github.paulosalonso.spel.builder.AnyEnum.ENUM_CONSTANT_B;
import static com.github.paulosalonso.spel.builder.Bean.bean;
import static com.github.paulosalonso.spel.builder.common.EndpointParameter.endpointParameter;
import static com.github.paulosalonso.spel.builder.common.StringParameter.stringParameter;
import static org.junit.Assert.assertEquals;

public class BeanTest {

    @Test
    public void testBeanBuild() {
        String spel = bean("someBeanName").build();
        assertEquals("@someBeanName", spel);
    }

    @Test
    public void testMethodCallFromBeanWithoutParametersBuild() {
        String spel = bean("someBeanName").method("someInstanceMethod").build();
        assertEquals("@someBeanName.someInstanceMethod()", spel);
    }

    @Test
    public void testMethodCallFromBeanWithOneEndpointParameterBuild() {
        String spel = bean("someBeanName").method(
                "someInstanceMethod", endpointParameter("parameter")).build();

        assertEquals("@someBeanName.someInstanceMethod(#parameter)", spel);
    }

    @Test
    public void testMethodCallFromBeanWithMoreThanOneEndpointParameterBuild() {
        String spel = bean("someBeanName").method("someInstanceMethod",
                endpointParameter("parameterA"), endpointParameter("parameterB")).build();

        assertEquals("@someBeanName.someInstanceMethod(#parameterA, #parameterB)", spel);
    }

    @Test
    public void testMethodCallFromBeanWithOneStringParameterBuild() {
        String spel = bean("someBeanName").method(
                "someInstanceMethod", stringParameter("parameter")).build();

        assertEquals("@someBeanName.someInstanceMethod('parameter')", spel);
    }

    @Test
    public void testMethodCallFromBeanWithMoreThanOneStringParameterBuild() {
        String spel = bean("someBeanName").method("someInstanceMethod",
                stringParameter("parameterA"), stringParameter("parameterB")).build();

        assertEquals("@someBeanName.someInstanceMethod('parameterA', 'parameterB')", spel);
    }

    @Test
    public void testMethodCallFromBeanWithOneEnumBasedStringParameterBuild() {
        String spel = bean("someBeanName").method(
                "someInstanceMethod", stringParameter(ENUM_CONSTANT_A)).build();

        assertEquals("@someBeanName.someInstanceMethod('ENUM_CONSTANT_A')", spel);
    }

    @Test
    public void testMethodCallFromBeanWithMoreThanOneEnumBasedStringParameterBuild() {
        String spel = bean("someBeanName").method("someInstanceMethod",
                stringParameter(ENUM_CONSTANT_A), stringParameter(ENUM_CONSTANT_B)).build();

        assertEquals("@someBeanName.someInstanceMethod('ENUM_CONSTANT_A', 'ENUM_CONSTANT_B')", spel);
    }

}
