package com.kukui.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kukui.models.Pedido;
import com.kukui.models.Usuario;
import com.kukui.repositories.PedidoRepository;

@Service
public class PedidoService {

@Autowired
private PedidoRepository pedidoRepository;

public List<Pedido> buscarPedidosPorUsuario(Usuario usuario) {
return pedidoRepository.findByUsuario(usuario);
}

public void guardarPedido(Pedido pedido) {
pedidoRepository.save(pedido);
}
// Otros métodos de servicio para realizar operaciones sobre los pedidos, si es que los necesitas

}