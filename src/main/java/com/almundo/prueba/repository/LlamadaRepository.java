package com.almundo.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almundo.prueba.entities.Llamada;

@Repository
public interface LlamadaRepository extends CrudRepository<Llamada, Long> {

}
