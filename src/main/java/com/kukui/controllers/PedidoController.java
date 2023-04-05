package com.kukui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kukui.models.Usuario;

import com.kukui.models.Pedido;
import com.kukui.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

@Autowired
private PedidoService pedidoService;

@GetMapping("/usuario/{idUsuario}")
public List<Pedido> obtenerPedidosPorUsuario(@PathVariable Long idUsuario) {
Usuario usuario = new Usuario();
usuario.setIdUsuario(idUsuario);
return pedidoService.buscarPedidosPorUsuario(usuario);
}

// Otros métodos del controlador para manejar otras solicitudes relacionadas con los pedidos

}
