package com.proyecto.tuirer_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tuirer_api.models.Tuit;
import com.proyecto.tuirer_api.models.Usuario;

@Repository
public interface TuitRepository extends JpaRepository<Tuit, Integer> {

	List<Tuit> findByUsuario(Usuario IdUsuario);

}
