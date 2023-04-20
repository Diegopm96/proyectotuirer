package com.proyecto.tuirer_api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.dtos.ComentarioDTO;
import com.proyecto.tuirer_api.models.Comentario;
import com.proyecto.tuirer_api.repositories.ComentarioRepository;
import com.proyecto.tuirer_api.utils.ModelMapperUtil;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	ComentarioRepository comentarioRepository;

	@Override
	public List<ComentarioDTO> obtenerComentarios() {
		List<Comentario> comentarios = comentarioRepository.findAll();
		List<ComentarioDTO> comentariosDTO = new ArrayList<>();
		if (!comentarios.isEmpty()) {

			comentariosDTO = ModelMapperUtil.transformDtoList(comentarios, ComentarioDTO.class);
		}

		return comentariosDTO;
	}

	@Override
	public ComentarioDTO guardar(ComentarioDTO comentario) {

		Comentario comentarioEnti = ModelMapperUtil.transformDto(comentario, Comentario.class);
		comentarioEnti.setFechaPublicacion(new Date());
		return ModelMapperUtil.transformDto(comentarioRepository.save(comentarioEnti), ComentarioDTO.class);
	}

	@Override
	public void eliminar(int id) {

		comentarioRepository.deleteById(id);

	}

	@Override
	public ComentarioDTO obtenerComentarioPorId(int id) {

		Optional<Comentario> comentario = comentarioRepository.findById(id);
		ComentarioDTO comentarioDTO = new ComentarioDTO();
		if (comentario.isPresent()) {

			comentarioDTO = ModelMapperUtil.transformDto(comentario.get(), ComentarioDTO.class);

		} else {
			return null;
		}
		return comentarioDTO;
	}

//	terminar metodo
	@Override
	public List<ComentarioDTO> obtenerComentariosIdTuit(int idTuit) {
		
		
		
		List<Comentario> comentariosEnti = comentarioRepository.findByidTuitComentado(idTuit);
		return ModelMapperUtil.transformDtoList(comentariosEnti, ComentarioDTO.class) ;
	}

}
