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

import com.proyecto.tuirer_api.dtos.TuitDTO;
import com.proyecto.tuirer_api.services.TuitServiceImpl;

@RestController
@RequestMapping("/api")
public class TuitController {

	@Autowired
	TuitServiceImpl tuitService;

	@GetMapping("/tuits")
	public List<TuitDTO> obtenerTuits() {

		return tuitService.obtenerTodosTuits();
	}

	@PostMapping("/tuit")
	public ResponseEntity<TuitDTO> guardar(@RequestBody TuitDTO tuit) {

		TuitDTO nuevoTuit = this.tuitService.guardar(tuit);

		return new ResponseEntity<>(nuevoTuit, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/tuit/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarTuit(@PathVariable int id) {

		this.tuitService.eliminarTuit(id);
		HashMap<String, Boolean> estadoTuitEliminado = new HashMap<>();

		estadoTuitEliminado.put("Elimnado", true);

		return new ResponseEntity<>(estadoTuitEliminado, HttpStatus.ACCEPTED);
	}

	@GetMapping("/tuits/{id}")
	public List<TuitDTO> obtenerTuitsUsuario(@PathVariable int id) {

		return tuitService.obtenerTuitsUsuario(id);

	}

}
