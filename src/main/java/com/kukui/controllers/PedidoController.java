package com.kukui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kukui.models.Usuario;

import com.kukui.models.Pedido;
import com.kukui.models.Producto;
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





}
