package com.proyecto.tuirer_api.dtos;

public class LikeDTO {

	private int id;
	private int idUsuario;
	private boolean flagLike;
	private int tuit;
	private int comentario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public boolean isFlagLike() {
		return flagLike;
	}

	public void setFlagLike(boolean flagLike) {
		this.flagLike = flagLike;
	}

	

	public int getTuit() {
		return tuit;
	}

	public void setTuit(int tuit) {
		this.tuit = tuit;
	}

	public int getComentario() {
		return comentario;
	}

	public void setComentario(int comentario) {
		this.comentario = comentario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
