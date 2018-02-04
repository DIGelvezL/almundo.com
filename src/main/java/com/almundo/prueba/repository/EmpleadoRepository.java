package com.almundo.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almundo.prueba.entities.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

}
