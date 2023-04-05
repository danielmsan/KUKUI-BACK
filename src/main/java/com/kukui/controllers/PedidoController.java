package com.kukui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kukui.models.Usuario;
import com.kukui.repositories.PedidoRepository;
import com.kukui.repositories.UsuarioRepository;
import com.kukui.models.Direccion;
import com.kukui.models.Pedido;
import com.kukui.models.Producto;
import com.kukui.services.DireccionService;
import com.kukui.services.PedidoService;
import com.kukui.services.UsuarioService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

@Autowired
private PedidoService pedidoService;
@Autowired
private UsuarioService usuarioService;
@Autowired
private DireccionService direccionService;


@GetMapping("/usuario/{idUsuario}")

public List<Pedido> obtenerPedidosPorUsuario(@PathVariable Long idUsuario){
Usuario usuario = new Usuario();
usuario.setIdUsuario(idUsuario);
return pedidoService.buscarPedidosPorUsuario(usuario);

}




@PostMapping
public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido, @RequestParam Long usuarioId, @RequestParam Long direccionId) {
    Usuario usuario = usuarioService.obtenerUsuarioPorId(usuarioId);
    Optional<Direccion> direccion = direccionService.buscarDireccionById(direccionId);
    pedido.setUsuario(usuario);
    usuario.setDireccion(direccion);
    Pedido nuevoPedido = pedidoService.guardarPedido(pedido);
    return ResponseEntity.ok(nuevoPedido);
}

//@GetMapping("/{id}")
//public ResponseEntity<Pedido> obtenerPedido(@PathVariable Long id) {
  //  Pedido pedido = pedidoService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con id: " + id));
    //return ResponseEntity.ok(pedido);
//}
}
