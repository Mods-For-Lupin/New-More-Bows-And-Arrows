package com.cursee.more_bows_and_arrows.api.common.arrow;

public interface IArrowPart {

  class ArrowPartType {

    public static final ArrowPartType FLETCHING = new ArrowPartType("fletching");
    public static final ArrowPartType MODIFIER = new ArrowPartType("modifier");
    public static final ArrowPartType POINT = new ArrowPartType("point");
    public static final ArrowPartType SHAFT = new ArrowPartType("shaft");

    public static final ArrowPartType[] BASE_TYPES = {FLETCHING, POINT, SHAFT};

    private final String name;

    public ArrowPartType(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return getName();
    }
  }
}
