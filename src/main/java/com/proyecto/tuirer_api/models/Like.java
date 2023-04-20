package com.proyecto.tuirer_api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Likes", catalog = "proyecto_tuirer")
public class Like implements Serializable {

	private static final long serialVersionUID = -5764556820340419660L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LIKE", unique = true, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "ID_TUIT", nullable = true)
	private Tuit tuit;

	@Column(name = "FLAG_LIKE")
	private boolean flagLike;

	@ManyToOne
	@JoinColumn(name = "ID_COMENTARIO", nullable = true)
	private Comentario comentario;

	@Column(name = "ID_USUARIO")
	private int idUsuario;

	public Like() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tuit getTuit() {
		return tuit;
	}

	public void setTuit(Tuit tuit) {
		this.tuit = tuit;
	}

	public boolean isFlagLike() {
		return flagLike;
	}

	public void setFlagLike(boolean flagLike) {
		this.flagLike = flagLike;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
