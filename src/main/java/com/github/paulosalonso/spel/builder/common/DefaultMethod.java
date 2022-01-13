package com.github.paulosalonso.spel.builder.common;

import com.github.paulosalonso.spel.builder.common.Instance.ChainState;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DefaultMethod<T extends Default> extends Method {

  protected T clazz;

  private DefaultMethod(T clazz) {
    this.clazz = clazz;
  }

  public static DefaultMethod staticMethod(Default clazz,String methodName, Parameter... parameters) {
    return new DefaultMethod(clazz) {
      @Override
      public List<Parameter> getParameters() {
        return Arrays.stream(parameters).collect(Collectors.toList());
      }

      @Override
      public String getPrefix() {
        return "";
      }

      @Override
      public String getName() {
        return methodName;
      }
    };
  }

  public T and() {
    return (T) clazz.and();
  }

  public T or() {
    return (T) clazz.or();
  }

  public T chain() {
    return (T) clazz.chain();
  }

  @Override
  public String build() {
    if (ChainState.IDLE.equals(clazz.chainState)) {
      return clazz.build();
    }

    return super.build();
  }
}
