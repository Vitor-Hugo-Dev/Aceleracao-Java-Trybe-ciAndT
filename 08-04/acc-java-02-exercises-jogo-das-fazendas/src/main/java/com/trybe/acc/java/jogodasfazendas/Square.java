package com.trybe.acc.java.jogodasfazendas;

public class Square implements Farm {
  protected double side;

  public Square(double side) {
    this.side = side;
  }

  @Override
  public double area() {
    double squareArea = Math.pow(this.side, 2);
    return squareArea;
  }

}
