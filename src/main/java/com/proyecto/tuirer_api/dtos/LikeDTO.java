package com.proyecto.tuirer_api.dtos;

import com.proyecto.tuirer_api.models.Usuario;

public class LikeDTO {

	private int id;
	private Usuario usuario;
	private boolean flagLike;
	private TuitDTO tuit;
	private ComentarioDTO comentario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean isFlagLike() {
		return flagLike;
	}
	public void setFlagLike(boolean flagLike) {
		this.flagLike = flagLike;
	}
	public TuitDTO getTuit() {
		return tuit;
	}
	public void setTuit(TuitDTO tuit) {
		this.tuit = tuit;
	}
	public ComentarioDTO getComentario() {
		return comentario;
	}
	public void setComentario(ComentarioDTO comentario) {
		this.comentario = comentario;
	}

	

}
