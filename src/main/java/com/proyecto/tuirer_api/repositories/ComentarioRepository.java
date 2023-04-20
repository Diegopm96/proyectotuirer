package com.proyecto.tuirer_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tuirer_api.models.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {

	List<Comentario> findByidTuitComentado(int idTuit);
}
