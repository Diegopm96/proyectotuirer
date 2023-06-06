package com.proyecto.tuirer_api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Mensaje", catalog="proyecto_tuirer")
public class Mensaje implements Serializable{

	
	private static final long serialVersionUID = -6047755456719767483L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MENSAJE", unique = true, nullable = false)
	private int id;
	
	@Column(name="CONTENIDO")
	private String contenido;
	
	@ManyToOne
    @JoinColumn(name = "ID_CHAT")
	private Chat chat;
	
	@Column(name="FECHA_ENVIADO")
	private Date fecha;
	
	@ManyToOne
    @JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

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

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
