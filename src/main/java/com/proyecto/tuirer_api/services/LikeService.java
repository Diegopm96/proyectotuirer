package com.proyecto.tuirer_api.services;

import com.proyecto.tuirer_api.models.Like;

public interface LikeService {

	public Like guardarLike(Like like);
	
	public Like obtenerLikePorId(int id);
	
	public void eliminarLike(int id);
	
	
	
}
