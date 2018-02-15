package com.almundo.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almundo.prueba.service.Dispatcher;
import com.almundo.prueba.util.ConstantesUtil;

@RestController
@RequestMapping(ConstantesUtil.URL_API)
public class LlamadasController {
	
	@Autowired Dispatcher llamadaService;	

	@RequestMapping(value = ConstantesUtil.RESPONDER_LLAMADAS, method = RequestMethod.GET)
	public void responderLlamada(@RequestParam(value = "numeroLlamada", required = true) Long numeroLlamada){
		llamadaService.dispatchCall(numeroLlamada);
	}
}
