package com.almundo.prueba.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallPool {
	
	private static ExecutorService executor;
	
	public static ExecutorService getExecutorService() {
		if(executor==null) {
			executor=Executors.newFixedThreadPool(10);
			System.out.println("crear execute");
		}
		return executor;
	}
	
	
}
