package com.proyecto.tuirer_api.dtos;

import java.util.Date;
import java.util.List;

public class UsuarioDTO {

	private int id;
	private String email;
	private String nombreUsuario;
	private String password;
	private Date fechaRegistro;
	private List<TuitDTO> tuits;
	private List<ComentarioDTO>comentarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<TuitDTO> getTuits() {
		return tuits;
	}

	public void setTuits(List<TuitDTO> tuits) {
		this.tuits = tuits;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}
	

}
