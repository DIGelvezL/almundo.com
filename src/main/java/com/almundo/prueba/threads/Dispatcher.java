package com.almundo.prueba.threads;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.almundo.prueba.entities.Empleado;
import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;


public class Dispatcher implements Runnable {

	@Autowired EmpleadoRepository empleadoRepository;
	@Autowired LlamadaRepository llamadaRepository;
	
	private Long numeroLlamada;
	
	public Dispatcher(Long numeroLlamada){
		this.numeroLlamada = numeroLlamada;
	}

	@Override
	public void run() {
		dispatchCall();
	}
	
	private void dispatchCall() {
		List<Empleado> operadoresList = empleadoRepository.consultarOperadoresDisponibles();
		
		if(Objects.nonNull(operadoresList) && !operadoresList.isEmpty()){
			
		}
	}

	public Long getNumeroLlamada() {
		return numeroLlamada;
	}

	public void setNumeroLlamada(Long numeroLlamada) {
		this.numeroLlamada = numeroLlamada;
	}

}
