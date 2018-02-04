package com.almundo.prueba.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_empleado database table.
 * 
 */
@Entity
@Table(name="tipo_empleado")
@NamedQuery(name="TipoEmpleado.findAll", query="SELECT t FROM TipoEmpleado t")
public class TipoEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="tipoEmpleado", fetch=FetchType.EAGER)
	private List<Empleado> empleados;

	public TipoEmpleado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setTipoEmpleado(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setTipoEmpleado(null);

		return empleado;
	}

}