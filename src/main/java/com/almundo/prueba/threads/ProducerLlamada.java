package com.almundo.prueba.threads;

import java.util.concurrent.BlockingQueue;

import com.almundo.prueba.dto.LlamadaThreadDto;
import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;

public class ProducerLlamada implements Runnable {
	
	private final BlockingQueue<LlamadaThreadDto> sharedQueue;
	private EmpleadoRepository empleadoRepository;
	private LlamadaRepository llamadaRepository;
	
	public ProducerLlamada(BlockingQueue<LlamadaThreadDto> sharedQueue,	EmpleadoRepository empleadoRepository, LlamadaRepository llamadaRepository) {
        this.sharedQueue = sharedQueue;
        this.empleadoRepository = empleadoRepository;
        this.llamadaRepository = llamadaRepository;
    }

	@Override
	public void run() {
		try {   		
            sharedQueue.put(new LlamadaThreadDto(empleadoRepository, llamadaRepository));
        } catch (Exception err) {
//        	LOGGER.info(err.getMessage());
        }
	}

}
