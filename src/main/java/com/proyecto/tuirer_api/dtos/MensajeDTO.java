package com.proyecto.tuirer_api.dtos;

import java.util.Date;

public class MensajeDTO {

	private int id;
	
	private String contenido;
	
	private ChatDTOSimp chat;
	
	private Date fecha;
	
	private UsuarioDTOSimp usuario;
	

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

	

	public ChatDTOSimp getChat() {
		return chat;
	}

	public void setChat(ChatDTOSimp chat) {
		this.chat = chat;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public UsuarioDTOSimp getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTOSimp usuario) {
		this.usuario = usuario;
	}
	
	
	
}
