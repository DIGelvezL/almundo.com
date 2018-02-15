package com.almundo.prueba.dto;

import java.io.Serializable;

import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;

public class LlamadaThreadDto implements Serializable {

	private static final long serialVersionUID = 3449134201320787887L;
	
	private Long numeroLlamada;
	private transient EmpleadoRepository empleadoRepository;
	private transient LlamadaRepository llamadaRepository;
	
	public LlamadaThreadDto(Long numeroLlamada, EmpleadoRepository empleadoRepository, LlamadaRepository llamadaRepository){
		this.numeroLlamada = numeroLlamada;
		this.empleadoRepository = empleadoRepository;
		this.llamadaRepository = llamadaRepository;
	}
	
	public Long getNumeroLlamada() {
		return numeroLlamada;
	}
	public void setNumeroLlamada(Long numeroLlamada) {
		this.numeroLlamada = numeroLlamada;
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
