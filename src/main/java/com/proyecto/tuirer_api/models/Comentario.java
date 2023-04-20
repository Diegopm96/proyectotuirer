package com.proyecto.tuirer_api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Comentario", catalog = "proyecto_tuirer")
public class Comentario implements Serializable {

	private static final long serialVersionUID = -8895044187407679597L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMENTARIO", unique = true, nullable = false)
	private int id;

	@Column(name = "CONTENIDO")
	private String contenido;

	@Column(name = "FECHA_PUBLICACION")
	private Date fechaPublicacion;

	@ManyToOne()
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	@Column(name = "ID_TUIT_COMENTADO")
	private int idTuitComentado;

	@OneToMany(mappedBy = "comentario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Like> likes;

	
	public Comentario() {

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

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public int getIdTuitComentado() {
		return idTuitComentado;
	}

	public void setIdTuitComentado(int idTuitComentado) {
		this.idTuitComentado = idTuitComentado;
	}

	

}
