package com.proyecto.tuirer_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.dtos.ChatDTO;
import com.proyecto.tuirer_api.models.Chat;
import com.proyecto.tuirer_api.models.Usuario;
import com.proyecto.tuirer_api.repositories.ChatRepository;
import com.proyecto.tuirer_api.repositories.UsuarioRepository;
import com.proyecto.tuirer_api.utils.ModelMapperUtil;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ChatRepository chatRepository;

	@Override
	public ChatDTO guardarChat(int idEmisor, int idReceptor) {

		Chat chatEnti = new Chat();
		Usuario usuarioEmisor = usuarioRepository.findById(idEmisor).orElse(null);
		Usuario usuarioReceptor = usuarioRepository.findById(idReceptor).orElse(null);

		if (null != usuarioEmisor && null != usuarioReceptor) {

			chatEnti.setUsuarioEmisor(usuarioEmisor);
			chatEnti.setUsuarioReceptor(usuarioReceptor);

			chatRepository.save(chatEnti);

			ChatDTO chatDto = ModelMapperUtil.transformDto(chatEnti, ChatDTO.class);

			return chatDto;
		}
		return null;
	}

	@Override
	public List<ChatDTO> obtenerChats(int idEmisor) {

		Usuario usuario = usuarioRepository.findById(idEmisor).orElse(null);

		if (null != usuario) {

			List<Chat> chats = chatRepository.findAllByUsuarioEmisor(usuario);
			List<Chat> chats2 = chatRepository.findAllByUsuarioReceptor(usuario);
			if(!chats2.isEmpty()) {
				
				chats.addAll(chats2);
			}
			return ModelMapperUtil.transformDtoList(chats, ChatDTO.class);
		}

		return null;
	}

	@Override
	public ChatDTO obtenerChat(int idChat) {

		Chat chat = chatRepository.findById(idChat).orElse(null);

		return ModelMapperUtil.transformDto(chat, ChatDTO.class);

	}
}
