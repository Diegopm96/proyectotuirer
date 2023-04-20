package com.proyecto.tuirer_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.dtos.LikeDTO;
import com.proyecto.tuirer_api.dtos.LikeDTOSimp;
import com.proyecto.tuirer_api.models.Comentario;
import com.proyecto.tuirer_api.models.Like;
import com.proyecto.tuirer_api.models.Tuit;
import com.proyecto.tuirer_api.repositories.ComentarioRepository;
import com.proyecto.tuirer_api.repositories.LikeRepository;
import com.proyecto.tuirer_api.repositories.TuitRepository;
import com.proyecto.tuirer_api.utils.ModelMapperUtil;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeRepository likeRepository;

	@Autowired
	ComentarioRepository comentarioRepository;

	@Autowired
	TuitRepository tuitRepository;

	@Override
	public Like guardarLike(LikeDTO like) {

		int idComentario = like.getComentario();
		int idTuit = like.getTuit();
		Comentario comentario = new Comentario();
		Tuit tuit = new Tuit();
		Like likeEnti = ModelMapperUtil.transformDto(like, Like.class);

		if (null != comentarioRepository.findById(idComentario).orElse(null)) {

			comentario = comentarioRepository.findById(idComentario).orElse(null);
			likeEnti.setComentario(comentario);

		} else if (null != tuitRepository.findById(idTuit).orElse(null)) {

			tuit = tuitRepository.findById(idTuit).orElse(null);
			likeEnti.setTuit(tuit);
		}

		return likeRepository.save(likeEnti);
	}

	@Override
	public LikeDTO obtenerLikePorId(int idLike) {

		Optional<Like> like = likeRepository.findById(idLike);
		LikeDTO likeDTO = new LikeDTO();
		if (like.isPresent()) {

			likeDTO = ModelMapperUtil.transformDto(like.get(), LikeDTO.class);
		}
		return likeDTO;
	}

	@Override
	public void eliminarLike(int id) {

		this.likeRepository.deleteById(id);
	}

	

	@Override
	public List<Like> obtenerLikeIdComentario(Comentario id) {

		return this.likeRepository.findByComentario(id);

	}
	
	@Override
	public List<LikeDTOSimp> obtenerLikeIdTuit(Tuit id) {
		
		List<Like> likes= this.likeRepository.findByTuit(id);
		List<LikeDTOSimp> likesDTO = new ArrayList<>();
		if(!likes.isEmpty()) {
			likesDTO = ModelMapperUtil.transformDtoList(likes, LikeDTOSimp.class);
			return likesDTO;
		}
		
		return null;
		
	}

}
