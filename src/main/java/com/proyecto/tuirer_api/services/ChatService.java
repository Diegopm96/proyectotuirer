package com.proyecto.tuirer_api.services;

import java.util.List;

import com.proyecto.tuirer_api.dtos.ChatDTO;

public interface ChatService {

	public ChatDTO guardarChat(int idEmisor, int idReceptor);
	
	public List<ChatDTO> obtenerChats(int idEmisor);
	
	public ChatDTO obtenerChat(int idChat);
}
