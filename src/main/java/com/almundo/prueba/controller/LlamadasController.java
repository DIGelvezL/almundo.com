package com.almundo.prueba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.almundo.prueba.util.ConstantesUtil;

@RestController
@RequestMapping(ConstantesUtil.URL_API)
public class LlamadasController {

	@RequestMapping(value = ConstantesUtil.RESPONDER_LLAMADAS, method = RequestMethod.GET)
	public void responderLlamada(){

	}
}
