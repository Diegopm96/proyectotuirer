package com.proyecto.tuirer_api.dtos;

public class ChatDTOSimp {
	private int id;

	private UsuarioDTOSimp usuarioEmisor;

	private UsuarioDTOSimp usuarioReceptor;

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
	
	
}
