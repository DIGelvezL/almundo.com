package com.almundo.prueba.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallPool {
	
	private static ExecutorService executor;
	
	private CallPool() {
		throw new IllegalAccessError("CallPool");
	}
	
	public static ExecutorService getExecutorService(int numeroEmpleados) {
		if(executor==null) {
			executor=Executors.newFixedThreadPool(numeroEmpleados);
		}
		return executor;
	}
}
