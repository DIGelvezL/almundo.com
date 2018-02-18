package com.almundo.prueba.service.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almundo.prueba.dto.LlamadaThreadDto;
import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;
import com.almundo.prueba.service.Dispatcher;
import com.almundo.prueba.threads.ConsumerLlamada;
import com.almundo.prueba.threads.ProducerLlamada;

@Service
public class DispatcherImpl implements Dispatcher {

	@Autowired EmpleadoRepository empleadoRepository;
	@Autowired LlamadaRepository llamadaRepository;
	@Autowired Dispatcher dispatcher;
	
	@Override
	public void dispatchCall(Long numeroLlamada) {
		
		BlockingQueue<LlamadaThreadDto> blockingQueue = new ArrayBlockingQueue<>(1);
		
		ExecutorService producer = Executors.newFixedThreadPool(1);
		ExecutorService consumer = Executors.newFixedThreadPool(1);
		producer.submit(new ProducerLlamada(blockingQueue, numeroLlamada, empleadoRepository, llamadaRepository, dispatcher));
		consumer.submit(new ConsumerLlamada(blockingQueue));
		producer.shutdown();
		consumer.shutdown();
	}

}
