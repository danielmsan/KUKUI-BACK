package com.kukui.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kukui.models.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    Optional<Direccion> findById(Long idDireccion);
}
