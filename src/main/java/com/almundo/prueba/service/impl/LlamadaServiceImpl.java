package com.almundo.prueba.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.service.LlamadaService;
import com.almundo.prueba.threads.Dispatcher;

@Service
public class LlamadaServiceImpl implements LlamadaService {

	@Autowired static EmpleadoRepository empleadoRepository;
	
	private static final int numeroEmpleados = empleadoRepository.consultarNumeroEmpleados();;
	
	@Override
	public void responderLlamada(Long numeroLlamada) {
		ExecutorService executor = Executors.newFixedThreadPool(numeroEmpleados);
		Runnable empleado = new Dispatcher(numeroLlamada);
		executor.execute(empleado);
	}

}
