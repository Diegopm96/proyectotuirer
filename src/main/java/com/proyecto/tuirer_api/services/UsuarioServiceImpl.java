package com.proyecto.tuirer_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.dtos.UsuarioDTO;
import com.proyecto.tuirer_api.models.Usuario;
import com.proyecto.tuirer_api.repositories.UsuarioRepository;
import com.proyecto.tuirer_api.utils.ModelMapperUtil;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioDTO> obtenerUsuarios() {

		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		if (!usuarios.isEmpty()) {

			usuariosDTO = ModelMapperUtil.transformDtoList(usuarios, UsuarioDTO.class);
		}
		return usuariosDTO;
	}

	@Override
	public Usuario guardar(UsuarioDTO usuario) {

		Usuario usuarioEnti = ModelMapperUtil.transformDto(usuario, Usuario.class);
		return usuarioRepository.save(usuarioEnti);
	}

	@Override
	public UsuarioDTO obtenerUsuarioPorId(int id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		if (usuario.isPresent()) {

			usuarioDTO = ModelMapperUtil.transformDto(usuario.get(), UsuarioDTO.class);
		}

		return usuarioDTO;
	}

	@Override
	public void eliminarUsuario(int id) {

		usuarioRepository.deleteById(id);
	}
	
	

}
