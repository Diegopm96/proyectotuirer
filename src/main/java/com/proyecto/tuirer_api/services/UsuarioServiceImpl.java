package com.proyecto.tuirer_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.models.Usuario;
import com.proyecto.tuirer_api.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> obtenerUsuarios() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorId(int id) {
		
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarUsuario(int id) {
		
		usuarioRepository.deleteById(id);
	}

	

}
