package com.github.paulosalonso.spel.builder.common;

public abstract class Ternary extends Expression{

  private Ternary(){

  }

  public static Ternary tern(Expression on, Expression left, Expression right) {
    return new Ternary() {
      @Override
      protected String getPrefix() {
        return on.build()+"?";
      }

      @Override
      protected String getSuffix() {
        return right.build();
      }

      @Override
      protected String getName() {
        return left.build()+":";
      }
    };
  }
}
