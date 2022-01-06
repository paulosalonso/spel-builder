package com.github.paulosalonso.spel.builder;

import static com.github.paulosalonso.spel.builder.ContextDefault.contextDefault;
import static com.github.paulosalonso.spel.builder.ContextVariable.contextVariable;

import com.github.paulosalonso.spel.builder.common.MapParameter;
import org.junit.Test;

public class MapParameterTest {

  @Test
  public void test(){

    String spEL = contextVariable("a").method("method1", MapParameter.mapParameter("raw.param1")).build();

    System.out.println(spEL);
  }
}
