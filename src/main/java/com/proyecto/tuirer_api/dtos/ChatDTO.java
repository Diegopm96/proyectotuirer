package com.proyecto.tuirer_api.dtos;

import java.util.List;

public class ChatDTO {

	private int id;
	
	private UsuarioDTOSimp usuarioEmisor;
	
	private UsuarioDTOSimp usuarioReceptor;
	
	private List<MensajeDTO> mensajes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UsuarioDTOSimp getUsuarioEmisor() {
		return usuarioEmisor;
	}

	public void setUsuarioEmisor(UsuarioDTOSimp usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}

	public UsuarioDTOSimp getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(UsuarioDTOSimp usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}

	public List<MensajeDTO> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeDTO> mensajes) {
		this.mensajes = mensajes;
	}
	
	
	
}
