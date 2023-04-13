package com.proyecto.tuirer_api.dtos;

import java.util.Date;
import java.util.List;

public class TuitDTO {

	private int id;
	private String contenido;
	private Date fechaPublicacion;
	private int idUsuario;
	private List<LikeDTOSimp> likes;
	
	public List<LikeDTOSimp> getLikes() {
		return likes;
	}
	public void setLikes(List<LikeDTOSimp> likes) {
		this.likes = likes;
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
	
	
}
