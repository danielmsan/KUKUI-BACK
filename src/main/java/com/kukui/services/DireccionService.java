package com.kukui.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kukui.models.Direccion;
import com.kukui.repositories.DireccionRepository;
@Service
public class DireccionService {
	
	private DireccionRepository direccionRepository;
	@Autowired
	public DireccionService(DireccionRepository direccionRepository) {
		
		this.direccionRepository = direccionRepository;
	}
	
	
	public void crearDireccion(Direccion direccion) {
		direccionRepository.save(direccion);
	}
	
	

	public Direccion buscarDireccionById(Long direccionId) {
        return direccionRepository.getById(direccionId);
               
    }

}
