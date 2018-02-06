package com.almundo.prueba.threads;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import com.almundo.prueba.dto.LlamadaThreadDto;
import com.almundo.prueba.entities.Empleado;
import com.almundo.prueba.entities.Llamada;
import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;

public class ConsumerLlamada implements Runnable {
	
	private final BlockingQueue<LlamadaThreadDto> sharedQueue;
	
	public ConsumerLlamada (BlockingQueue<LlamadaThreadDto> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

	@Override
	public void run() {

		try {
			LlamadaThreadDto llamadaThreadDto = sharedQueue.take();
			EmpleadoRepository empleadoRepository =  llamadaThreadDto.getEmpleadoRepository();
			LlamadaRepository llamadaRepository = llamadaThreadDto.getLlamadaRepository();
        	
			List<Empleado> operadoresList = empleadoRepository.consultarOperadoresDisponibles();
			
			if(Objects.nonNull(operadoresList) && !operadoresList.isEmpty()){
				for(Empleado operador: operadoresList){
					operador.setDisponible(false);
					empleadoRepository.save(operador);
					
					Llamada llamada = new Llamada();
					llamada.setEmpleado(operador);
					llamada.setFecha(new Date());
					llamada.setDuracion(5);
					llamadaRepository.save(llamada);
					break;
				}
			}
        	
        } catch (Exception err) {
        	
        }
	}

}
