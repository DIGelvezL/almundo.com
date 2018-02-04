package com.almundo.prueba.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String apellidos;

	private Boolean libre;

	private String nombres;

	//bi-directional many-to-one association to TipoEmpleado
	@ManyToOne
	@JoinColumn(name="id_tipo_empleado")
	private TipoEmpleado tipoEmpleado;

	//bi-directional many-to-one association to Llamada
	@OneToMany(mappedBy="empleado", fetch=FetchType.EAGER)
	private List<Llamada> llamadas;

	public Empleado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Boolean getLibre() {
		return this.libre;
	}

	public void setLibre(Boolean libre) {
		this.libre = libre;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public TipoEmpleado getTipoEmpleado() {
		return this.tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public List<Llamada> getLlamadas() {
		return this.llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

	public Llamada addLlamada(Llamada llamada) {
		getLlamadas().add(llamada);
		llamada.setEmpleado(this);

		return llamada;
	}

	public Llamada removeLlamada(Llamada llamada) {
		getLlamadas().remove(llamada);
		llamada.setEmpleado(null);

		return llamada;
	}

}