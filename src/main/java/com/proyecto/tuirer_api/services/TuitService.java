package com.proyecto.tuirer_api.services;

import java.util.List;

import com.proyecto.tuirer_api.dtos.TuitDTO;
import com.proyecto.tuirer_api.models.Tuit;


public interface TuitService {
	
	public List<TuitDTO> obtenerTodosTuits();
	
	public List<TuitDTO> obtenerTuitsUsuario(int id);

	public List<Tuit> obtenerTuits(int id) ;
	
	public TuitDTO guardar(TuitDTO tuit);
	
	public void eliminarTuit(int id);
}
