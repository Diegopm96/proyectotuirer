package com.proyecto.tuirer_api.dtos;

public class LikeDTOSimp {

	private int id;
	private int idUsuario;
	private boolean flagLike;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public boolean isFlagLike() {
		return flagLike;
	}
	public void setFlagLike(boolean flagLike) {
		this.flagLike = flagLike;
	}
	
	
}
