package com.proyecto.tuirer_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.tuirer_api.dtos.ChatDTO;
import com.proyecto.tuirer_api.dtos.MensajeDTO;
import com.proyecto.tuirer_api.services.ChatService;
import com.proyecto.tuirer_api.services.MensajeService;

@Controller
@RequestMapping("/api/chat")
public class ChatController {

	@Autowired
	MensajeService mensajeService;

	@Autowired
	ChatService chatService;

	@GetMapping("/{idEmisor}/{idReceptor}")
	public ResponseEntity<ChatDTO> crearChat(@PathVariable int idEmisor, @PathVariable int idReceptor) {

		ChatDTO chat = chatService.guardarChat(idEmisor, idReceptor);

		return new ResponseEntity<ChatDTO>(chat, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{idChat}")
	public ResponseEntity<ChatDTO> obtenerChat(@PathVariable int idChat) {

		return new ResponseEntity<ChatDTO>(chatService.obtenerChat(idChat), HttpStatus.ACCEPTED);

	}

	@PostMapping("/mensaje/{idChat}")
	public ResponseEntity<MensajeDTO> guardarMensaje(@RequestBody MensajeDTO mensaje, @PathVariable int idChat) {

		MensajeDTO mensajeDto = mensajeService.guardarMensaje(mensaje, idChat);

		return new ResponseEntity<MensajeDTO>(mensajeDto, HttpStatus.ACCEPTED);
	}

	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity<List<ChatDTO>> obtenerChatsUsuario(@PathVariable int idUsuario) {

		List<ChatDTO> chats = chatService.obtenerChats(idUsuario);
		
		return new ResponseEntity<List<ChatDTO>>(chats,HttpStatus.ACCEPTED);
	}

}
