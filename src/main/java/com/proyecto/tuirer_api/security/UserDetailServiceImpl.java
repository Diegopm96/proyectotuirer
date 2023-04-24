package com.proyecto.tuirer_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.models.Usuario;
import com.proyecto.tuirer_api.repositories.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario usuario =usuarioRepository.findOneByEmail(email)
		.orElseThrow(()-> new UsernameNotFoundException("El usuario con email "+email+" no existe."));
		
		return new UserDetailsImpl(usuario);
	}
}
