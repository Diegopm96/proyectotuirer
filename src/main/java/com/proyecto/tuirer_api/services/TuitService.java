package com.proyecto.tuirer_api.services;

import java.util.List;



import com.proyecto.tuirer_api.models.Tuit;


public interface TuitService {
	
	public List<Tuit> obtenerTodosTuits();
	
	public List<Tuit> obtenerTuitsUsuario(int id);

	public List<Tuit> obtenerTuits(int id) ;
	
	public Tuit guardar(Tuit tuit);
	
	public void eliminarTuit(int id);
}
