package com.kukui.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.server.ResponseStatusException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kukui.models.Pedido;
import com.kukui.models.Producto;
import com.kukui.models.Usuario;
import com.kukui.repositories.PedidoRepository;
import com.kukui.repositories.ProductoRepository;
import com.kukui.repositories.UsuarioRepository;

@Service
public class PedidoService {

@Autowired
private PedidoRepository pedidoRepository;

@Autowired
private ProductoRepository productoRepository;

@Autowired
private UsuarioRepository usuarioRepository;

public List<Pedido> buscarPedidosPorUsuario(Usuario usuario) {
return pedidoRepository.findByUsuario(usuario);
}

public void guardarPedido(Pedido pedido) {
pedidoRepository.save(pedido);
}




}