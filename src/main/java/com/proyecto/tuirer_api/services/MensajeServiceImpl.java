package com.proyecto.tuirer_api.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.dtos.MensajeDTO;
import com.proyecto.tuirer_api.models.Chat;
import com.proyecto.tuirer_api.models.Mensaje;
import com.proyecto.tuirer_api.repositories.ChatRepository;
import com.proyecto.tuirer_api.repositories.MensajeRepository;
import com.proyecto.tuirer_api.repositories.UsuarioRepository;
import com.proyecto.tuirer_api.utils.ModelMapperUtil;

@Service
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	ChatRepository chatRepository;

	@Autowired
	MensajeRepository mensajeRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public MensajeDTO guardarMensaje(MensajeDTO mensaje, int chatId) {

		Chat chat = chatRepository.findById(chatId).orElse(null);

		if (null != chat) {

			Mensaje mensajeEnti = ModelMapperUtil.transformDto(mensaje, Mensaje.class);

			mensajeEnti.setUsuario(usuarioRepository.findById(mensaje.getUsuario().getId()).orElse(null));
			mensajeEnti.setFecha(new Date());
			mensajeEnti.setChat(chatRepository.findById(chatId).orElse(null));
			mensajeEnti = mensajeRepository.save(mensajeEnti);
			chat.agregarMensaje(mensajeEnti);

			return ModelMapperUtil.transformDto(mensajeEnti, MensajeDTO.class);
		}

		return null;
	}

}
