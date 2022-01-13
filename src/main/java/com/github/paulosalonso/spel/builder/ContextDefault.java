package com.github.paulosalonso.spel.builder;

import com.github.paulosalonso.spel.builder.common.Default;

public abstract class ContextDefault<T extends ContextDefault> extends Default<T> {

  public static ContextDefault contextDefault() {
    return new ContextDefault() {

      @Override
      protected String getName() {
        return "";
      }

      @Override
      protected String getPrefix() {
        return "";
      }
    };
  }
}
