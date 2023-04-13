package com.proyecto.tuirer_api.services;

import java.util.List;

import com.proyecto.tuirer_api.dtos.ComentarioDTO;

public interface ComentarioService {
	
	public ComentarioDTO obtenerComentarioPorId(int id);

	public List<ComentarioDTO> obtenerComentarios ();
	
	public ComentarioDTO guardar(ComentarioDTO comentario);
	
	public void eliminar (int id);
}
