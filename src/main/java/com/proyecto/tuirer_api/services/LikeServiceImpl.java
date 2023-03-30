package com.proyecto.tuirer_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.models.Like;
import com.proyecto.tuirer_api.repositories.LikeRepository;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeRepository likeRepository;

	@Override
	public Like guardarLike(Like like) {

		return this.likeRepository.save(like);
	}

	@Override
	public Like obtenerLikePorId(int idLike) {

		return this.likeRepository.findById(idLike).orElse(null);
	}

	@Override
	public void eliminarLike(int id) {

		this.likeRepository.deleteById(id);
	}

}
