package com.almundo.prueba.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;
import com.almundo.prueba.service.LlamadaService;
import com.almundo.prueba.threads.Dispatcher;

@Service
public class LlamadaServiceImpl implements LlamadaService {

	@Autowired EmpleadoRepository empleadoRepository;
	@Autowired LlamadaRepository llamadaRepository;
	
//	private static final int numeroEmpleados = empleadoRepository.consultarNumeroEmpleados();
	
	@Override
	public void responderLlamada(Long numeroLlamada) {
		int numeroEmpleados = empleadoRepository.consultarNumeroEmpleados();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Runnable empleado = new Dispatcher(numeroLlamada, empleadoRepository, llamadaRepository);
		executor.execute(empleado);
	}

}
