package com.almundo.prueba.threads;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.prueba.dto.LlamadaThreadDto;
import com.almundo.prueba.entities.Empleado;
import com.almundo.prueba.entities.Llamada;
import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;
import com.almundo.prueba.service.Dispatcher;

public class ConsumerLlamada implements Runnable {
	
	private final BlockingQueue<LlamadaThreadDto> sharedQueue;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerLlamada.class);
	
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
				registrarLlamada(llamadaThreadDto.getNumeroLlamada(), empleadoRepository, llamadaRepository, operadoresList);
			}else{
				List<Empleado> supervisoresList = empleadoRepository.consultarSuervisoresDisponibles();
				
				if(Objects.nonNull(supervisoresList) && !supervisoresList.isEmpty()){
					registrarLlamada(llamadaThreadDto.getNumeroLlamada(), empleadoRepository, llamadaRepository, supervisoresList);
				}else{
					List<Empleado> directorList = empleadoRepository.consultarDirectoresDisponibles();
					
					if(Objects.nonNull(directorList) && !directorList.isEmpty()){
						registrarLlamada(llamadaThreadDto.getNumeroLlamada(), empleadoRepository, llamadaRepository, directorList);
					}else{
						Thread.sleep(5000);
						Dispatcher dispatcher = llamadaThreadDto.getDispatcher();
						dispatcher.dispatchCall(llamadaThreadDto.getNumeroLlamada());
					}
				}
			}
			
        } catch (Exception e) {
        	LOGGER.error(e.getMessage());
        	throw new RuntimeException(e);
        }
	}
	
	private void registrarLlamada(Long numeroLlamada, EmpleadoRepository empleadoRepository, LlamadaRepository llamadaRepository, List<Empleado> empleadosList){
		for(Empleado empleado: empleadosList){
			empleado.setDisponible(false);
			empleado = empleadoRepository.save(empleado);
			
			Llamada llamada = new Llamada();
			llamada.setEmpleado(empleado);
			llamada.setFecha(new Date());
			Random generadorAleatorios = new Random();
		    int numeroAleatorio = 5 + generadorAleatorios.nextInt(10);
			llamada.setDuracion(numeroAleatorio);
			llamadaRepository.save(llamada);
			
			iniciarLlamada(numeroLlamada, empleadoRepository, llamadaRepository, empleado, numeroAleatorio);
			break;
		}
	}
	
	private void iniciarLlamada(Long numeroLlamada, EmpleadoRepository empleadoRepository, LlamadaRepository llamadaRepository, Empleado empleado, int numeroAleatorio){
		int numeroEmpleados = empleadoRepository.consultarNumeroEmpleados();
		ExecutorService executor = CallPool.getExecutorService(numeroEmpleados);
		Runnable llamada = new LlamadaThread(numeroLlamada, empleadoRepository, llamadaRepository, empleado, numeroAleatorio);
		executor.execute(llamada);
	}

}
