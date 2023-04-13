package com.proyecto.tuirer_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tuirer_api.models.Comentario;
import com.proyecto.tuirer_api.models.Like;
import com.proyecto.tuirer_api.models.Tuit;
@Repository
public interface LikeRepository extends JpaRepository<Like,Integer> {

	List<Like>findByComentario(Comentario comentario);
	
	List<Like>findByTuit(Tuit tuit);
}
