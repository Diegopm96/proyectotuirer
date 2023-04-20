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

import com.proyecto.tuirer_api.dtos.ComentarioDTO;
import com.proyecto.tuirer_api.services.ComentarioServiceImpl;

@RestController
@RequestMapping("/api")
public class ComentarioController {

	@Autowired
	ComentarioServiceImpl comentarioService;

	@GetMapping("/comentarios")
	public List<ComentarioDTO> obtenerComentarios() {

		return comentarioService.obtenerComentarios();
	}

	@PostMapping("/comentario")
	public ResponseEntity<ComentarioDTO> guardar(@RequestBody ComentarioDTO comentario) {

		ComentarioDTO nuevoComentario = this.comentarioService.guardar(comentario);

		return new ResponseEntity<>(nuevoComentario, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/comentario/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarComentario(@PathVariable int id) {

		this.comentarioService.eliminar(id);
		HashMap<String, Boolean> estadoComentarioEliminado = new HashMap<>();

		estadoComentarioEliminado.put("Eliminado", true);

		return new ResponseEntity<>(estadoComentarioEliminado, HttpStatus.ACCEPTED);
	}

	@GetMapping("/comentario/{id}")
	public ComentarioDTO obtenerComentarioId(@PathVariable int id) {

		return comentarioService.obtenerComentarioPorId(id);

	}
	
	@GetMapping("/comentario/tuit/{idTuit}")
	public List<ComentarioDTO> obtenerComentariosTuit(@PathVariable int idTuit){
		
		return comentarioService.obtenerComentariosIdTuit(idTuit);
	}

}
