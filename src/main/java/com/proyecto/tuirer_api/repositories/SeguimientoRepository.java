package com.proyecto.tuirer_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tuirer_api.models.Seguimiento;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento,Integer> {

}
