package com.proyecto.tuirer_api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Likes", catalog="proyecto_tuirer")
public class Like implements Serializable{

	
	private static final long serialVersionUID = -5764556820340419660L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LIKE", unique = true, nullable = false)
	private int idLike;
	
	@Column(name="ID_TUIT_COMENTARIO")
	private int idComentarioTuit;
	
	@Column(name="FLAG_LIKE")
	private boolean flagLike;
	
	@Column(name="FLAG_TUIT_COMENTARIO")
	private boolean flagTuitComentario;
	
	@Column(name="ID_USUARIO")
	private int idUsuario;
	
	public Like () {
		
	}

	public int getIdLike() {
		return idLike;
	}

	public void setIdLike(int idLike) {
		this.idLike = idLike;
	}

	public int getIdComentario() {
		return idComentarioTuit;
	}

	public void setIdComentario(int idComentario) {
		this.idComentarioTuit = idComentario;
	}

	public boolean isFlagLike() {
		return flagLike;
	}

	public void setFlagLike(boolean flagLike) {
		this.flagLike = flagLike;
	}

	public boolean isFlagTuitComentario() {
		return flagTuitComentario;
	}

	public void setFlagTuitComentario(boolean flagTuitComentario) {
		this.flagTuitComentario = flagTuitComentario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
