package com.kukui.services;

import java.util.Optional;

import com.kukui.models.Direccion;
import com.kukui.repositories.DireccionRepository;

public class DireccionService {
	
	private DireccionRepository direccionRepository;
	
	public void crearDireccion(Direccion direccion) {
		direccionRepository.save(direccion);
	}
	
	public Optional<Direccion> buscarDireccionById(Long idDireccion) {
		Optional<Direccion> direccionBuscada = direccionRepository.findById(idDireccion);
		
		return direccionBuscada;
	}
	

}
