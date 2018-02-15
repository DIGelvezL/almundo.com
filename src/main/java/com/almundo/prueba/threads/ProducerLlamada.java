package com.almundo.prueba.threads;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.prueba.dto.LlamadaThreadDto;
import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;

public class ProducerLlamada implements Runnable {
	
	private final BlockingQueue<LlamadaThreadDto> sharedQueue;
	private EmpleadoRepository empleadoRepository;
	private LlamadaRepository llamadaRepository;
	private Long numeroLlamada;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerLlamada.class);
	
	public ProducerLlamada(BlockingQueue<LlamadaThreadDto> sharedQueue, Long numeroLlamada,	EmpleadoRepository empleadoRepository, LlamadaRepository llamadaRepository) {
        this.sharedQueue = sharedQueue;
        this.numeroLlamada = numeroLlamada;
        this.empleadoRepository = empleadoRepository;
        this.llamadaRepository = llamadaRepository;
    }

	@Override
	public void run() {
		try {   		
            sharedQueue.put(new LlamadaThreadDto(numeroLlamada, empleadoRepository, llamadaRepository));
        } catch (Exception er) {
        	LOGGER.error(er.getMessage());
        	throw new RuntimeException(er);
        }
	}

}
