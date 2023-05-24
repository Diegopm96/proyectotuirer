package com.proyecto.tuirer_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.dtos.UsuarioDTO;
import com.proyecto.tuirer_api.dtos.UsuarioDTOSimp;
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
	public UsuarioDTO guardar(UsuarioDTO usuario) {

		Usuario usuarioEnti =usuarioRepository.save(ModelMapperUtil.transformDto(usuario, Usuario.class));
		;
		
		return ModelMapperUtil.transformDto(usuarioEnti, UsuarioDTO.class);
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

	@Override
	public UsuarioDTO obtenerUsuarioEmail(String email) {
		Usuario usuarioEnti = usuarioRepository.findOneByEmail(email).orElse(null);
		if (null != usuarioEnti) {

			return ModelMapperUtil.transformDto(usuarioEnti, UsuarioDTO.class);
		}
		return null;
	}

	@Override
	public boolean existeUsuario(String usuario) {

		List<Usuario> usuarios = usuarioRepository.findAll();

		List<String> nombreUsuarios = new ArrayList<>();

		for (Usuario usu : usuarios) {

			nombreUsuarios.add(usu.getNombreUsuario());
		}

		return nombreUsuarios.contains(usuario);
	}

	@Override
	public boolean existeEmail(String email) {
		List<Usuario> usuarios = usuarioRepository.findAll();

		List<String> emails = new ArrayList<>();

		for (Usuario usu : usuarios) {

			emails.add(usu.getEmail());
		}

		return emails.contains(email);
	}

	@Override
	public UsuarioDTO obtenerUsuarioNombreUsuario(String nombreUsuario) {
		Usuario usuarioEnti = usuarioRepository.findOneByNombreUsuario(nombreUsuario).orElse(null);
		
		if (null != usuarioEnti) {

			return ModelMapperUtil.transformDto(usuarioEnti, UsuarioDTO.class);
		}
		return null;
	}

	@Override
	public void seguirUsuario(int idSeguidor, int idSeguido) {
		
		Usuario seguidor = usuarioRepository.findById(idSeguidor).orElse(null);
		
		Usuario seguido = usuarioRepository.findById(idSeguido).orElse(null);
		
		seguidor.seguir(seguido);
		usuarioRepository.save(seguidor);
	}
	

	@Override
	public void dejarDeSeguir(int idSeguidor, int idSeguido) {
		
		Usuario seguidor = usuarioRepository.findById(idSeguidor).orElse(null);
		
		Usuario seguido = usuarioRepository.findById(idSeguido).orElse(null);
		
		seguidor.dejarSeguir(seguido);
		usuarioRepository.save(seguidor);
		
	}

	@Override
	public List<UsuarioDTOSimp> obtenerUsuariosDto() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTOSimp> usuariosDTO = new ArrayList<>();
		if (!usuarios.isEmpty()) {

			usuariosDTO = ModelMapperUtil.transformDtoList(usuarios, UsuarioDTOSimp.class);
		}
		return usuariosDTO;
	}

}
