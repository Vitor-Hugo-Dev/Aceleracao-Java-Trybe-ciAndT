package com.trybe.acc.java.jogodasfazendas;

public class Circle implements Farm {

  protected static final double PI = 3.14;
  protected double radios;

  public Circle(double radios) {
    this.radios = radios;
  }

  @Override
  public double area() {
    double circleArea = PI * Math.pow(this.radios, 2);
    return circleArea;
  }

}
