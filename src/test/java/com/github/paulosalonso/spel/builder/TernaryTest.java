package com.github.paulosalonso.spel.builder;

import static com.github.paulosalonso.spel.builder.ContextVariable.contextVariable;

import com.github.paulosalonso.spel.builder.common.EndpointParameter;
import org.junit.Test;

public class TernaryTest {

  @Test
  public void test() {

    String spEL = contextVariable("var1").method("method1", EndpointParameter.endpointParameter("param1"))
        .tern(contextVariable("var2").method("method2", EndpointParameter.endpointParameter("param2"))
            .tern(contextVariable("var4").method("method4", EndpointParameter.endpointParameter("param4")),
                contextVariable("var5").method("method5", EndpointParameter.endpointParameter("param5")))
            .group(), contextVariable("var3").method("method3", EndpointParameter.endpointParameter("param3")))
        .build();

    System.out.println(spEL);
  }
}
