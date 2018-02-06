package com.almundo.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almundo.prueba.entities.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

	@Query(value = "SELECT COUNT(e) FROM Empleado e ")
	public int consultarNumeroEmpleados();
	
	@Query(value = "SELECT e FROM Empleado e WHERE e.disponible = TRUE AND e.tipoEmpleado.id = 1 ")
	public List<Empleado> consultarOperadoresDisponibles();
	
	@Query(value = "SELECT e FROM Empleado e WHERE e.disponible = TRUE AND e.tipoEmpleado.id = 2 ")
	public List<Empleado> consultarSuervisoresDisponibles();
	
	@Query(value = "SELECT e FROM Empleado e WHERE e.disponible = TRUE AND e.tipoEmpleado.id = 3 ")
	public List<Empleado> consultarDirectoresDisponibles();
}
