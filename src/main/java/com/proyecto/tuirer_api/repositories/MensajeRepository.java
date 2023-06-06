package com.proyecto.tuirer_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tuirer_api.models.Mensaje;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje,Integer> {

	
	
}
