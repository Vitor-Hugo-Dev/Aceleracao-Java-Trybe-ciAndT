package com.trybe.acc.java.iocdi.sistemapagamentos.controller;

import com.trybe.acc.java.iocdi.sistemapagamentos.interceptor.RestritoPermissaoEscrita;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/middleware")
@RestController
public class InterceptorController {

  @RestritoPermissaoEscrita
  @GetMapping("/com-interceptor")
  public void com() {}


  @GetMapping("/sem-interceptor")
  public void sem() {}
}