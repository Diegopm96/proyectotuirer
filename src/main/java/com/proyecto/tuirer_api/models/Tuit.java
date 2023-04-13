package com.proyecto.tuirer_api.models;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "Tuit", catalog = "proyecto_tuirer")
public class Tuit implements Serializable {

	private static final long serialVersionUID = -4717600869283651236L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TUIT", unique = true, nullable = false)
	private int id;

	@Column(name = "CONTENIDO")
	private String contenido;

	@Column(name = "FECHA_PUBLICACION")
	private Date fechaPublicacion;

//	@Column(name = "ID_USUARIO")
	@ManyToOne()
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	@OneToMany(mappedBy = "tuit", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Like> likes = new ArrayList<>();

	public Tuit() {
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

	public Usuario getIdUsuario() {
		return usuario;
	}

	public void setIdUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
