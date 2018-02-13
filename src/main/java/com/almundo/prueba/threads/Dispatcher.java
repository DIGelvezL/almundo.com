package com.almundo.prueba.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.almundo.prueba.dto.LlamadaThreadDto;
import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;


public class Dispatcher implements Runnable {

	@Autowired EmpleadoRepository empleadoRepository;
	@Autowired LlamadaRepository llamadaRepository;
	
	private Long numeroLlamada;
	
	public Dispatcher(Long numeroLlamada, EmpleadoRepository empleadoRepository, LlamadaRepository llamadaRepository){
		this.numeroLlamada = numeroLlamada;
		this.empleadoRepository = empleadoRepository;
		this.llamadaRepository = llamadaRepository;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("prueba de hilos: " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dispatchCall();
	}
	
	private void dispatchCall() {
		
		BlockingQueue<LlamadaThreadDto> blockingQueue = new ArrayBlockingQueue<>(1);
		
		ExecutorService producer = Executors.newFixedThreadPool(1);
		ExecutorService consumer = Executors.newFixedThreadPool(1);
		producer.submit(new ProducerLlamada(blockingQueue, empleadoRepository, llamadaRepository));
		consumer.submit(new ConsumerLlamada(blockingQueue));
		producer.shutdown();
		consumer.shutdown();
		
		
	}

	public Long getNumeroLlamada() {
		return numeroLlamada;
	}

	public void setNumeroLlamada(Long numeroLlamada) {
		this.numeroLlamada = numeroLlamada;
	}

}
