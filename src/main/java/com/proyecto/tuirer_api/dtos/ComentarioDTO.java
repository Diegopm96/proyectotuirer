package com.proyecto.tuirer_api.dtos;

import java.util.Date;
import java.util.List;

public class ComentarioDTO {

	private int id;
	private String contenido;
	private Date fechaPublicacion;
	private UsuarioDTOSimp usuario;
	private int idTuitComentado;
	private List<LikeDTOSimp> likes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public int getIdTuitComentado() {
		return idTuitComentado;
	}

	public void setIdTuitComentado(int idTuitComentado) {
		this.idTuitComentado = idTuitComentado;
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

	

	public UsuarioDTOSimp getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTOSimp usuario) {
		this.usuario = usuario;
	}

	public List<LikeDTOSimp> getLikes() {
		return likes;
	}

	public void setLikes(List<LikeDTOSimp> likes) {
		this.likes = likes;
	}

}
