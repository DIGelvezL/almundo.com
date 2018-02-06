package com.almundo.prueba.dto;

import java.io.Serializable;

import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;

public class LlamadaThreadDto implements Serializable {

	private static final long serialVersionUID = 3449134201320787887L;
	
	private EmpleadoRepository empleadoRepository;
	private LlamadaRepository llamadaRepository;
	
	public LlamadaThreadDto(EmpleadoRepository empleadoRepository, LlamadaRepository llamadaRepository){
		this.empleadoRepository = empleadoRepository;
		this.llamadaRepository = llamadaRepository;
	}
	
	public EmpleadoRepository getEmpleadoRepository() {
		return empleadoRepository;
	}
	public void setEmpleadoRepository(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	public LlamadaRepository getLlamadaRepository() {
		return llamadaRepository;
	}
	public void setLlamadaRepository(LlamadaRepository llamadaRepository) {
		this.llamadaRepository = llamadaRepository;
	}

}
