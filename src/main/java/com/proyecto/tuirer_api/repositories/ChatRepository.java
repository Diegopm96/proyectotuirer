package com.proyecto.tuirer_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tuirer_api.models.Chat;
import com.proyecto.tuirer_api.models.Usuario;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer> {

	public List<Chat> findAllByUsuarioEmisor(Usuario usuario);

	public List<Chat> findAllByUsuarioReceptor(Usuario usuario);

}
