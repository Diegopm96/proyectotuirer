package com.proyecto.tuirer_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.tuirer_api.models.Like;

public interface LikeRepository extends JpaRepository<Like,Integer> {

	List<Like>findByidUsuario(int id);
}
