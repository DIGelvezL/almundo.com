package com.almundo.prueba.threads;

import org.springframework.beans.factory.annotation.Autowired;

import com.almundo.prueba.entities.Empleado;
import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;


public class LlamadaThread implements Runnable {

	@Autowired EmpleadoRepository empleadoRepository;
	@Autowired LlamadaRepository llamadaRepository;
	
	private Long numeroLlamada;
	private Empleado empleado;
	private int duracionLlamada;
	
	public LlamadaThread(Long numeroLlamada, EmpleadoRepository empleadoRepository, LlamadaRepository llamadaRepository, Empleado empleado, int duracionLlamada){
		this.numeroLlamada = numeroLlamada;
		this.empleadoRepository = empleadoRepository;
		this.llamadaRepository = llamadaRepository;
		this.empleado = empleado;
		this.duracionLlamada = duracionLlamada;
	}

	@Override
	public void run() {
		System.out.println("Llamada numero: " + numeroLlamada + " en el hilo " + Thread.currentThread().getName() + " con el empleado " + empleado.getNombres());
		esperarXsegundos();
		finalizaLlamada();
		System.out.println("---- Fin llamada numero: " + numeroLlamada + " en el hilo " + Thread.currentThread().getName() + " con el empleado " + empleado.getNombres());
	}
	
	private void esperarXsegundos() {
		try {
			Thread.sleep(duracionLlamada * 1000);
		} catch (InterruptedException ex) {
			finalizaLlamada();
			Thread.currentThread().interrupt();
		}
	}
	
	private void finalizaLlamada(){
		empleado.setDisponible(true);
		empleadoRepository.save(empleado);
	}

	public Long getNumeroLlamada() {
		return numeroLlamada;
	}

	public void setNumeroLlamada(Long numeroLlamada) {
		this.numeroLlamada = numeroLlamada;
	}

}
