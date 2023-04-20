package com.proyecto.tuirer_api.services;

import java.util.List;

import com.proyecto.tuirer_api.dtos.LikeDTO;
import com.proyecto.tuirer_api.dtos.LikeDTOSimp;
import com.proyecto.tuirer_api.models.Comentario;
import com.proyecto.tuirer_api.models.Like;
import com.proyecto.tuirer_api.models.Tuit;

public interface LikeService {

	public Like guardarLike(LikeDTO like);
	
	public LikeDTO obtenerLikePorId(int id);
	
	public void eliminarLike(int id);
	
	public List<LikeDTOSimp> obtenerLikeIdTuit(Tuit tuit);
	
	public List<Like> obtenerLikeIdComentario(Comentario comentario);
	
	
	
}
