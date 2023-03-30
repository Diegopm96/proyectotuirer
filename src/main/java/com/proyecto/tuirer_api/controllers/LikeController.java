package com.proyecto.tuirer_api.controllers;

import java.util.HashMap;

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

import com.proyecto.tuirer_api.models.Like;
import com.proyecto.tuirer_api.services.LikeServiceImpl;

@RestController
@RequestMapping("/api")
public class LikeController {

	@Autowired
	LikeServiceImpl likeService;

	@GetMapping("/like/{idLike}")
	public Like obtenerLikeId(@PathVariable int idLike) {

		return this.likeService.obtenerLikePorId(idLike);
	}

	@PostMapping("/like")
	public ResponseEntity<Like> guardarLike(@RequestBody Like like) {

		Like nuevoLike = this.likeService.guardarLike(like);

		return new ResponseEntity<>(nuevoLike, HttpStatus.ACCEPTED);
	}

		@DeleteMapping("/like/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarLike(@RequestBody int id) {

		this.likeService.eliminarLike(id);

		HashMap<String, Boolean> estadoLikeEliminado = new HashMap<>();

		estadoLikeEliminado.put("eliminado", true);

		return new ResponseEntity<>(estadoLikeEliminado, HttpStatus.ACCEPTED);

	}
}
