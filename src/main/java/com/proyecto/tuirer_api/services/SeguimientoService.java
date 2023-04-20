package com.proyecto.tuirer_api.services;

import com.proyecto.tuirer_api.models.Seguimiento;

public interface SeguimientoService {

	public Seguimiento crearSeguimiento(Seguimiento seguimiento);
	
	public void borrarSeguimiento(int id);
	
	
	}
