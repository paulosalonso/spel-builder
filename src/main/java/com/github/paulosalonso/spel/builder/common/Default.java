package com.github.paulosalonso.spel.builder.common;

import static com.github.paulosalonso.spel.builder.common.DefaultMethod.staticMethod;

public abstract class Default<T extends Default> extends Expression {

  private String methodChain = "";
  protected ChainState chainState = ChainState.STARTING;

  public DefaultMethod<T> method(String methodName, Parameter... parameters) {
    DefaultMethod<T> method = staticMethod(this, methodName, parameters);
    methodChain = method.build();
    chainState = ChainState.IDLE;
    return method;
  }

  @Override
  protected String getPrefix() {
    return String.format("%s%s", methodChain, chainState.operator);
  }

  @Override
  protected String getSuffix() {
    return "";
  }

  @Override
  public String build() {
    if(Instance.ChainState.IDLE.equals(chainState)) {
      String buildResult = methodChain;
      methodChain = "";
      chainState = ChainState.STARTING;
      return buildResult;
    } else if (Instance.ChainState.WAITING_CHAIN.equals(chainState)) {
      return methodChain;
    }

    return super.build();
  }

  protected T and() {
    chainState = ChainState.WAITING_AND;
    return (T) this;
  }

  protected T or() {
    chainState = ChainState.WAITING_OR;
    return (T) this;
  }

  protected T chain() {
    chainState = ChainState.WAITING_CHAIN;
    return (T) this;
  }

  public enum ChainState {
    STARTING(""),
    IDLE(""),
    WAITING_CHAIN("."),
    WAITING_AND(" && "),
    WAITING_OR(" || ");

    private final String operator;

    ChainState(String operator) {
      this.operator = operator;
    }
  }
}
