package com.kukui.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kukui.models.Pedido;
import com.kukui.models.Usuario;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

List<Pedido> findAllByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);

List<Pedido> findByUsuario(Usuario usuario);



// Otros métodos personalizados

}