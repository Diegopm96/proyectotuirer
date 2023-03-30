package com.proyecto.tuirer_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.models.Comentario;
import com.proyecto.tuirer_api.repositories.ComentarioRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	ComentarioRepository comentarioRepository;

	@Override
	public List<Comentario> obtenerComentarios() {

		return this.comentarioRepository.findAll();
	}

	@Override
	public Comentario guardar(Comentario comentario) {

		return this.comentarioRepository.save(comentario);
	}

	@Override
	public void eliminar(int id) {

		this.comentarioRepository.deleteById(id);

	}

}
