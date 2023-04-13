package com.proyecto.tuirer_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.dtos.TuitDTO;
import com.proyecto.tuirer_api.models.Tuit;
import com.proyecto.tuirer_api.models.Usuario;
import com.proyecto.tuirer_api.repositories.TuitRepository;
import com.proyecto.tuirer_api.repositories.UsuarioRepository;
import com.proyecto.tuirer_api.utils.ModelMapperUtil;

@Service
public class TuitServiceImpl implements TuitService {

	@Autowired
	TuitRepository tuitRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<TuitDTO> obtenerTodosTuits() {

		List<Tuit> tuits = tuitRepository.findAll();
		List<TuitDTO> tuitsDTO = new ArrayList<>();
		if (!tuits.isEmpty()) {
			tuitsDTO = ModelMapperUtil.transformDtoList(tuits, TuitDTO.class);
		}
		return tuitsDTO;
	}

	@Override
	public List<Tuit> obtenerTuits(int id) {

		return null;
	}

	@Override
	public TuitDTO guardar(TuitDTO tuit) {

		Tuit tuitEnti = ModelMapperUtil.transformDto(tuit, Tuit.class);

		return ModelMapperUtil.transformDto(tuitRepository.save(tuitEnti), TuitDTO.class);
	}

	@Override
	public void eliminarTuit(int id) {

		this.tuitRepository.deleteById(id);

	}

	@Override
	public List<TuitDTO> obtenerTuitsUsuario(int id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);
		List<TuitDTO> tuits = new ArrayList<>();

		if (usuario.isPresent()) {

			tuits = ModelMapperUtil.transformDtoList(usuario.get().getTuits(), TuitDTO.class);

			return tuits;
		}

		return tuits;
	}

}
