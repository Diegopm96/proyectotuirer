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
@Table(name="Comentario", catalog="proyecto_tuirer")
public class Comentario implements Serializable {

	
	private static final long serialVersionUID = -8895044187407679597L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="ID_COMENTARIO",unique=true,nullable=false)
	private int id;
	
	@Column(name="CONTENIDO")
	private String contenido;
	
	@Column(name="FECHA_PUBLICACION")
	private Date fechaPublicacion;
	
	@Column(name="ID_USUARIO")
	private int idUsuario;
	
	@Column(name="ID_TUIT_COMENTADO")
	private int idTuitComentado;
	
	
	public Comentario () {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}


	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getIdTuitComentado() {
		return idTuitComentado;
	}


	public void setIdTuitComentado(int idTuitComentado) {
		this.idTuitComentado = idTuitComentado;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
