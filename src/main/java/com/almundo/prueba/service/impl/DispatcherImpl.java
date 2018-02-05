package com.almundo.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;
import com.almundo.prueba.service.Dispatcher;

@Service
public class DispatcherImpl implements Dispatcher {

	@Autowired EmpleadoRepository empleadoRepository;
	@Autowired LlamadaRepository llamadaRepository;
	
	@Override
	public void dispatchCall() {

	}

}
