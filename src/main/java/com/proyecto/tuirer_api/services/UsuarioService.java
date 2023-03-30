package com.proyecto.tuirer_api.services;

import java.util.List;

import com.proyecto.tuirer_api.models.Usuario;

public interface UsuarioService {

	public List<Usuario> obtenerUsuarios();
	
	public Usuario guardar(Usuario usuario);
	
	public Usuario obtenerUsuarioPorId(int id);
	
	public void eliminarUsuario(int id);
	
//	public Usuario modificarUsuario(int id,Usuario usuario);
	
	
}
