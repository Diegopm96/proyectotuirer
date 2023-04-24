package com.proyecto.tuirer_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tuirer_api.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

	Optional<Usuario> findOneByEmail(String email);
	
}
