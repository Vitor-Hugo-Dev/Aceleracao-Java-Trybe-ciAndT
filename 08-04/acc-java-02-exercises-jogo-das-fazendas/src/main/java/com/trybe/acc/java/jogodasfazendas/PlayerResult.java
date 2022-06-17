package com.trybe.acc.java.jogodasfazendas;

public class PlayerResult {
  protected String playerName;
  protected Farm[] farms;

  public PlayerResult(String name, Farm[] farms) {
    this.playerName = name;
    this.farms = farms;
  }

  protected double score() {
    double areaTotal = 0;
    for (Farm farm : farms) {
      areaTotal += farm.area();
    }
    return areaTotal;
  }



}
