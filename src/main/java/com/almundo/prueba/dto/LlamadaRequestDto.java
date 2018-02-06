package com.almundo.prueba.dto;

import java.io.Serializable;

public class LlamadaRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int numero;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
