package com.proyecto.tuirer_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tuirer_api.models.Tuit;
import com.proyecto.tuirer_api.repositories.TuitRepository;

@Service
public class TuitServiceImpl implements TuitService {

	@Autowired
	TuitRepository tuitRepository;
	
	@Override
	public List<Tuit> obtenerTodosTuits() {
		
		return tuitRepository.findAll();
	}

	@Override
	public List<Tuit> obtenerTuits(int id) {

		return null;
	}

	@Override
	public Tuit guardar(Tuit tuit) {

		return tuitRepository.save(tuit);
	}

	@Override
	public void eliminarTuit(int id) {

		this.tuitRepository.deleteById(id);

	}

	@Override
	public List<Tuit> obtenerTuitsUsuario(int id) {
		
		return this.tuitRepository.findByidUsuario(id);
	}

	

}
