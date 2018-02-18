package com.almundo.prueba.dto;

import java.io.Serializable;

import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;
import com.almundo.prueba.service.Dispatcher;

public class LlamadaThreadDto implements Serializable {

	private static final long serialVersionUID = 3449134201320787887L;
	
	private Long numeroLlamada;
	private transient EmpleadoRepository empleadoRepository;
	private transient LlamadaRepository llamadaRepository;
	private transient Dispatcher dispatcher;
	
	public LlamadaThreadDto(Long numeroLlamada, EmpleadoRepository empleadoRepository, LlamadaRepository llamadaRepository, Dispatcher dispatcher){
		this.numeroLlamada = numeroLlamada;
		this.empleadoRepository = empleadoRepository;
		this.llamadaRepository = llamadaRepository;
		this.dispatcher = dispatcher;
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
	public Dispatcher getDispatcher() {
		return dispatcher;
	}
	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	
}
