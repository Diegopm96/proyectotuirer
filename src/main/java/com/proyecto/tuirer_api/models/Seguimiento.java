package com.proyecto.tuirer_api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Seguimiento", catalog = "proyecto_tuirer")
public class Seguimiento implements Serializable {

	
	private static final long serialVersionUID = 583056391806118101L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SEGUIMIENTO", unique = true, nullable = false)
	private int id;
	
	@Column(name="ID_USUARIO_SEGUIDOR")
	private int usuarioSeguidor;
	
	@Column(name="ID_USUARIO_SEGUIDO")
	private int usuarioSeguido;
	
	@Column(name="FECHA_SEGUIMIENTO")
	private Date fechaSeguimiento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuarioSeguidor() {
		return usuarioSeguidor;
	}

	public void setUsuarioSeguidor(int usuarioSeguidor) {
		this.usuarioSeguidor = usuarioSeguidor;
	}

	public int getUsuarioSeguido() {
		return usuarioSeguido;
	}

	public void setUsuarioSeguido(int usuarioSeguido) {
		this.usuarioSeguido = usuarioSeguido;
	}

	public Date getFechaSeguimiento() {
		return fechaSeguimiento;
	}

	public void setFechaSeguimiento(Date fechaSeguimiento) {
		this.fechaSeguimiento = fechaSeguimiento;
	}
	
	 
}
