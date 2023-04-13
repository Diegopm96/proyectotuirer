package com.proyecto.tuirer_api.services;

import java.util.List;

import com.proyecto.tuirer_api.dtos.UsuarioDTO;
import com.proyecto.tuirer_api.models.Usuario;

public interface UsuarioService {

	public List<UsuarioDTO> obtenerUsuarios();
	
	public Usuario guardar(UsuarioDTO usuario);
	
	public UsuarioDTO obtenerUsuarioPorId(int id);
	
	public void eliminarUsuario(int id);
	
//	public Usuario modificarUsuario(int id,Usuario usuario);
	
	
}
