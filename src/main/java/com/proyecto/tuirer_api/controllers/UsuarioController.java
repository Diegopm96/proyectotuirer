package com.proyecto.tuirer_api.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.tuirer_api.dtos.UsuarioDTO;
import com.proyecto.tuirer_api.models.Usuario;
import com.proyecto.tuirer_api.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/usuarios")
	public List<UsuarioDTO> obtenerUsuarios() {

		return usuarioService.obtenerUsuarios();

	}

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody UsuarioDTO usuario) {

		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		usuario.setFechaRegistro(new Date());
		Usuario nuevoUsuario = usuarioService.guardar(usuario);
		

		return new ResponseEntity<>(nuevoUsuario, HttpStatus.ACCEPTED);
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDTO> obtenerUsuarioId(@PathVariable int id) {

		UsuarioDTO usuario = usuarioService.obtenerUsuarioPorId(id);

		return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
	}



	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable int id) {

		this.usuarioService.eliminarUsuario(id);
		HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap<>();

		estadoUsuarioEliminado.put("Eliminado", true);

		return new ResponseEntity<>(estadoUsuarioEliminado, HttpStatus.ACCEPTED);
	}

}
