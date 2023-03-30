package com.proyecto.tuirer_api.services;

import java.util.List;

import com.proyecto.tuirer_api.models.Comentario;

public interface ComentarioService {

	public List<Comentario> obtenerComentarios ();
	
	public Comentario guardar(Comentario comentario);
	
	public void eliminar (int id);
}
