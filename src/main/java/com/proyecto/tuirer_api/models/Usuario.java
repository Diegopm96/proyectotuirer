package com.proyecto.tuirer_api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario", catalog = "proyecto_tuirer")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2471673345411684055L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO", unique = true, nullable = false)
	private int id;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "NOMBRE_USUARIO")
	private String nombreUsuario;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FECHA_REGISTRO")
	private Date fechaRegistro;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tuit> tuits;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "seguimiento", joinColumns = @JoinColumn(name = "ID_USUARIO_SEGUIDOR"), inverseJoinColumns = @JoinColumn(name = "ID_USUARIO_SEGUIDO"))
	private Set<Usuario> siguiendo = new HashSet<>();

	@ManyToMany(mappedBy = "siguiendo", fetch = FetchType.LAZY)
	private Set<Usuario> seguidores = new HashSet<>();

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Set<Usuario> getSiguiendo() {
		return siguiendo;
	}

	public void setSiguiendo(Set<Usuario> siguiendo) {
		this.siguiendo = siguiendo;
	}



	public Set<Usuario> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(Set<Usuario> seguidores) {
		this.seguidores = seguidores;
	}

	public Usuario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Tuit> getTuits() {
		return tuits;
	}

	public void setTuits(List<Tuit> tuits) {
		this.tuits = tuits;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void seguir(Usuario usuario) {

		this.siguiendo.add(usuario);
		usuario.getSeguidores().add(usuario);
	}
	
	public void dejarSeguir(Usuario usuario) {
		this.siguiendo.remove(usuario);
		usuario.getSeguidores().remove(usuario);
	}
	
}
