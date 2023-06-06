package com.proyecto.tuirer_api.models;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="Chat", catalog="proyecto_tuirer")
public class Chat implements Serializable{

	
	private static final long serialVersionUID = 7595814892863663725L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CHAT", unique = true, nullable = false)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "ID_USUARIO_EMISOR")
	private Usuario usuarioEmisor;
	
	@ManyToOne
    @JoinColumn(name = "ID_USUARIO_RECEPTOR")
	private Usuario usuarioReceptor;

	@OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mensaje> mensajes = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Usuario getUsuarioEmisor() {
		return usuarioEmisor;
	}

	public void setUsuarioEmisor(Usuario usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}

	public Usuario getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(Usuario usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}
	
	public void agregarMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
        mensaje.setChat(this);
    }

    public void removerMensaje(Mensaje mensaje) {
        mensajes.remove(mensaje);
        mensaje.setChat(null);
    }
	
	
	

}
