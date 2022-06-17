package com.betrybe.acc.java.bankaccount;

import org.apache.commons.lang3.StringUtils;

/**
 * AccountNumberFormatter.
 */
public class AccountNumberFormatter {

  /**
   * Formata o número da conta.
   *
   * @param literalAccountNumber número da conta
   */
  public String formatAccountNumber(int literalAccountNumber) {
    String numero = Integer.toString(literalAccountNumber);

    if (numero.length() < 6) {
      numero = StringUtils.leftPad(numero, 6, "0");
    } else if (numero.length() > 6) {
      numero = StringUtils.right(numero, 6);
    }

    return numero;
  }

}