package com.proyecto.tuirer_api.services;

import com.proyecto.tuirer_api.dtos.MensajeDTO;

public interface MensajeService {
	
	public MensajeDTO guardarMensaje(MensajeDTO mensaje,int chatId);
	
	
}
