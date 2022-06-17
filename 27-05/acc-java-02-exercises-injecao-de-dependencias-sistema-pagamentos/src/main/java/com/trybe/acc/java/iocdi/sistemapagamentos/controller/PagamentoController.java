package com.trybe.acc.java.iocdi.sistemapagamentos.controller;

import com.trybe.acc.java.iocdi.sistemapagamentos.model.Payment;
import com.trybe.acc.java.iocdi.sistemapagamentos.service.PagamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {

  @Autowired
  PagamentoService pagamentoService;

  @PostMapping
  public Payment criarPagamento(@RequestBody Payment pagamento) {
    return pagamentoService.criarPagamento(pagamento);
  }

}
