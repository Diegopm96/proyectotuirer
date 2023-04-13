package com.proyecto.tuirer_api.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.tuirer_api.dtos.UsuarioDTO;
import com.proyecto.tuirer_api.models.Usuario;
import com.proyecto.tuirer_api.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioService;

	@GetMapping("/usuarios")
	public List<UsuarioDTO> obtenerUsuarios() {

		return usuarioService.obtenerUsuarios();

	}

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody UsuarioDTO usuario) {

		Usuario nuevoUsuario = usuarioService.guardar(usuario);

		return new ResponseEntity<>(nuevoUsuario, HttpStatus.ACCEPTED);
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDTO> obtenerUsuarioId(@PathVariable int id) {

		UsuarioDTO usuario = usuarioService.obtenerUsuarioPorId(id);

		return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
	}

//	@PutMapping("/usuario/{id}")
//	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
//
//		UsuarioDTO usuarioPorId = usuarioService.obtenerUsuarioPorId(id);
//		usuarioPorId.setEmail(usuario.getEmail());
//		usuarioPorId.setFechaRegistro(usuario.getFechaRegistro());
//		usuarioPorId.setNombreUsuario(usuario.getNombreUsuario());
//		usuarioPorId.setPassword(usuario.getPassword());
//
//		Usuario usuarioActualizado = usuarioService.guardar(usuarioPorId);
//
//		return new ResponseEntity<>(usuarioActualizado, HttpStatus.CREATED);
//	}

	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable int id) {

		this.usuarioService.eliminarUsuario(id);
		HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap<>();

		estadoUsuarioEliminado.put("Eliminado", true);

		return new ResponseEntity<>(estadoUsuarioEliminado, HttpStatus.ACCEPTED);
	}

}
