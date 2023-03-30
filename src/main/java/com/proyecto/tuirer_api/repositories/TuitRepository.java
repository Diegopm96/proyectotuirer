package com.proyecto.tuirer_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyecto.tuirer_api.models.Tuit;

public interface TuitRepository extends JpaRepository<Tuit,Integer> {

	
    List<Tuit> findByidUsuario( Integer IdUsuario);
    
}
