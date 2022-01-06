package com.github.paulosalonso.spel.builder.common;

public abstract class MapParameter extends Parameter {

  private MapParameter() {

  }

  public static MapParameter mapParameter(String path) {
    String[] segments = path.split("[.]");
    return new MapParameter() {
      @Override
      protected String getPrefix() {

        return "#" + segments[0] + ".get(";
      }

      @Override
      protected String getSuffix() {
        return ")";
      }

      @Override
      protected String getName() {
        return StringParameter.stringParameter(segments[1]).build();
      }
    };
  }
}
